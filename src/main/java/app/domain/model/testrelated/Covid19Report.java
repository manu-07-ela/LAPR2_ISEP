package app.domain.model.testrelated;

import app.SimpleLinearRegression;
import com.nhs.report.Report2NHS;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Covid19Report {

    private String nhsReport;

    private List<Test> lstCovidTestsByInterval;

    private List<Test> covidTestsLstHistoricalPoints;

    private List<Date> intervalDate;

    private List<Date> historicalPointsDate;

    private double[] numberTestsPerformedByInterval;

    private Date initialDate;

    private Date endDate;

    private Date currentDay;

    private int historicalPoints;

    private double meanAge;

    private double[] lstPositiveTestsByInterval;

    private double[] lstPositiveTestsHistoricalPoints;


    public Covid19Report(List<Test> lstCovidTestsByInterval, List<Test> covidTestsLstHistoricalPoints,Date initialDate, Date endDate, Date currentDay, int historicalPoints, String typeOfData, String regressionModel, String independentVariable, double significanceLevel, double confidenceLevel){
        this.lstCovidTestsByInterval=lstCovidTestsByInterval;
        this.covidTestsLstHistoricalPoints=covidTestsLstHistoricalPoints;
        this.initialDate=initialDate;
        this.endDate=endDate;
        this.currentDay=currentDay;
        this.historicalPoints=historicalPoints;
        intervalDate=getIntervalDates();
        historicalPointsDate=getHistoricalDates();
        lstPositiveTestsByInterval=getPositiveCases(intervalDate,lstCovidTestsByInterval);
        lstPositiveTestsHistoricalPoints=getPositiveCases(historicalPointsDate,covidTestsLstHistoricalPoints);
        new SimpleLinearRegression(numberTestsPerformedByInterval,lstPositiveTestsByInterval,confidenceLevel,significanceLevel);
    }

    public double[] getNumberOfTestsPerformed(List<Date> dates, List<Test> tests){
        double[] auxiliar = new double[dates.size()];
        for (int i = 0; i < dates.size(); i++ ){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dates.get(i));
            int day = calendar.get(Calendar.DAY_OF_YEAR);
            int year = calendar.get(Calendar.YEAR);
            double aux=0;
            for (int j = 0; j<tests.size(); j++ ){
                calendar.setTime(tests.get(j).getSamplesAddDate());
                int sampleDay = calendar.get(Calendar.DAY_OF_YEAR);
                int sampleYear = calendar.get(Calendar.YEAR);
                if(day == sampleDay && year == sampleYear){
                    aux++;
                }
            }
            auxiliar[i]=aux;
        }
        return auxiliar;
    }

    public List<Date> getIntervalDates(){
        intervalDate = new ArrayList();
        Date aux = new Date(initialDate.getTime());
        do{
            if(aux.getDay()!=0){
                intervalDate.add(aux);
            }
            aux.setHours(aux.getHours()-24);
        }while (aux.before(endDate));
        if(endDate.getDay()!=0){
            intervalDate.add(endDate);
        }
        return intervalDate;
    }

    public List<Date> getHistoricalDates(){
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
        return historicalPointsDate;
    }

    public double[] getPositiveCases(List<Date> dates, List<Test> tests){
        double[] auxiliar = new double[dates.size()];
        for (int i = 0; i < dates.size(); i++ ){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dates.get(i));
            int day = calendar.get(Calendar.DAY_OF_YEAR);
            int year = calendar.get(Calendar.YEAR);
            double aux=0;
            for (int j = 0; j<tests.size(); j++ ){
                calendar.setTime(tests.get(j).getSamplesAddDate());
                int sampleDay = calendar.get(Calendar.DAY_OF_YEAR);
                int sampleYear = calendar.get(Calendar.YEAR);
                if(day == sampleDay && year == sampleYear){
                    if (tests.get(j).getTestParameterList().get(0).getParameterId().equals("IgGAN")) {
                        if (Double.parseDouble(tests.get(j).getTestParameterList().get(0).getParamResult().getResult()) > 1.4) {
                            aux++;
                        }
                    }
                }
            }
            auxiliar[i]=aux;
        }
        return auxiliar;
    }

    public double getMeanAge() throws ParseException {
        int sum=0;
        for(int i = 0; i<lstCovidTestsByInterval.size(); i++){
            sum+=lstCovidTestsByInterval.get(i).getCl().getAge();
        }
        return sum/lstCovidTestsByInterval.size();
    }

    public void sendReportNhs(){
        Report2NHS.writeUsingFileWriter(nhsReport);
    }




}
