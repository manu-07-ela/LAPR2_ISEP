package app.controller;

import app.domain.model.Company;

import app.domain.model.testrelated.EmailNotification;
import app.domain.model.testrelated.LabCoordinatorValidation;
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
     *
     * @return
     */
    public List<TestDTO> getTestsToValidateList(){
        this.testStore=company.getTestStore();
        List<Test> testHasReportList = testStore.getTestHasReportList();
        return testMapper.toDto(testHasReportList);
    }

    /**
     * @param selectedTest
     */
    public Test getSelectedTest(TestDTO selectedTest){
        test = testStore.getTestByInternalCode(selectedTest.getInternalCode());
        return test;
    }

    /**
     *
     * @return
     */
    public boolean createTestValidation(){
        return test.validateWork();
    }

    /**
     * Confirm the Date according to the requested date to confirm.
     * @param date
     */
    public boolean checkDate(String date){
        if (date.equals("Registration Date")){
            return true;
        } else if ( date.equals("Chemical Analysis Date")){
            return true;
        } else if ( date.equals("Diagnosis Date")){
            return true;
        } else {
            System.out.println("Not available to check.");
        }
        return false;
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
    public String showChemicalAnalysisDate(Test selectedTest) {
        return dateMapper.toDto(selectedTest.getChemicalAnalysisDate()).toString();
    }

    /**
     * Shows the Diagnosis Date formatted.
     * @return Diagnosis Date formatted.
     */
    public String showDiagnosisDate(Test selectedTest) {
        return dateMapper.toDto(selectedTest.getCreatedAt()).toString();
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
    public String showDates(Test selectedTest) {
        return String.format("%s%n%s%n%s%n",showRegistrationDate(),showChemicalAnalysisDate(selectedTest),showDiagnosisDate(selectedTest));
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
