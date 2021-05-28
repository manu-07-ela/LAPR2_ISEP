package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.store.ParameterCategoryStore;

/**
 * The Create Parameter Category Controller.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */

public class CreateParameterCategoryController {

    /**
     * Represents an instance of app.
     */
    private App app;

    /**
     * Represents a instance of company.
     */
    private Company company;

    /**
     * Represents an instance of parameter category.
     */
    private ParameterCategory pc;

    /**
     * Represents an instance of the parameter category store.
     */
    private ParameterCategoryStore pcStore;

    /**
     * Constructs an instance of {@code CreateParameterCategoryController}.
     */
    public CreateParameterCategoryController() {
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.pcStore=company.getParameterCategoryStore();
    }

    /**
     * Constructs an instance of {@code CreateParameterCategoryController} receiving a company.
     * @param company The company.
     */
    public CreateParameterCategoryController(Company company) {
        this.app=App.getInstance();
        this.company = company;
        this.pcStore=company.getParameterCategoryStore();
    }

    /**
     * New parameter category.
     * @param code The parameter category code.
     * @param name The parameter category name.
     * @return false if the parameter category already exists or is null. Otherwise, it returns true.
     */
    public boolean createParameterCategory(String code, String name){
        this.pc=pcStore.createParameterCategory(code,name);
        return this.pcStore.validateParameterCategory(pc);
    }

    /**
     * Save the parameter category case it is in a valid state.
     * @return true if the parameter category was saved. Otherwise, false.
     */
    public boolean saveParameterCategory() {
        return this.pcStore.saveParameterCategory(pc);
    }

    /**
     * Textual description of the parameter category.
     * @return Information about the characteristics of the parameter category.
     */
    @Override
    public String toString(){
        return pc.toString();
    }
}
