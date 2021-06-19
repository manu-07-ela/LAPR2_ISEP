package app.controller;

import app.Serialization;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

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

    private List<String> dates;

    @FXML
    private LineChart performanceChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

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
    public void setLabelUI(Stage stage, OverviewController overviewController, String algorithm, int[] sequence, List<String> dates) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.stage = stage;
        this.overviewController=overviewController;
        this.dates=dates;
        seq=overviewController.getSubsequenceWithMaximumSum(algorithm);
        loadLineChart(sequence);
    }

    /**
     * Shows the bar graph representing maximum subsequence
     * @param sequence The sequence we want to show
     */
    public void loadLineChart(int[] sequence){
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i<sequence.length; i++){
            series.getData().add(new XYChart.Data(dates.get(i),sequence[i]));
        }
        performanceChart.getData().addAll(series);
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

}
