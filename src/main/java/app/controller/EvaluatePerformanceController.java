package app.controller;

import app.Serialization;
import app.domain.model.testrelated.Overview;
import app.domain.model.testrelated.Test;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EvaluatePerformanceController{

    /**
     * Represents an instance of OverviewController
     */
    private OverviewController overviewController;
    /**
     * Represents a instance of stage
     */
    private Stage stage;
    /**
     * Represents a array
     */
    private int[] seq;

    private List<Date> dates;

    private List<Integer> testProcessed;

    private List<Integer> testsWaitingForDiagnosis;

    private List<Integer> testWaitingForResults;

    private List<Date> intervalDates;

    @FXML
    private LineChart performanceChart;

    @FXML
    private LineChart weekChart;

    @FXML
    private LineChart dayChart;

    @FXML
    private LineChart monthChart;

    @FXML
    private LineChart yearChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TextField txtSubsequence;

    /**
     * Set the stage
     * @param stage the stage we want to show
     * @param overviewController the controller of the stage
     * @param algorithm the type of algorithm to be used
     * @param sequence the sequence that we intend to calculate the maximum subsequence
     * @throws ClassNotFoundException if it is not possible to instantiate the desired class
     * @throws IllegalAccessException if the object we intend to create it's not  correctly
     * @throws InstantiationException if we can't instantiate an object
     */
    public void setLabelUI(Stage stage, OverviewController overviewController, String algorithm, int[] sequence, List<Date> dates, List<Integer> testProcessed, List<Integer> testsWaitingForDiagnosis, List<Integer> testWaitingForResults,List<Date> intervalDates) throws ClassNotFoundException, IllegalAccessException, InstantiationException, ParseException {
        this.stage = stage;
        this.overviewController=overviewController;
        this.dates=dates;
        this.testProcessed=testProcessed;
        this.testsWaitingForDiagnosis=testsWaitingForDiagnosis;
        this.testWaitingForResults=testWaitingForResults;
        this.intervalDates=intervalDates;
        seq=overviewController.getSubsequenceWithMaximumSum(algorithm);
        txtSubsequence.setText(Arrays.toString(getPeriodSubSequenceMaxSum(seq,sequence)));
        loadLineChart(sequence);
    }

    /**
     * Shows the bar graph representing maximum subsequence
     * @param sequence The sequence we want to show
     */
    public void loadLineChart(int[] sequence) throws ParseException {
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i<sequence.length; i++){
            series.getData().add(new XYChart.Data(String.valueOf(i),sequence[i]));
        }
        performanceChart.getData().addAll(series);
        series.getNode().setStyle("-fx-stroke: #2bcac8;");

        makeLineChart(testProcessed,dayChart,"Performed");
        makeLineChart(testWaitingForResults,dayChart,"Waiting For Results");
        makeLineChart(testsWaitingForDiagnosis,dayChart,"Waiting For Diagnosis");

        makeLineChart(showTestsByWeek(testProcessed,dates),weekChart,"Performed");
        makeLineChart(showTestsByWeek(testWaitingForResults,dates),weekChart,"Waiting For Results");
        makeLineChart(showTestsByWeek(testsWaitingForDiagnosis,dates),weekChart,"Waiting For Diagnosis");

        makeLineChart(showTestsByMonth(testProcessed,dates),monthChart,"Performed");
        makeLineChart(showTestsByMonth(testWaitingForResults,dates),monthChart,"Waiting For Results");
        makeLineChart(showTestsByMonth(testsWaitingForDiagnosis,dates),monthChart,"Waiting For Diagnosis");

        makeLineChart(showTestsByYear(testProcessed,dates),yearChart,"Performed");
        makeLineChart(showTestsByYear(testWaitingForResults,dates),yearChart,"Waiting For Results");
        makeLineChart(showTestsByYear(testsWaitingForDiagnosis,dates),yearChart,"Waiting For Diagnosis");
    }

    public void makeLineChart(List<Integer> values, LineChart chart, String legend){

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < values.size(); i++) {
            series.getData().add(new XYChart.Data(String.valueOf(i), values.get(i)));
        }

        series.setName(legend);
        chart.getData().addAll(series);

    }


    /**
     * Close the application
     */
    @FXML
    void closePlatform() {
        Serialization.saveApp(App.getInstance(), "SavedData.data");
        System.exit(0);
    }

    /**
     * Log out of the application
     */
    @FXML
    void logout() {
        AuthUI uiLogin = new AuthUI();
        uiLogin.logout();
        try {
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.UNDECORATED);

            Parent root;

            root = FXMLLoader.load(getClass().getResource("/fxml/LoginUi.fxml"));

            Scene scene = new Scene(root);

            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            System.out.println("Logout Error: " + ex);
        }
        stage.close();
    }


    public List<Integer> showTestsByWeek(List<Integer> testsDay, List<Date> dates) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        List<Integer> testsWeeks = new ArrayList<>();


        Date date1 = new Date(dates.get(0).getYear(),dates.get(0).getMonth(),dates.get(0).getDate());
        Date date2 = new Date(dates.get(0).getYear(),dates.get(0).getMonth(),dates.get(0).getDate()+6);

        do{
            int sum=0;
            for (int i=0; i<testsDay.size();i++) {

                String date= formatter.format(dates.get(i));

                Date temp = formatter.parse(date);

                if (temp.equals(date1) || temp.equals(date2) || ((temp.after(date1)) && (temp.before(date2)))) {
                    sum += testsDay.get(i);
                }
            }
            testsWeeks.add(sum);

            date1 =new Date(date1.getYear(),date1.getMonth(),date1.getDate()+6);
            date2 =new Date(date2.getYear(),date2.getMonth(),date2.getDate()+6);


        }while (date2.before(dates.get(dates.size()-1)));

        return testsWeeks;

    }


    public List<Integer> showTestsByMonth(List<Integer> testsDay, List<Date> dates) throws ParseException {

        List<Integer> testsMonth = new ArrayList<>();

        Date date1 = new Date(dates.get(0).getYear(),dates.get(0).getMonth(),dates.get(0).getDate());
        Date date2 = new Date(date1.getYear(),date1.getMonth()+1,date1.getDate());

        do{
            int sum=0;
            for (int i=0; i<testsDay.size();i++) {
                if (dates.get(i).equals(date1) || dates.get(i).equals(date2) || (dates.get(i).after(date1)) && (dates.get(i).before(date2))) {
                    sum += testsDay.get(i);
                }
            }

            testsMonth.add(sum);

            date1 =new Date(date1.getYear(),date1.getMonth()+1,date1.getDate());
            date2 =new Date(date2.getYear(),date2.getMonth()+1,date2.getDate());

        }while (date2.before(dates.get(dates.size()-1)));

        return testsMonth;

    }


    public List<Integer> showTestsByYear(List<Integer> testsDay, List<Date> dates) throws ParseException {

        List<Integer> testsYears = new ArrayList<>();

        Date date1 = new Date(dates.get(0).getYear(),dates.get(0).getMonth(),dates.get(0).getDate());
        Date date2 = new Date(date1.getYear()+1,date1.getMonth(),date1.getDate());

        do{
            int sum=0;
            for (int i=0; i<testsDay.size();i++) {
                if (dates.get(i).equals(date1) || dates.get(i).equals(date2) || (dates.get(i).after(date1)) && (dates.get(i).before(date2))) {
                    sum += testsDay.get(i);
                }
            }

            testsYears.add(sum);

            date1 =new Date(date1.getYear()+1,date1.getMonth(),date1.getDate());
            date2 =new Date(date2.getYear()+1,date2.getMonth(),date2.getDate());

        }while (date2.before(dates.get(dates.size()-1)));

        return testsYears;

    }

    public String[] getPeriodSubSequenceMaxSum(int[] subSeq,int[] sequence){

        String[] period = new String[2];

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        int aux=0;

        boolean flag = false;

        for(int i=0; i<sequence.length;i++){
            if(!flag)
            if (sequence[i] == subSeq[0]){
                aux++;
                String date= formatter.format(intervalDates.get(i));
                period[0]= date;
                for (int j=1;j<subSeq.length;j++){
                    if(sequence[j]==subSeq[j]){
                        aux++;
                    }
                }
                if(aux==subSeq.length){
                    String endDate= formatter.format(intervalDates.get(i+aux));
                    period[1]=endDate;
                    flag=true;
                }
            }
        }

        return period;

    }



}
