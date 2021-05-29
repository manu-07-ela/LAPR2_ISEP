package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.TestParameter;
import app.domain.store.TestStore;
import app.mappers.TestMapper;
import app.mappers.TestParameterMapper;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDTO;

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
     * Represents an instance of the test parameter mapper
     */
    private TestParameterMapper testPMapper;

    /**
     * Constructs an instance of {@code WriteMedicalReportController}.
     */
    public WriteMedicalReportController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        testMapper = new TestMapper();
        testPMapper = new TestParameterMapper();
    }

    /**
     * Constructs an instance of {@code WriteMedicalReportController} receiving a company.
     * @param company The company.
     */
    public WriteMedicalReportController(Company company) {
        this.app=App.getInstance();
        this.company =company;
        testMapper = new TestMapper();
        testPMapper = new TestParameterMapper();
    }


    /**
     * Get a list of objects of type TestDTO.
     * @return list with the tests with the analyzed samples.
     */
    public List<TestDTO> getTestHasSamplesAnalyzedList(){
        this.testStore=company.getTestStore();
        checkPossibilityOfWriteAReport(testStore.getTestHasSamplesAnalyzedList());
        List<Test> testHasSamplesAnalyzedList = testStore.getTestHasSamplesAnalyzedList();
        return testMapper.toDto(testHasSamplesAnalyzedList);
    }

    /**
     * Check if there is any test waiting for the medical report.
     */
    public void checkPossibilityOfWriteAReport(List<Test> testHasSamplesAnalyzedList){
        if (testHasSamplesAnalyzedList.isEmpty())
            throw new IllegalArgumentException("There are no tests with the samples analyzed.");
    }

    /**
     * Get the list with the information of the analyzed parameters of the test that we are getting the diagnosis.
     * @param selectedTest Test that we intend to write the medical report.
     * @return the list with the information of the analyzed parameters of the test.
     */
    public List<TestParameterDTO> getTestParameterList(TestDTO selectedTest){
        test = testStore.getTestByInternalCode(selectedTest.getInternalCode());
        List<TestParameter> testParametersList =test.getTestParameterList();
        return testPMapper.toDTO(testParametersList);
    }


    /**
     * Add the medical report to the test.
     * @param diagnosis The diagnosis made by the specialist doctor.
     * @return true if the medical report was added. Otherwise, false.
     */
    public boolean addMedicalReport(String diagnosis){
        return test.addMedicalReport(diagnosis);
    }

}

