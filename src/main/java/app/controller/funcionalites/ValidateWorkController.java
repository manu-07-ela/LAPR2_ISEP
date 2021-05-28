package app.controller.funcionalites;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.testRelated.Test;
import app.domain.store.TestStore;
import app.mappers.DateMapper;
import app.mappers.TestMapper;
import app.mappers.dto.TestDTO;

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
    public String showDiagnosisDate(Test selectedTest) {
        return dateMapper.toDto(test.getCreatedAt()).toString();
    }
}
