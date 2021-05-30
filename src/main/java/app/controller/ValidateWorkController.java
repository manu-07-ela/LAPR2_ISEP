package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.EmailNotification;
import app.domain.model.testrelated.SMSNotification;
import app.domain.model.testrelated.Test;
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
        emailNotification = new EmailNotification();
        smsNotification = new SMSNotification();
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
     * Gets the list of tests to validate.
     * @return list of tests to validate.
     */
    public List<TestDTO> getTestsToValidateList(){
        this.testStore=company.getTestStore();
        List<Test> testHasReportList = testStore.getTestHasReportList();
        return testMapper.toDto(testHasReportList);
    }

    /**
     * Get the test with the Internal Code
     * @param selectedTest Test that we intend to get.
     * @return the wanted test.
     */
    public Test getSelectedTest(TestDTO selectedTest){
        test = testStore.getTestByInternalCode(selectedTest.getInternalCode());
        return test;
    }

    /**
     * Creates test validation.
     * @return true if Test Validation is created. Otherwise, returns false.
     */
    public boolean createTestValidation(){
        return test.validateWork();
    }

    /**
     * Validates requested Date.
     * @param date Date to validate
     * @return true if Date is valid. Otherwise, returns false.
     */
    public boolean validateDate(String date){
        return test.validateDate(date);
    }

    /**
     * Shows the Registration Date formatted.
     * @return Registration Date formatted.
     */
    public String showRegistrationDate() {
        return dateMapper.toDto(test.getTestAddDate()).toString();
    }

    /**
     * Shows the Chemical Analysis Date formatted.
     * @return Chemical Analysis Date formatted.
     */
    public String showChemicalAnalysisDate() {
        return dateMapper.toDto(test.getChemicalAnalysisDate()).toString();
    }

    /**
     * Shows the Diagnosis Date formatted.
     * @return Diagnosis Date formatted.
     */
    public String showDiagnosisDate() {
        return dateMapper.toDto(test.getCreatedAt()).toString();
    }

    /**
     * Shows the Lab Coordinator Validation Date formatted.
     * @return Lab Coordinator Validation Date formatted.
     */
    public String showLabCoordValidationDate(Test selectedTest) {
        return dateMapper.toDto(selectedTest.getLabValidationDate()).toString();
    }

    /**
     * Shows the Registration Date, Chemical Analysis Date, Diagnosis Date, all formatted.
     * @return Registration Date, Chemical Analysis Date, Diagnosis Date, all formatted.
     */
    public String showDates() {
        return String.format("%s%n%s%n%s",showRegistrationDate(),showChemicalAnalysisDate(),showDiagnosisDate());
    }

    /**
     * Records the Lab Coordinator Validation Date
     * @param selectedTest Lab Coordinator Validation Date
     */
    public Boolean recordValidationDate(Test selectedTest) {
        return selectedTest.generateDataAndTimeLabCoordinatorValidation();

    }

    /**
     * Notifies the client via Email and SMS.
     * @param selectedTest
     */
    public void notifyTheClient(Test selectedTest) throws IOException {
        emailNotification.notification(selectedTest);
        smsNotification.notification(selectedTest);
    }
}
