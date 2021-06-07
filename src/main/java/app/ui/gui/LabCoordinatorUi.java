package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabCoordinatorUi {

    private Stage stage;

    @FXML
    private VBox ImportBotton;

    @FXML
    private VBox OverviewBotton;

    @FXML
    private BorderPane brdPane;

    /**
     * Sets label ui.
     *
     * @param stageLabUI the stage adm ui
     */
    public void setLabelUI(Stage stageLabUI) {
        this.stage = stageLabUI;
    }

    @FXML
    void OverviewClickBotton(ActionEvent event) {

    }

    @FXML
    void ImportClickBotton(ActionEvent event) {

    }

}
