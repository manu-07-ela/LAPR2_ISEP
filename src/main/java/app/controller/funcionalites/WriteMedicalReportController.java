package app.controller.funcionalites;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.testRelated.Test;
import app.domain.model.testRelated.TestParameter;
import app.domain.store.TestStore;
import app.mappers.TestMapper;
import app.mappers.TestParameterMapper;
import app.mappers.dto.TestDto;
import app.mappers.dto.TestParameterDto;

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
     *
     * @return
     */
    public List<TestDto> getTestHasSamplesAnalyzedList(){
        this.testStore=company.getTestStore();
        checkPossibilityOfWriteAReport(testStore.getTestHasSamplesAnalyzedList());
        List<Test> testHasSamplesAnalyzedList = testStore.getTestHasSamplesAnalyzedList();
        return testMapper.toDto(testHasSamplesAnalyzedList);
    }

    /**
     *
     */
    public void checkPossibilityOfWriteAReport(List<Test> testHasSamplesAnalyzedList){
        if (testHasSamplesAnalyzedList.size() == 0)
            throw new IllegalArgumentException("There are no tests with the samples analyzed.");
    }

    /**
     *
     * @param selectedTest
     * @return
     */
    public List<TestParameterDto> getTestParameterList(TestDto selectedTest){
        test = testStore.getTestByInternalCode(selectedTest.getInternalCode());
        List<TestParameter> testParametersList =test.getTestParameterList();
        return testPMapper.toDTO(testParametersList);
    }


    /**
     *
     * @param diagnosis
     * @return
     */
    public boolean addMedicalReport(String diagnosis){
        return test.addMedicalReport(diagnosis);
    }

}

