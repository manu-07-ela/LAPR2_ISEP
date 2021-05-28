package app.controller;

import app.domain.model.Company;
<<<<<<< HEAD
import app.domain.model.EmailNotification;
import app.domain.model.SMSNotification;
import app.domain.model.Test;
=======
import app.domain.model.testRelated.Test;
>>>>>>> 58bd95b64fcac10326d1ff69eab00c2696a7fbb6
import app.domain.store.TestStore;
import app.mappers.DateMapper;
import app.mappers.TestMapper;
import app.mappers.dto.TestDTO;

import java.io.IOException;
import java.util.List;

/**
 * The Validate Work Controller.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */

public class ValidateWorkController {

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
     * Represents an instance of the test mapper
     */
    private DateMapper dateMapper;

    /**
     * Represents an instance of the Email Notification
     */
    private EmailNotification emailNotification;

    /**
     * Represents an instance of the SMS Notification
     */
    private SMSNotification smsNotification;

    /**
     * Constructs an instance of {@code ValidateWorkController}.
     */
    public ValidateWorkController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        testMapper = new TestMapper();
        dateMapper = new DateMapper();
    }

    /**
     * Constructs an instance of {@code ValidateWorkController} receiving a company.
     * @param company The company.
     */
    public ValidateWorkController(Company company) {
        this.app=App.getInstance();
        this.company =company;
        testMapper = new TestMapper();
        dateMapper = new DateMapper();
    }

    /**
     *
     * @return
     */
    public List<TestDTO> getTestsToValidateList(){
        this.testStore=company.getTestStore();
        List<Test> testHasReportList = testStore.getTestHasReportList();
        return testMapper.toDto(testHasReportList);
    }

    /**
     *
     * @param selectedTest
     * @return
     */
    public boolean createTestValidation(Test selectedTest){
        return test.validateWork(selectedTest);
    }

    /**
     *
     */
    public String showRegistrationDate(Test selectedTest) {
        return dateMapper.toDto(selectedTest.getRegisterTestDate()).toString();
    }

    /**
     *
     */
    public String showChemicalAnalysisDate(Test selectedTest) {
        return dateMapper.toDto(selectedTest.getChemicalAnalysisDate()).toString();
    }

    /**
     *
     */
    public String showDiagnosisDate(Test selectedTest) {
        return dateMapper.toDto(selectedTest.getCreatedAt()).toString();
    }

    /**
     *
     */
    public void showDates(Test selectedTest) {
        showRegistrationDate(selectedTest);
        showChemicalAnalysisDate(selectedTest);
        showDiagnosisDate(selectedTest);
    }

    /**
     *
     */
    public Boolean recordValidationDate(Test selectedTest) {
        return selectedTest.validateWork(selectedTest);
    }

    /**
     *
     */
    public void notifyTheClient(Test selectedTest) throws IOException {
        emailNotification.notifyByEmail(selectedTest);
        smsNotification.notifyBySMS(selectedTest);
    }


}
