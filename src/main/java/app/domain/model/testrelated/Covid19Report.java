package app.domain.model.testrelated;

import app.MultipleLinearRegression;
import app.SimpleLinearRegression;
import app.interfaces.RegressionModel;
import com.nhs.report.Report2NHS;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Covid19Report {

    private String report;

    private RegressionModel regression;

    private double[] x1Interval;

    private double[] x2Interval;

    private double[] yInterval;

    private double[] x1HistoricalPoints;

    private double[] x2HistoricalPoints;

    private double[] yHistoricalPoints;

    private double confidenceLevel;

    private double significanceLevel;


    /**
     *
     */
    private Date currentDay;


    private List<String> dateInformation;


    /**
     * @param x1Interval
     * @param yInterval
     * @param x1HistoricalPoints
     * @param yHistoricalPoints
     * @param confidenceLevel
     * @param significanceLevel
     * @param currentDay
     */

    public Covid19Report(double[] x1Interval, double[] yInterval, double[] x1HistoricalPoints, double[] yHistoricalPoints, double confidenceLevel, double significanceLevel, Date currentDay, String typeOfDate) {
        this.x1Interval = x1Interval;
        this.yInterval = yInterval;
        this.x1HistoricalPoints = x1HistoricalPoints;
        this.yHistoricalPoints = yHistoricalPoints;
        this.confidenceLevel = confidenceLevel;
        this.significanceLevel = significanceLevel;
        this.currentDay=currentDay;
        if (typeOfDate.equals("Day")){
            this.dateInformation = getIntervalDates();
        }else {
            this.dateInformation = getHistoricalWeeks();
        }
        regression = new SimpleLinearRegression(x1Interval,yInterval, x1HistoricalPoints,yHistoricalPoints,confidenceLevel,significanceLevel,dateInformation);
        this.report = regression.regressionInformation();
    }

    public Covid19Report(double[] x1Interval, double[] x2Interval, double[] yInterval, double[] x1HistoricalPoints, double[] x2HistoricalPoints, double[] yHistoricalPoints, double confidenceLevel, double significanceLevel, String typeOfDate) {
        this.x1Interval = x1Interval;
        this.x2Interval = x2Interval;
        this.yInterval = yInterval;
        this.x1HistoricalPoints = x1HistoricalPoints;
        this.x2HistoricalPoints = x2HistoricalPoints;
        this.yHistoricalPoints = yHistoricalPoints;
        this.confidenceLevel = confidenceLevel;
        this.significanceLevel = significanceLevel;
        if (typeOfDate.equals("Day")){
            this.dateInformation = getIntervalDates();
        }else {
            this.dateInformation = getHistoricalWeeks();
        }
        regression = new MultipleLinearRegression(x1Interval, x2Interval, yInterval, confidenceLevel, significanceLevel,  dateInformation, yHistoricalPoints, x1HistoricalPoints, x2HistoricalPoints);
        this.report = regression.regressionInformation();
    }

    /**
     * @return
     */
    public List<String> getIntervalDates() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        dateInformation = new ArrayList<>();
        int validDays =0;
        Date dateAux = new Date(currentDay.getTime());
        do {
            dateAux.setHours(dateAux.getHours() -24);
            if(dateAux.getDay() != 0){
                dateInformation.add(formatter.format(dateAux));
                validDays++;
            }
        } while (validDays<yHistoricalPoints.length);

        return dateInformation;
    }

    public List<String> getHistoricalWeeks(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        dateInformation = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Date date = new Date(currentDay.getTime());
        date.setHours(date.getHours() - (day*24-48));
        date.setHours(date.getHours() - 7 * 24 * yHistoricalPoints.length);
        for (int i = 0; i < yHistoricalPoints.length; i++) {
            calendar.setTime(date);
            Date dateEnd = new Date(date.getTime());
            dateEnd.setHours(dateEnd.getHours() + 5 * 24);
            dateInformation.add(String.format("%s - %s",formatter.format(date),formatter.format(dateEnd)));
            date.setHours(date.getHours() + 7*24);
        }

        return dateInformation;
    }

    public void sendReportNhs() {
        Report2NHS.writeUsingFileWriter(report);
    }
}