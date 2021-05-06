package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.TestTypeStore;
import app.mappers.dto.ParameterCategoryDto;

import java.util.List;

/**
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateTestTypeController {

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
    private ParameterCategoryDto pcDto;

    /**
     *
     */
    private TestType tt;

    /**
     *
     */
    public CreateTestTypeController(){
        this.company=App.getInstance().getCompany();
        this.pcStore=company.getParameterCategoryStore();
        this.ttStore=company.getTestTypeStore();
    }

    /**
     *
     * @param company
     */
    public CreateTestTypeController(Company company) {
        this.company = company;
        this.pcStore=company.getParameterCategoryStore();
        this.ttStore=company.getTestTypeStore();
    }

    /**
     *
     * @param code
     * @param description
     * @param collectingMethod
     * @param listOfParameterCategories
     * @return
     */
    public boolean createTestType(String code, String description, String collectingMethod, List<ParameterCategory> listOfParameterCategories){
        this.tt=ttStore.createTestType(code,description,collectingMethod,listOfParameterCategories);
        return this.ttStore.validateTestType(tt);
    }




}
