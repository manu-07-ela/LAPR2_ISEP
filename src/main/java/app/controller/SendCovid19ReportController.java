package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Covid19Report;
import app.domain.model.testrelated.Test;
import app.domain.store.TestStore;
import java.text.ParseException;
import java.util.Arrays;
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
     * Get the list of available independents variables
     * @return the list of independent variables
     */
    public List<String> getAvailableIndependentVariable(){
        return company.getAvailableIndependentVariables();
    }


    public Covid19Report sendCovid19Report(Date initialDate, Date endDate, Date currentDay, int historicalPoints, String typeOfData, String independentVariable, double significanceLevel, double confidenceLevel) throws ParseException {
        double[] x1HistoricalPoints;
        double[] x1Interval;
        double[] yHistoricalPoints;
        double[] yInterval;
        Covid19Report covid19Report = null;
        this.tStore = company.getTestStore();
        if (independentVariable.equalsIgnoreCase("Tests Performed") && typeOfData.equalsIgnoreCase("Days")) {
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate, endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForDayHistoricalPoints(currentDay, historicalPoints);
            x1Interval = tStore.getNumberOfTestsPerformedForDayInInterval(initialDate, endDate);
            x1HistoricalPoints = tStore.getNumberOfTestsPerformedForDayHistoricalPoints(currentDay, historicalPoints);
            covid19Report = this.company.createCovid19ReportSimple(x1Interval, yInterval, x1HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
        } else if (independentVariable.equalsIgnoreCase("Mean Age") && typeOfData.equalsIgnoreCase("Days")){
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate, endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForDayHistoricalPoints(currentDay, historicalPoints);
            x1Interval = tStore.getMeanAgeForDayInInterval(initialDate, endDate);
            x1HistoricalPoints = tStore.getMeanAgeForDayHistoricalPoints(currentDay, historicalPoints);
            covid19Report = this.company.createCovid19ReportSimple(x1Interval, yInterval, x1HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
        }else if (independentVariable.equals("Tests Performed") && typeOfData.equalsIgnoreCase("Weeks")){
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate, endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForWeekHistoricalPoints(currentDay, historicalPoints);
            x1Interval = tStore.getNumberOfTestsPerformedForDayInInterval(initialDate, endDate);
            x1HistoricalPoints = tStore.getNumberOfTestsPerformedForWeekHistoricalPoints(initialDate, historicalPoints);
            covid19Report = this.company.createCovid19ReportSimple(x1Interval, yInterval, x1HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
        }else if (independentVariable.equals("Mean Age") && typeOfData.equalsIgnoreCase("Weeks")){
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate, endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForWeekHistoricalPoints(currentDay, historicalPoints);
            x1Interval = tStore.getMeanAgeForDayInInterval(initialDate, endDate);
            x1HistoricalPoints = tStore.getMeanAgeForWeekHistoricalPoints(initialDate, historicalPoints);
            covid19Report = this.company.createCovid19ReportSimple(x1Interval, yInterval, x1HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
        }

        company.sendCovid19Report(covid19Report.getReport());
        return covid19Report;

    }

    public Covid19Report sendCovid19ReportMultiple(Date initialDate, Date endDate, Date currentDay, int historicalPoints, String typeOfData, double significanceLevel, double confidenceLevel) throws ParseException {
        double[] x1HistoricalPoints;
        double[] x1Interval;
        double[] x2HistoricalPoints;
        double[] x2Interval;
        double[] yHistoricalPoints;
        double[] yInterval;
        Covid19Report covid19Report;
        this.tStore = company.getTestStore();
        if (typeOfData.equalsIgnoreCase("Days")){
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate, endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForDayHistoricalPoints(currentDay, historicalPoints);
            x1Interval = tStore.getNumberOfTestsPerformedForDayInInterval(initialDate, endDate);
            x1HistoricalPoints = tStore.getNumberOfTestsPerformedForDayHistoricalPoints(currentDay, historicalPoints);
            x2Interval = tStore.getMeanAgeForDayInInterval(initialDate, endDate);
            x2HistoricalPoints = tStore.getMeanAgeForDayHistoricalPoints(currentDay, historicalPoints);
            covid19Report = this.company.createCovid19ReportMultiple(x1Interval, x2Interval, yInterval, x1HistoricalPoints, x2HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
        }else {
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate, endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForWeekHistoricalPoints(currentDay, historicalPoints);
            x1Interval = tStore.getNumberOfTestsPerformedForDayInInterval(initialDate, endDate);
            x1HistoricalPoints = tStore.getNumberOfTestsPerformedForWeekHistoricalPoints(currentDay, historicalPoints);
            x2Interval = tStore.getMeanAgeForDayInInterval(initialDate, endDate);
            x2HistoricalPoints = tStore.getMeanAgeForWeekHistoricalPoints(currentDay, historicalPoints);
            covid19Report = this.company.createCovid19ReportMultiple(x1Interval, x2Interval, yInterval, x1HistoricalPoints, x2HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
        }
        company.sendCovid19Report(covid19Report.getReport());
        return covid19Report;
    }

}




