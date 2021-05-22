package app.controller;

import app.domain.model.Company;
import app.domain.store.TestStore;


public class RecordResultsController {

    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of Test Store
     */
    private TestStore store;


    /**
     * Creates an instance of RecordResultsController
     */
    public RecordResultsController() {
        this(App.getInstance().getCompany());
    }
    /**
     * Creates an instance of RecordResultsController receiving the company
     * @param company The company
     */
    public RecordResultsController(Company company) {
        this.company = company;
        this.store = company.getTestStore();
    }




}
