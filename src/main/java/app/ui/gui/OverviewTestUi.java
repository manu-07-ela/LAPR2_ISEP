package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.EvaluatePerformanceController;
import app.controller.OverviewController;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.String.*;

/**
 * Represents an interface with the user to be able  to have an overview of all the tests performed by Many Labs and analyze the overall performance of the company.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class OverviewTestUi {

    /**
     * Represents a instance of Overview controller
     */
    private final OverviewController overviewCtrl;

    private Stage stage;

    private Stage stageEvaluatePerformance;

    private EvaluatePerformanceController evaluatePerformanceController;

    @FXML
    private DatePicker initialDay;

    @FXML
    private ComboBox<String> initialMin;

    @FXML
    private ComboBox<String> initialHour;

    @FXML
    private DatePicker endDay;

    @FXML
    private ComboBox<String> endHour;

    @FXML
    private ComboBox<String> endMin;

    @FXML
    private Button logout;

    @FXML
    private Button closePlatform;


    /**
     * Initializes the controller
     */
    public OverviewTestUi(){
        overviewCtrl  = new OverviewController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    public void run() {
        String initial = initialDay.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String end = endDay.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String initialDateStr = initial.concat(" ").concat(String.valueOf(initialHour)).concat(":").concat(String.valueOf(initialMin));
        String endDateStr = end.concat(" ").concat(String.valueOf(endHour)).concat(":").concat(String.valueOf(endMin));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date initialDate = formatter.parse(initialDateStr);
            Date endDate = formatter.parse(endDateStr);
            overviewCtrl.getIntervalTestList(initialDate,endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        overviewCtrl.getNumberOfClients();
        overviewCtrl.getNumberOfTestsWaitingForResults();
        overviewCtrl.getNumberOfTestsWaitingForDiagnosis();
        overviewCtrl.getTotalNumberOfTestsProcessed();
    }

    public void evaluetePerformance() {
        runEvaluetePerformance();
        evaluatePerformanceController.setLabelUI(stageEvaluatePerformance);
        System.out.println("3");
        closePlatform.getScene().getWindow().hide();
        System.out.println("4");
    }

    @FXML
    private void runEvaluetePerformance(){
        try {
            stageEvaluatePerformance = new Stage();
            stageEvaluatePerformance.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/EvaluatePerformance.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageEvaluatePerformance.setScene(scene);
            evaluatePerformanceController = loader.getController();
            stageEvaluatePerformance.show();


        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

    public void setLabelUI(Stage stage) {
        this.stage = stage;
        loadChoiseBox();

    }

    /**
     * Load choise box.
     */
    public void loadChoiseBox() {
        for (int i = 8; i < 21; i++) {
            initialHour.getItems().add(String.valueOf(i));
            endHour.getItems().add(String.valueOf(i));
        }
        for (int j = 0; j < 60; j++) {
            initialMin.getItems().add(valueOf(j));
            endMin.getItems().add(valueOf(j));
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
