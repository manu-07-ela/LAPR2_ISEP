package app.ui.gui;

import app.controller.ItemController;
import app.controller.ViewResultsController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTestResultUi implements Initializable {

    /**
     * Represents a instance of view results controller
     */
    private final ViewResultsController viewResultsctrl  = new ViewResultsController();

    private Stage stage;

    private ClientDTO client;

    private List<TestDTO> testsList;

    @FXML
    private Label testCode;

    @FXML
    private GridPane grid;

    @FXML
    private Label testDescription;

    public void setLabelUI(Stage stageViewResult) throws IOException {
        this.stage = stageViewResult;
        getClient();
        getTestsList();
        showTestsList();
    }

    public void getClient(){
        client = viewResultsctrl.getUserSession();
    }

    public void getTestsList(){
       testsList = viewResultsctrl.getTestList(client);
    }

    public void showTestsList() throws IOException {
        //testsList=getData();
        int row = 1;
        try {
            for (int i=0; i<testsList.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(testsList.get(i));

                grid.prefHeight(grid.getPrefHeight()+60);
                grid.add(anchorPane, 0, row);

                row++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<TestDTO> getData(){
        List<TestDTO> tests = new ArrayList<>();
        TestDTO test;

        for (int i=0;i<20;i++){
            test=new TestDTO("111111111111","seringa");
            tests.add(test);
        }
        return tests;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
