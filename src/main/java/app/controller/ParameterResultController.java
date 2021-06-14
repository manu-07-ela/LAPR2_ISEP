package app.controller;

import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ParameterResultController {

    @FXML
    private Label labelParameterName;

    @FXML
    private Label labelResultMetric;

    @FXML
    private Label labelRefValueMetric;

    @FXML
    private Label labelParameterResult;

    @FXML
    private Label labelMinRefValue;


    @FXML
    private Label labelMaxRefValue;

    private TestParameterDTO testParameter;

    public void setData(TestParameterDTO testParameter){
        this.testParameter = testParameter;
        labelParameterName.setText(testParameter.getParameterName());
        labelResultMetric.setText(testParameter.getTestParameterMetric());
        labelRefValueMetric.setText(testParameter.getRefValueMetric());
        labelParameterResult.setText(testParameter.getTestParameterResult());
        labelMinRefValue.setText(Double.toString(testParameter.getTestParameterMinRefValue()));
        labelMaxRefValue.setText(Double.toString(testParameter.getTestParameterMaxRefValue()));
    }

}
