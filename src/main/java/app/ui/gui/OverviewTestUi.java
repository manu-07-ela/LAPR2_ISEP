package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.OverviewController;
import app.controller.ViewResultsController;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static java.lang.String.*;

public class OverviewTestUi {

    /**
     * Represents a instance of overview controller
     */
    private final OverviewController overviewCtrl  = new OverviewController();

    private Stage stage;

    @FXML
    private ComboBox<String> endHour;

    @FXML
    private ComboBox<String> endMin;

    @FXML
    private Button logout;

    @FXML
    private DatePicker initialDay;

    @FXML
    private ComboBox<String> initialMin;

    @FXML
    private ComboBox<String> initialHour;

    @FXML
    private Button closePlatform;

    @FXML
    private DatePicker endDay;

    public void setLabelUI(Stage stage) {
        this.stage = stage;
        loadChoiseBox();
    }

    @FXML
    void closePlatform() {
        Serialization.saveApp(App.getInstance(), "SavedData.data");
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
            System.out.println("Logout Error: " + ex);
        }
        stage.close();
    }

    /**
     * Load choise box.
     */
    public void loadChoiseBox() {
        for (int i = 0; i < 24; i++) {
            initialHour.getItems().add(String.valueOf(i));
            endHour.getItems().add(String.valueOf(i));
        }
        for (int j = 0; j < 60; j++) {
            initialMin.getItems().add(valueOf(j));
            endMin.getItems().add(valueOf(j));
        }
    }


}
