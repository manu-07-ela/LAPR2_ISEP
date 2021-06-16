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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class EvaluatePerformanceController {

    /**
     * Represents a instance of Overview controller
     */
    private final OverviewController overviewCtrl;

    private Stage stage;

    @FXML
    private ComboBox<String> availableAlgorithms;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private LineChart<?, ?> performanceChart;

    /**
     * Initializes the controller
     */
    public EvaluatePerformanceController(){
        overviewCtrl  = new OverviewController();
    }

    public void setLabelUI(Stage stage) {
        this.stage = stage;
        System.out.println("1");
        loadChoiseBox();
        System.out.println("2");
    }

    /**
     * Load choise box.
     */
    public void loadChoiseBox() {
        for (int i = 0; i < overviewCtrl.getAvailableAlgorithms().size(); i++) {
            availableAlgorithms.getItems().add(overviewCtrl.getAvailableAlgorithms().get(i));
        }
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
