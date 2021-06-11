package app.ui.gui;

import app.controller.ViewResultsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewTestResultUi {

    /**
     * Represents a instance of view results controller
     */
    private final ViewResultsController viewResultsctrl  = new ViewResultsController();

    private Stage stage;

    @FXML
    private Label testCode;

    @FXML
    private Label testDescription;

    public void setLabelUI(Stage stageViewResult) {
        this.stage = stageViewResult;
    }


}
