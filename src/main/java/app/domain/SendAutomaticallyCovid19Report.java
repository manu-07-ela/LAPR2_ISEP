package app.domain;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.testrelated.Covid19Report;
import app.domain.shared.Constants;
import app.domain.store.TestStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SendAutomaticallyCovid19Report {
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

    public SendAutomaticallyCovid19Report(Company company){
        this.company = company;
        tStore = company.getTestStore();
    }

    public Covid19Report createCovid19ReportSimple(Date initialDate, Date endDate, Date currentDay, int historicalPoints, String typeOfData, String independentVariable, double significanceLevel, double confidenceLevel) throws ParseException {
        double[] x1HistoricalPoints;
        double[] x1Interval;
        double[] yHistoricalPoints;
        double[] yInterval;
        this.tStore = company.getTestStore();

        if (independentVariable.equals("Tests Performed")){
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate,endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForDayHistoricalPoints(currentDay,historicalPoints);
            x1Interval = tStore.getNumberOfTestsPerformedForDayInInterval(initialDate,endDate);
            x1HistoricalPoints = tStore.getNumberOfTestsPerformedForDayHistoricalPoints(currentDay,historicalPoints);
        }else{
            yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate,endDate);
            yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForDayHistoricalPoints(currentDay,historicalPoints);
            x1Interval = tStore.getMeanAgeForDayInInterval(initialDate,endDate);
            x1HistoricalPoints = tStore.getMeanAgeForDayHistoricalPoints(currentDay,historicalPoints);
        }
        return this.company.createCovid19ReportSimple(x1Interval,yInterval,x1HistoricalPoints,yHistoricalPoints,confidenceLevel,significanceLevel,currentDay,typeOfData);

    }

    public Covid19Report createCovid19ReportMultiple(Date initialDate, Date endDate, Date currentDay, int historicalPoints, String typeOfData, double significanceLevel, double confidenceLevel) throws ParseException {
        double[] x1HistoricalPoints;
        double[] x1Interval;
        double[] x2HistoricalPoints;
        double[] x2Interval;
        double[] yHistoricalPoints;
        double[] yInterval;
        this.tStore = company.getTestStore();
        yInterval = tStore.getNumberOfPositiveCovidTestsForDayInInterval(initialDate,endDate);
        yHistoricalPoints = tStore.getNumberOfPositiveCovidTestsForDayHistoricalPoints(currentDay,historicalPoints);
        x1Interval = tStore.getNumberOfTestsPerformedForDayInInterval(initialDate,endDate);
        x1HistoricalPoints = tStore.getNumberOfTestsPerformedForDayHistoricalPoints(currentDay,historicalPoints);
        x2Interval = tStore.getMeanAgeForDayInInterval(initialDate, endDate);
        x2HistoricalPoints = tStore.getMeanAgeForDayHistoricalPoints(currentDay, historicalPoints);
        return this.company.createCovid19ReportMultiple(x1Interval,x2Interval,yInterval,x1HistoricalPoints,x2HistoricalPoints, yHistoricalPoints,confidenceLevel,significanceLevel,currentDay,typeOfData);
    }

    public void readFromConfigurationFile() throws ParseException {
        Covid19Report covid19ReportTestDay, covid19ReportAgeDay, covid19ReportMultipleDay, covidReportWeeks;
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        String classAux = props.getProperty("Company.Regression.Class");
        String date = props.getProperty("Company.DateInterval");
        String[] dates = date.split("-");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date initialDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);
        Date currentDate = format.parse(format.format(new Date()));
        int historicalPoints = Integer.parseInt(props.getProperty("Company.HistoricalPoints"));
        Double confidenceLevel = Double.parseDouble(props.getProperty("Company.ConfidenceLevel"));
        Double significanceLevel = Double.parseDouble(props.getProperty("Company.SignificanceLevel"));
        if (classAux.equals("app.SimpleLinearRegression")){
            covid19ReportTestDay = createCovid19ReportSimple(initialDate, endDate,currentDate, historicalPoints,"Day", "Tests performed",significanceLevel,confidenceLevel);
            covid19ReportAgeDay = createCovid19ReportSimple(initialDate, endDate,currentDate, historicalPoints,"Day", "Mean Age",significanceLevel,confidenceLevel);
            if (covid19ReportTestDay.r2()>covid19ReportAgeDay.r2()){
                covidReportWeeks = createCovid19ReportSimple(initialDate, endDate, currentDate, historicalPoints, "Week", "Tests performed", significanceLevel, confidenceLevel);
                company.sendCovid19Report(covid19ReportTestDay.getReport() +"\n"+covidReportWeeks.getReport());
            }else {
                covidReportWeeks = createCovid19ReportSimple(initialDate, endDate, currentDate, historicalPoints, "Week", "Mean Age", significanceLevel, confidenceLevel);
                company.sendCovid19Report(covid19ReportAgeDay.getReport() +"\n"+covidReportWeeks.getReport());
            }
        }else if(classAux.equals("app.MultipleLinearRegression")){
            covid19ReportMultipleDay = createCovid19ReportMultiple(initialDate, endDate, currentDate, historicalPoints, "Day", significanceLevel, confidenceLevel);
            covidReportWeeks = createCovid19ReportMultiple(initialDate, endDate, currentDate, historicalPoints, "Week", significanceLevel, confidenceLevel);
            company.sendCovid19Report(covid19ReportMultipleDay.getReport() +"\n"+covidReportWeeks.getReport());
        }
    }
}
