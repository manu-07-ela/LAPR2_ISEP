package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Test;
import app.domain.store.TestStore;
import java.util.Date;
import java.util.List;

public class SendCovid19ReportController {

    /**
     * Represents an instance of app.
     */
    private App app;

    /**
     * Represents a instance of company.
     */
    private Company company;
    /**
     * Represents a instance of test store
     */
    private TestStore tStore;
    /**
     * Represents a list of tests in a interval
     */
    private List<Test> lstCovidTestsByInterval;
    /**
     * Represents a list of historical points
     */
    private List<Test> covidTestsLstHistoricalPoints;

    /**
     * Constructs an instance of {@code SendCovid19ReportController}.
     */
    public SendCovid19ReportController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
    }

    /**
     * Constructs an instance of {@code SendCovid19ReportController} receiving a company.
     * @param company The company.
     */
    public SendCovid19ReportController(Company company) {
        this.app=App.getInstance();
        this.company =company;
    }

    /**
     * Get a list of the types of available type data in the system
     * @return the list of available type data in the system
     */
    public List<String> getAvailableTypesOfData(){
        return company.getAvailableTypesOfData();
    }

    /**
     * Get a list of the types of available regression models in the system
     * @return the list of available regression models in the system
     */
    public List<String> getAvailableRegressionModels(){
        return company.getAvailableRegressionModels();
    }

    /**
     * Create the covid-19 report
     * @param initialDate the initial date of the interval
     * @param endDate the end date of the interval
     * @param currentDay the current day
     * @param historicalPoints the historical points
     */
    public void createCovid19Report(Date initialDate, Date endDate, Date currentDay, int historicalPoints){
        this.tStore=company.getTestStore();
        this.lstCovidTestsByInterval=tStore.getCovidTestsLstByInterval(initialDate, endDate);
        this.covidTestsLstHistoricalPoints=tStore.getCovidTestsLstHistoricalPoints(currentDay,historicalPoints);
        //this.company.createCovid19Report(lstCovidTestsByInterval,covidTestsLstHistoricalPoints);
    }


}
