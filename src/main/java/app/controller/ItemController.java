package app.controller;

import app.mappers.dto.TestDTO;
import app.ui.gui.ViewResultsUi;
import app.ui.gui.ViewTestResultUi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ItemController {

    private Stage stageViewResult;

    private ViewResultsUi viewResultsUi;

    @FXML
    private Label testCode;

    @FXML
    private Button selectTest;

    @FXML
    private Label testDescription;

    private TestDTO test;

    public void setData(TestDTO test){

        this.test = test;
        testCode.setText(test.getInternalCode());
        testDescription.setText(test.getDescription());

    }

    @FXML
    void seeTestResults() {
        runViewResults();
        viewResultsUi.setLabelUI(stageViewResult,test);
        testDescription.getScene().getWindow().hide();
    }

    public void runViewResults(){
        try {
            stageViewResult = new Stage();
            stageViewResult.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ViewResults.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageViewResult.setScene(scene);

            viewResultsUi = loader.getController();
            stageViewResult.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }
}
