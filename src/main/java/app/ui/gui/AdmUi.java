package app.ui.gui;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AdmUi {

    private Stage stage;

    public void setLabelUI(Stage stageAdm) {
        this.stage=stageAdm;
    }

    @FXML
    void closePlatform() {
        System.exit(0);
    }
}
