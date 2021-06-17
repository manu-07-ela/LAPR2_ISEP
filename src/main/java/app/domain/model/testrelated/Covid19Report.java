package app.domain.model.testrelated;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Covid19Report {

    private List<Test> lstCovidTestsByInterval;

    private List<Test> covidTestsLstHistoricalPoints;

    private List<Date> intervalDate;

    private List<Date> historicalPointsDate;

    private int historicalPoints;

    private double meanAge;

    private double[] lstPositiveTestsByInterval;

    private double[] lstPositiveTestsHistoricalPoints;


    public Covid19Report(List<Test> lstCovidTestsByInterval, List<Test> covidTestsLstHistoricalPoints, List<Date> intervalDate, List<Date> historicalPointsDate, int historicalPoints){
        this.lstCovidTestsByInterval=lstCovidTestsByInterval;
        this.covidTestsLstHistoricalPoints=covidTestsLstHistoricalPoints;
        this.intervalDate=intervalDate;
        this.historicalPointsDate=historicalPointsDate;
        this.historicalPoints=historicalPoints;
        lstPositiveTestsByInterval=getPositiveCases(intervalDate,lstCovidTestsByInterval);
        lstPositiveTestsHistoricalPoints=getPositiveCases(historicalPointsDate,covidTestsLstHistoricalPoints);
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




}
