package app.domain.model.testrelated;

import app.SimpleLinearRegression;
import com.nhs.report.Report2NHS;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Covid19Report {

    private SimpleLinearRegression regression;

    private String nhsReport;

    private List<Date> historicalPointsDate;

    private Date currentDay;

    private int historicalPoints;

    private double[] xInterval;

    private double[] yInterval;

    private double[] xHistoricalPoints;

    private double[] yHistoricalPoints;

    private double confidenceLevel;

    private double significanceLevel;

    private String typeData;

    private List<String> datesHistoricalPoints;


    public Covid19Report(double[] xInterval,double[] yInterval,double[] xHistoricalPoints,double[] yHistoricalPoints,double confidenceLevel,double significanceLevel,Date currentDay,int historicalPoints,String typeOfData){
        this.xInterval=xInterval;
        this.yInterval=yInterval;
        this.xHistoricalPoints=xHistoricalPoints;
        this.yHistoricalPoints=yHistoricalPoints;
        this.confidenceLevel=confidenceLevel;
        this.significanceLevel=significanceLevel;
        this.currentDay=currentDay;
        this.historicalPoints=historicalPoints;
        this.typeData=typeOfData;
        this.datesHistoricalPoints=getHistoricalDates();
        regression = new SimpleLinearRegression(xInterval,yInterval,xHistoricalPoints,yHistoricalPoints,confidenceLevel,significanceLevel,datesHistoricalPoints);
    }

    public List<String> getHistoricalDates(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        historicalPointsDate = new ArrayList();
        int validDays=0;
        Date dateAux = new Date(currentDay.getTime());
        do {
            dateAux.setHours(dateAux.getHours() - 24);
            if(dateAux.getDay()!=0) {
                validDays++;
                historicalPointsDate.add(dateAux);
            }
        }while (validDays<historicalPoints);
        datesHistoricalPoints = new ArrayList<>();
        for(Date d : historicalPointsDate){
            datesHistoricalPoints.add(formatter.format(d));
        }
        return datesHistoricalPoints;
    }

    public List<String> getHistoricalWeeks(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        datesHistoricalPoints = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Date date = new Date(currentDay.getTime());
        date.setHours(date.getHours() - (day*24-48));
        date.setHours(date.getHours() - 7 * 24 * historicalPoints);

        for (int i = 0; i < historicalPoints; i++){

            calendar.setTime(date);
            Date dateEnd = new Date(date.getTime());
            dateEnd.setHours(dateEnd.getHours() + 5*24);

            datesHistoricalPoints.add(String.format("%s - %s",formatter.format(date),formatter.format(dateEnd)));

            date.setHours(date.getHours() + 7*24);

        }

        return datesHistoricalPoints;
    }



    public void sendReportNhs(){
        Report2NHS.writeUsingFileWriter(nhsReport);
    }




}
