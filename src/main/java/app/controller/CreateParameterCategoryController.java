package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;

/**
 *
 */

public class CreateParameterCategoryController {

    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore pcStore;

    /**
     *
     */
    public CreateParameterCategoryController() {
        this.company=App.getInstance().getCompany();
    }

    /**
     *
     * @param company
     */
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pc = null;
    }





}
