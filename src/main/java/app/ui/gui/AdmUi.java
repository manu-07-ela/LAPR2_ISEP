package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.ui.console.AuthUI;
import app.ui.console.functionalities.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdmUi {

    private Stage stage;

    private Stage stageSendCovid19Report;

    private SendCovid19ReportUi sendCovid19ReportUi;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private VBox sendReport;

    @FXML
    private VBox registerLaboratory;

    @FXML
    private VBox specifyParameterCategory;

    @FXML
    private VBox specifyTestType;

    @FXML
    private VBox specifyParameter;

    @FXML
    private BorderPane brdPane;

    @FXML
    private VBox registerEmployee;

    public void setLabelUI(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void exitClick() {
        Serialization.saveApp(App.getInstance(), "SavedData.data");
        System.exit(0);
    }


    @FXML
    void logoutClick() {
        AuthUI uiLogin = new AuthUI();
        uiLogin.logout();
        try {
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.UNDECORATED);

            Parent root;

            root = FXMLLoader.load(getClass().getResource("/LoginUi.fxml"));

            Scene scene = new Scene(root);

            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.close();

    }


    @FXML
    void registerEmployeeClick() {
        RegisterEmployeeUI testTypeUi = new RegisterEmployeeUI();
        testTypeUi.run();
    }

    @FXML
    void specifyTestTypeClick() {
        CreateTestTypeUI testTypeUi = new CreateTestTypeUI();
        testTypeUi.run();
    }

    @FXML
    void specifyParameterClick() {
        CreateParameterUI createParameterUI = new CreateParameterUI();
        createParameterUI.run();

    }

    @FXML
    void registerLaboratoryClick() {
        CreateClinicalAnalysisLaboratoryUI createClinicalAnalysisLaboratoryUI = new CreateClinicalAnalysisLaboratoryUI();
        createClinicalAnalysisLaboratoryUI.run();
    }

    @FXML
    void specifyParameterCategoryClick() {
        CreateParameterCategoryUI createParameterCategoryUI = new CreateParameterCategoryUI();
        createParameterCategoryUI.run();

    }

    @FXML
    void sendReportClick() throws IOException {
        runSendCovid19Report();
        sendCovid19ReportUi.setLabelUI(stageSendCovid19Report);
        exit.getScene().getWindow().hide();
    }

    @FXML
    private void runSendCovid19Report(){
        try {
            stageSendCovid19Report = new Stage();
            stageSendCovid19Report.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("\\fxml\\CreateCovid19Report.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageSendCovid19Report.setScene(scene);

            sendCovid19ReportUi = loader.getController();
            stageSendCovid19Report.show();

        }catch (IOException exception){
            exception.printStackTrace();
        }
        exit.getScene().getWindow().hide();
    }


}

