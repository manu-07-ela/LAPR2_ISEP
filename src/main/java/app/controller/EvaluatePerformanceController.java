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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class EvaluatePerformanceController {

    private OverviewController overviewController;

    private Stage stage;

    private int[] seq;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private LineChart<?, ?> performanceChart;


    public void setLabelUI(Stage stage,OverviewController overviewController, String algorithm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.stage = stage;
        this.overviewController=overviewController;
        seq=overviewController.getSubsequenceWithMaximumSum(algorithm);
        loadLineChart();
    }

    public void loadLineChart(){
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i<seq.length; i++){
            series.getData().add(new XYChart.Data(String.valueOf(i),seq[i]));
        }
        performanceChart.getData().addAll(series);

    }



    @FXML
    void closePlatform() {
        Serialization.saveApp(App.getInstance(), "SavedData.data");
        System.exit(0);
    }

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
