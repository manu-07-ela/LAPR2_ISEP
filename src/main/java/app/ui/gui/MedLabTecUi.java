package app.ui.gui;
import app.Serialization;
import app.controller.App;
import app.ui.console.AuthUI;
import app.ui.console.functionalities.RecordSampleUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MedLabTecUi {
    private Stage stage;

    @FXML
    private Button exit;

    @FXML
    private VBox recordSample;

    @FXML
    private Button logout;

    @FXML
    private BorderPane brdPane;


    public void setLabelUI(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void exitClick() {
        Serialization.saveApp(App.getInstance(), "SavedData.data");
        System.exit(0);
    }

    @FXML
    void logoutClick() {
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

    @FXML
    void recordSampleClick() {
        RecordSampleUI recordSampleUI = new RecordSampleUI();
        recordSampleUI.run();
    }
}
