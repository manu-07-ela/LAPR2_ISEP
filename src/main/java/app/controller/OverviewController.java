package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Overview;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.TestParameterResult;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.TestMapper;
import app.mappers.TestParameterMapper;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class OverviewController {

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

    private Overview overview;

    /**
     * Constructs an instance of {@code OverviewController}.
     */
    public OverviewController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
    }

    /**
     * Constructs an instance of {@code OverviewController} receiving a company.
     * @param company The company.
     */
    public OverviewController(Company company) {
        this.app=App.getInstance();
        this.company =company;
    }

    public void getIntervalTestList(Date initialDate, Date endDate) throws ParseException {
        this.testStore=company.getTestStore();
        List<Test> testList = testStore.getIntervalTestList(initialDate, endDate);
        this.overview=new Overview(initialDate,endDate,testList);
    }

    public int getNumberOfClients(){
        return overview.getNumberOfClients();
    }

    public int  getNumberOfTestsWaitingForResults(){
        return overview.getNumberOfTestWaitingForResults();
    }

    public int  getNumberOfTestsWaitingForDiagnosis(){
        return overview.getNumberOfTestsWaitingForDiagnosis();
    }

    public int  getTotalNumberOfTestsProcessed(){
        return overview.getTotalNumberOfTestsProcessed();
    }

    public List<String> getAvailableAlgorithms(){
        return overview.getAvailableAlgorithms();
    }

    public int[] getSubsequenceWithMaximumSum(String algorithm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return overview.getSubsequenceWithMaximumSum(algorithm);
    }

}
