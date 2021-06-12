package app.controller;

import app.mappers.dto.TestDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

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

    }
}
