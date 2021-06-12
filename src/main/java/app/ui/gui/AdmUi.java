package app.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdmUi {
    private Stage stage;
    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private VBox sendReport;

    @FXML
    private VBox registerLaboratory;

    @FXML
    private VBox specifyParameterCategory;

    @FXML
    private VBox specifyTestType;

    @FXML
    private VBox specifyParameter;

    @FXML
    private BorderPane brdPane;

    @FXML
    private VBox registerEmployee;

    public void setLabelUI(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void exitClick() {
        System.exit(0);
    }


    @FXML
    void logoutClick() {

    }


    @FXML
    void registerEmployeeClick() {

    }

    @FXML
    void specifyTestTypeClick() {

    }

    @FXML
    void specifyParameterClick() {

    }

    @FXML
    void registerLaboratoryClick() {

    }

    @FXML
    void specifyParameterCategoryClick() {

    }

    @FXML
    void sendReportClick() {

    }

}

