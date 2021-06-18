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

    private TestStore tStore;

    private List<Test> lstCovidTestsByInterval;

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

    public List<String> getAvailableTypesOfData(){
        return company.getAvailableTypesOfData();
    }

    public List<String> getAvailableRegressionModels(){
        return company.getAvailableRegressionModels();
    }

    public List<String> getAvailableIndependentVariable(){
        return company.getAvailableIndependentVariables();
    }

    public void createCovid19Report(Date initialDate, Date endDate, Date currentDay, int historicalPoints, String typeOfData, String regressionModel, String independentVariable, double significanceLevel, double confidenceLevel){
        this.tStore=company.getTestStore();
        this.lstCovidTestsByInterval=tStore.getCovidTestsLstByInterval(initialDate, endDate);
        this.covidTestsLstHistoricalPoints=tStore.getCovidTestsLstHistoricalPoints(currentDay,historicalPoints);
        this.company.createCovid19Report(lstCovidTestsByInterval,covidTestsLstHistoricalPoints,initialDate,endDate,currentDay,historicalPoints);
    }


}
