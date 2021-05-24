package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.ParameterCategoryMapper;
import app.mappers.TestMapper;

import java.util.List;

/**
 * The Write Medical Report Controller.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class WriteMedicalReportController {

    /**
     * Represents an instance of app.
     */
    private App app;

    /**
     * Represents a instance of company.
     */
    private Company company;

    /**
     * Represents an instance of the test store.
     */
    private TestStore testStore;

    /**
     * Represents an instance of test.
     */
    private Test test;

    /**
     * Represents an instance of the test mapper
     */
    private TestMapper testMapper;

    /**
     * Constructs an instance of {@code WriteMedicalReportController}.
     */
    public WriteMedicalReportController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
    }

    /**
     * Constructs an instance of {@code WriteMedicalReportController} receiving a company.
     * @param company The company.
     */
    public WriteMedicalReportController(Company company) {
        this.app=App.getInstance();
        this.company =company;
    }

    /*
    public List<Test> getTestHasSamplesAnalyzedList(){

    }
     */


}
