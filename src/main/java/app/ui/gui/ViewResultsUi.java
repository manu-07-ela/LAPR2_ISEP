package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.ParameterResultController;
import app.controller.ViewResultsController;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDTO;
import app.mappers.dto.TestResultDto;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class ViewResultsUi {

    private Stage stage;

    private TestResultDto result;

    @FXML
    private GridPane grid;

    /**
     * Represents a instance of view results controller
     */
    private final ViewResultsController viewResultsctrl  = new ViewResultsController();


    @FXML
    private Label showMedicalReport;

    public void setLabelUI(Stage stageViewResult, TestDTO test) throws IOException {
        this.stage = stageViewResult;
        result=viewResultsctrl.showTestResults(test);
        showParameterResults(result.getTpList());
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

    public void showParameterResults(List<TestParameterDTO> parameterResults) throws IOException {
        int row = 1;
        try {
            for (int i=0; i<parameterResults.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/ParameterResult.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ParameterResultController itemController = fxmlLoader.getController();
                itemController.setData(parameterResults.get(i));

                grid.prefHeight(grid.getPrefHeight()+150);
                grid.add(anchorPane, 0, row);

                row++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
