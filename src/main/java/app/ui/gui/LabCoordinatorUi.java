package app.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LabCoordinatorUi {

    private Stage stage;

    @FXML
    private BorderPane brdPane;

    public void setLabelUI(Stage stageLabCoordinatorUI) {
        this.stage = stageLabCoordinatorUI;
    }
}
