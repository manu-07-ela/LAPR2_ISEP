package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.TestTypeStore;
import app.mappers.ParameterCategoryMapper;
import app.mappers.dto.ParameterCategoryDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * The Create Test Type Controller.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateTestTypeController {

    /**
     * Represents an instance of app.
     */
    private App app;

    /**
     * Represents a instance of company.
     */
    private Company company;

    /**
     * Represents an instance of the parameter category store.
     */
    private ParameterCategoryStore pcStore;

    /**
     * Represents an instance of the test type store.
     */
    private TestTypeStore ttStore;

    /**
     * Represents an instance of test type.
     */
    private TestType tt;

    /**
     * Represents an instance of the parameter category mapper
     */
    private ParameterCategoryMapper pcMapper;


    /**
     * Constructs an instance of {@code CreateTestTypeController}.
     */
    public CreateTestTypeController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.pcStore=company.getParameterCategoryStore();
        this.ttStore=company.getTestTypeStore();
        pcMapper = new ParameterCategoryMapper();
    }

    /**
     * Constructs an instance of {@code CreateTestTypeController} receiving a company.
     * @param company The company.
     */
    public CreateTestTypeController(Company company) {
        this.app=App.getInstance();
        this.company =company;
        this.pcStore=company.getParameterCategoryStore();
        this.ttStore=company.getTestTypeStore();
        pcMapper = new ParameterCategoryMapper();
    }

    /**
     * Get a list of objects of type ParameterCategoryDTO
     * @return list with parameterCategoriesDto
     */
    public List<ParameterCategoryDTO> getParameterCategories(){
        List<ParameterCategory> listParameterCategories = pcStore.getParameterCategoryList();
        return pcMapper.toDto(listParameterCategories);
    }

    /**
     * New test type.
     * @param code The test type code.
     * @param description The description of the test type.
     * @param collectingMethod The test type collecting method.
     * @param listOfParameterCategoriesDto List of parameter categories that the test type has associated.
     * @return false if the test type already exists or is null. Otherwise, it returns true.
     */
    public boolean createTestType(String code, String description, String collectingMethod, List<ParameterCategoryDTO> listOfParameterCategoriesDto,String referenceAdapter){
        List<ParameterCategory> listOfParameterCategories = new ArrayList();
        for ( ParameterCategoryDTO pcDto : listOfParameterCategoriesDto){
            listOfParameterCategories.add(pcStore.getParameterCategoryByCode(pcDto.getCode()));
        }
        this.tt=ttStore.createTestType(code,description,collectingMethod,listOfParameterCategories,referenceAdapter);
        return this.ttStore.validateTestType(tt);
    }

    /**
     * Save the type of test case it is in a valid state.
     * @return true if the test type was saved. Otherwise, false.
     */
    public boolean saveTestType() {
        return this.ttStore.saveTestType(tt);
    }

    /**
     * Textual description of the test type.
     * @return Information about the characteristics of the test type.
     */
    public String toString(){
        return tt.toString();
    }

}
