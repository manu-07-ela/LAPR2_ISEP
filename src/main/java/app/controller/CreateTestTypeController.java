package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.TestTypeStore;
import app.mappers.ParameterCategoryMapper;
import app.mappers.dto.ParameterCategoryDto;

import java.util.List;

/**
 * The Create Test Type Controller.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateTestTypeController {

    /**
     *
     */
    private App app;

    /**
     *
     */
    private Company company;

    /**
     *
     */
    private ParameterCategoryStore pcStore;

    /**
     *
     */
    private TestTypeStore ttStore;

    /**
     *
     */
    private TestType tt;

    /**
     *
     */
    private ParameterCategoryMapper pcMapper;

    /**
     * Instantiates a new Create Test Type Controller.
     */
    public CreateTestTypeController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.pcStore=company.getParameterCategoryStore();
        this.ttStore=company.getTestTypeStore();
        pcMapper = new ParameterCategoryMapper();
    }

    /**
     * Instantiates a new Create Test Type Controller.
     * @param company
     */
    public CreateTestTypeController(Company company) {
        this.company = company;
        this.pcStore=company.getParameterCategoryStore();
        this.ttStore=company.getTestTypeStore();
        pcMapper = new ParameterCategoryMapper();
    }

    /**
     * New test type.
     * @param code The test type code.
     * @param description The description of the test type.
     * @param collectingMethod The test type collecting method.
     * @param listOfParameterCategories List of parameter categories that the test type has associated.
     * @return false if the test type already exists or is null. Otherwise, it returns true.
     */
    public boolean createTestType(String code, String description, String collectingMethod, List<ParameterCategory> listOfParameterCategories){
        this.tt=ttStore.createTestType(code,description,collectingMethod,listOfParameterCategories);
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
     *
     * @return
     */
    public List<ParameterCategoryDto> getParameterCategories(){
        List<ParameterCategory> listParameterCategories = pcStore.getParameterCategoryList();
        ParameterCategoryMapper mapper = new ParameterCategoryMapper();
        return mapper.toDto(listParameterCategories);
    }






}
