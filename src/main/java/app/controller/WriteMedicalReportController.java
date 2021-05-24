package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestParameter;
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
     *
     * @return
     */
    public List<TestDTO> getTestHasSamplesAnalyzedList(){
        this.testStore=company.getTestStore();
        List<Test> testHasSamplesAnalyzedList = testStore.getTestHasSamplesAnalyzedList();
        return testMapper.toDto(testHasSamplesAnalyzedList);
    }

    /**
     *
     * @param selectedTest
     * @return
     */
    public List<TestParameterDTO> getTestParameterList(TestDTO selectedTest){
        test = testStore.getTestByInternalCode(selectedTest.getInternalCode());
        List<TestParameter> testParametersList =test.getTestParameterList();
        return testPMapper.toDTO(testParametersList);
    }

    /**
     *
     * @param diagnosis
     */
    public void addMedicalReport(String diagnosis){
        test.addMedicalReport(diagnosis);
    }

}

