package app.controller;

import app.mappers.dto.TestParameterDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ParameterResultController {
    /**
     * Label that will show the name of parameter
     */
    @FXML
    private Label labelParameterName;
    /**
     * Label that will show the metric result of a parameter
     */
    @FXML
    private Label labelResultMetric;
    /**
     * Label that will show the reference value of a parameter
     */
    @FXML
    private Label labelRefValueMetric;
    /**
     * Label that will show the parameter result
     */
    @FXML
    private Label labelParameterResult;
    /**
     * Label that will show the minimum reference value of a parameter
     */
    @FXML
    private Label labelMinRefValue;
    /**
     * Label that will show the maximum reference value of a parameter
     */
    @FXML
    private Label labelMaxRefValue;
    /**
     * Represents a instance of test parameter DTO
     */
    private TestParameterDTO testParameter;

    /**
     * Initializes the label data with the information of a parameter
     * @param testParameter the test parameter that will be showed in the labels
     */
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
