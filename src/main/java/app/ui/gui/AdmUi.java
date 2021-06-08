package app.ui.gui;

import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdmUi {

    private Stage stage;

    public void setLabelUI(Stage stageAdm) {
        this.stage=stageAdm;
    }

    @FXML
    void closePlatform() {
        System.exit(0);
    }

    @FXML
    void logout() {

    }
}
