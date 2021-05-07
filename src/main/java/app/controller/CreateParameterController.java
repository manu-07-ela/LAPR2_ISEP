package app.controller;

import app.domain.model.Company;
import app.domain.store.ParameterCategoryStore;

/**
 * The Create Parameter Controller.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */

public class CreateParameterController {

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
    public CreateParameterController() {
        this.company=App.getInstance().getCompany();
    }

    /**
     * Instantiates a new Create Parameter Controller.
     * @param company
     */
    public CreateParameterController(Company company) {
        this.company = company;
        this.pcStore = null;

    }





}
