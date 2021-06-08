package app.ui.gui;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;

public class ClientUi {
    private Stage stage;

    @FXML
    private VBox updateDataButton;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView closeButton;

    @FXML
    private VBox viewTestResultButton;

    @FXML
    private ImageView logoutButton;

    @FXML
    private Button searchButoon;

    public void setLabelUI(Stage stageClient) {
        this.stage = stageClient;
    }

    @FXML
    void updateDataClick(ActionEvent event) {

    }

    @FXML
    void viewTestResultsClick(ActionEvent event) {

    }

    @FXML
    void searchButtonClick(ActionEvent event) {

    }

    @FXML
    void logoutButtonClick(ActionEvent event) {

    }

    @FXML
    void closeButtonClick(ActionEvent event) {

    }

}
