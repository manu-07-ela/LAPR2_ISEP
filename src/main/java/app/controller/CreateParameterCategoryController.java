package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;

/**
 * The Create Parameter Category Controller.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */

public class CreateParameterCategoryController {

    /**
     *
     */
    private Company company;

    /**
     *
     */
    private ParameterCategory pc;

    /**
     *
     */
    private ParameterCategoryStore pcStore;

    /**
     * Instantiates a new Create Parameter Category Controller.
     */
    public CreateParameterCategoryController() {
        this.company=App.getInstance().getCompany();
        this.pcStore=company.getParameterCategoryStore();
    }

    /**
     * Instantiates a new Create Parameter Category Controller.
     * @param company
     */
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pcStore=company.getParameterCategoryStore();
        this.pc = null;
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
    public boolean saveTestType() {
        return this.pcStore.saveParameterCategory(pc);
    }
}
