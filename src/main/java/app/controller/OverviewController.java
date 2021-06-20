package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Overview;
import app.domain.model.testrelated.Test;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
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

    /**
     * Represents an instance of the client store.
     */
    private ClientStore clientStore;
    /**
     * Represents an instance of Overview
     */
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

    /**
     * Process data from the date range
     * @param initialDate the initial date of the interval
     * @param endDate the end date of the interval
     * @throws ParseException if the conversion of dates does not go well
     */
    public void getIntervalTestList(Date initialDate, Date endDate) throws ParseException {
        this.testStore=company.getTestStore();
        List<Test> testList = testStore.getIntervalTestList(initialDate, endDate);
        this.overview=company.createOverview(initialDate,endDate,testList);
    }

    /**
     * Get the number of clients in the system
     * @return the number of clients in the system
     */
    public int getNumberOfClients(){
        return overview.getNumberOfClients();
    }

    /**
     * Gets the number of tests in the system
     * @return the number of tests in the system
     */
    public int getNumberTestsSystem(){
        return testStore.getTestList().size();
    }

    /**
     * Gets the number of the clients in the system
     * @return the number of the clients in the system
     */
    public int getNumberClientsSystem(){
        this.clientStore=company.getClientStore();
        return clientStore.getClientList().size();
    }

    /**
     * Gets the date of the clients
     * @return the date of the clients
     */
    public List<Date> getDates(){
        return overview.getDates();
    }

    /**
     * Get the number of tests waiting for results in the system
     * @return the number of tests waiting for results in the system
     */
    public List<Integer>  getNumberOfTestsWaitingForResults(){
        return overview.getTestWaitingForResults();
    }

    public List<Date> getIntervalDates(){
        return overview.getIntervalDates();
    }
    /**
     * Get the number of tests waiting for diagnosis in the system
     * @return the number of tests waiting for diagnosis in the system
     */
    public List<Integer>  getNumberOfTestsWaitingForDiagnosis(){
        return overview.getTestsWaitingForDiagnosis();
    }

    /**
     * Get the number of tests processed in the system
     * @return the number of tests processed in the system
     */
    public List<Integer> getTotalNumberOfTestsProcessed(){
        return overview.getTestProcessed();
    }

    /**
     * The list of available algorithms in the system
     * @return the list of algorithms
     */
    public List<String> getAvailableAlgorithms(){
        return overview.getAvailableAlgorithms();
    }

    /**
     * Get the maximum subsequence of a interval
     * @param algorithm algorithm to be used for calculation of the maximum subsequence
     * @return the subsequence maximum
     * @throws ClassNotFoundException if it is not possible to instantiate the desired class
     * @throws IllegalAccessException if the object we intend to create it's not  correctly
     * @throws InstantiationException if we can't instantiate an object
     */
    public int[] getSubsequenceWithMaximumSum(String algorithm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return overview.getSubsequenceWithMaximumSum(algorithm);
    }

    /**
     * Sets an algorithm
     * @param algorithm A algorithm
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void sendAlgorithm(String algorithm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        overview.setAlgorithm(algorithm);
    }

    /**
     * Gets the Period Sub Sequence
     * @return the Period Sub Sequence
     */
    public String[] getPeriodSubSequenceMaxSum(){
        return overview.getPeriodSubSequenceMaxSum();
    }

    /**
     * Get the sequence
     * @return the sequence
     */
    public int[] getSequence(){
        return overview.getSequence();
    }

}
