package app.ui.gui;

import app.ui.console.AuthUI;
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
    void sendReportClick() {

    }

}

