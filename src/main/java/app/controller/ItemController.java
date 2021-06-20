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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ItemController {
    /**
     *
     */
    private Stage stageViewResult;
    /**
     *
     */
    private ViewResultsUi viewResultsUi;
    /**
     *
     */
    @FXML
    private Label testCode;
    /**
     *
     */
    @FXML
    private Button selectTest;
    /**
     *
     */
    @FXML
    private Label testDescription;
    /**
     *
     */
    private TestDTO test;

    /**
     *
     * @param test
     */
    public void setData(TestDTO test){
        this.test = test;
        testCode.setText(test.getInternalCode());
        testDescription.setText(test.getDescription());

    }

    /**
     *
     * @throws IOException
     */
    @FXML
    void seeTestResults() throws IOException {
        runViewResults();
        viewResultsUi.setLabelUI(stageViewResult,test);
        testDescription.getScene().getWindow().hide();
    }

    /**
     * Switches to the ViewResults stage
     */
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

    /**
     * Change the color of a test selection button
     */
    @FXML
    void selectTestIn() {
        selectTest.setStyle("-fx-background-color: #ffffff;-fx-background-radius: 15px; -fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 , 10.0); -fx-font-weight: bold; -fx-font-size: 14");
        selectTest.setTextFill(Paint.valueOf("#239ba1"));
    }

    /**
     * Change the color of a test selection button
     */
    @FXML
    void selectTestOut() {
        selectTest.setStyle("-fx-background-color: #239ba1;-fx-background-radius: 15px; -fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 , 10.0); -fx-font-weight: bold; -fx-font-size: 14");
        selectTest.setTextFill(Paint.valueOf("#ffffff"));

    }
}
