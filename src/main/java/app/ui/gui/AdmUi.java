package app.ui.gui;

import app.ui.console.AuthUI;
import app.ui.console.functionalities.CreateTestTypeUI;
import app.ui.console.functionalities.RegisterEmployeeUI;
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

            root = FXMLLoader.load(getClass().getResource("/fxml/LoginUi.fxml"));

            Scene scene = new Scene(root);

            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            System.out.println("Logout error: " + ex);
        }
        stage.close();

    }


    @FXML
    void registerEmployeeClick() {
        new RegisterEmployeeUI();
    }

    @FXML
    void specifyTestTypeClick() {
        CreateTestTypeUI testTypeUi = new CreateTestTypeUI();
        testTypeUi.run();
    }

    @FXML
    void specifyParameterClick() {

    }

    @FXML
    void registerLaboratoryClick() {

    }

    @FXML
    void specifyParameterCategoryClick() {

    }

    @FXML
    void sendReportClick() throws IOException {
        runSendCovid19Report();
        sendCovid19ReportUi.setLabelUI(stageSendCovid19Report);
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
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }


}

