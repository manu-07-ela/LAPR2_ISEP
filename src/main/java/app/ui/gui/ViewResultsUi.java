package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.ViewResultsController;
import app.mappers.dto.TestDTO;
import app.mappers.dto.testResultDto;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ViewResultsUi {

    private Stage stage;

    private testResultDto result;

    /**
     * Represents a instance of view results controller
     */
    private final ViewResultsController viewResultsctrl  = new ViewResultsController();


    @FXML
    private Label showMedicalReport;

    public void setLabelUI(Stage stageViewResult, TestDTO test) {
        this.stage = stageViewResult;
        result=viewResultsctrl.showTestResults(test);
        showMedicalReport.setText(result.getDiagnosis());
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
            System.out.println("Erro no lougout: " + ex);
        }
        stage.close();

    }
}
