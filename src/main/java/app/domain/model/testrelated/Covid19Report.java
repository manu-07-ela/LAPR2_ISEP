package app.domain.model.testrelated;

import app.SimpleLinearRegression;
import com.nhs.report.Report2NHS;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Covid19Report {

    private SimpleLinearRegression regression;

    private double[] xInterval;

    private double[] yInterval;

    private double[] xHistoricalPoints;

    private double[] yHistoricalPoints;

    private double confidenceLevel;

    private double significanceLevel;

    private String typeData;


    /**
     *
     */
    private String nhsReport;

    /**
     *
     */
    private List<Date> historicalPointsDate;

    /**
     *
     */
    private Date currentDay;

    private int historicalPoints;

    private List<String> dateInformation;


    /**
     * @param xInterval
     * @param yInterval
     * @param xHistoricalPoints
     * @param yHistoricalPoints
     * @param confidenceLevel
     * @param significanceLevel
     * @param currentDay
     * @param historicalPoints
     * @param typeOfData
     */

    public Covid19Report(double[] xInterval, double[] yInterval, double[] xHistoricalPoints, double[] yHistoricalPoints, double confidenceLevel, double significanceLevel, Date currentDay, int historicalPoints, String typeOfData) {
        this.xInterval = xInterval;
        this.yInterval = yInterval;
        this.xHistoricalPoints = xHistoricalPoints;
        this.yHistoricalPoints = yHistoricalPoints;
        this.confidenceLevel = confidenceLevel;
        this.significanceLevel = significanceLevel;
        this.currentDay=currentDay;
        this.historicalPoints=historicalPoints;
        this.typeData=typeOfData;
        regression = new SimpleLinearRegression(xInterval,yInterval,xHistoricalPoints,yHistoricalPoints,confidenceLevel,significanceLevel,dateInformation);
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
        } while (validDays<historicalPoints);

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
        date.setHours(date.getHours() - 7 * 24 * historicalPoints);
        for (int i = 0; i < historicalPoints; i++) {
            calendar.setTime(date);
            Date dateEnd = new Date(date.getTime());
            dateEnd.setHours(dateEnd.getHours() + 5 * 24);
            dateInformation.add(String.format("%s - %s",formatter.format(date),formatter.format(dateEnd)));
            date.setHours(date.getHours() + 7*24);
        }

        return dateInformation;
    }

    public void sendReportNhs() {
        Report2NHS.writeUsingFileWriter(nhsReport);
    }
}