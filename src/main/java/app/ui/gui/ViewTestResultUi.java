package app.ui.gui;

import app.controller.ItemController;
import app.controller.ViewResultsController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewTestResultUi {

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
        //getTestsList();
        showTestsList();
    }

    public void getClient(){
        client = viewResultsctrl.getUserSession();
    }

    public void getTestsList(){
       // testsList = viewResultsctrl.getTestList(client);
    }

    public void showTestsList() throws IOException {
        testsList=getData();
        int row = 1;
        try {
            for (int i=0; i<testsList.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("main/resources/fxml/Item.fxml"));
                HBox hBox = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(testsList.get(i));

                int j=i;

                grid.prefHeight(grid.getPrefHeight()+55);
                grid.add(hBox, 0, j++ );

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




}
