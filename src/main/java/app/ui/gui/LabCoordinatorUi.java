package app.ui.gui;

import app.ui.console.AuthUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

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
    void OverviewClickButton(ActionEvent event) {

    }

    @FXML
    void ImportClickBotton(ActionEvent event) {

    }

    @FXML
    void closePlatform() {
        System.exit(0);
    }

    @FXML
    void logout() {
        AuthUI uiLogin = new AuthUI();
        uiLogin.logout();
        try {
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.UNDECORATED);

            Parent root;

            root = FXMLLoader.load(getClass().getResource("/fxml/LoginUi.fxml"));

            Scene scene = new Scene(root);

            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            System.out.println("Erro no lougout: " + ex);
        }
        stage.close();

    }

}
