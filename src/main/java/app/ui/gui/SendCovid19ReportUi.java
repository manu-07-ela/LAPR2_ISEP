package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.SendCovid19ReportController;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

import static java.lang.String.valueOf;

public class SendCovid19ReportUi {

    /**
     * Represents a instance of Send Covid-19 Report Controller.
     */
    private SendCovid19ReportController sendCovid19ReportController;

    private Stage stage;

    @FXML
    private DatePicker currentDay;

    @FXML
    private ComboBox<String> typeOfData;

    @FXML
    private TextField txtHistoricalPoints;

    @FXML
    private DatePicker initialDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private ComboBox<String> regressionModel;

    /**
     * Initializes the Send Covid-19 Report Interface and the controller.
     */
    public SendCovid19ReportUi(){
        sendCovid19ReportController = new SendCovid19ReportController();
    }

    public void setLabelUI (Stage stageSendCovid19Report) throws IOException {
        this.stage = stageSendCovid19Report;
        loadChoiseBox();
    }

    /**
     * Load choise box.
     */
    public void loadChoiseBox() {
        for (int i = 0; i < sendCovid19ReportController.getAvailableTypesOfData().size(); i++) {
            typeOfData.getItems().add(sendCovid19ReportController.getAvailableTypesOfData().get(i));
        }
        for (int i = 0; i< sendCovid19ReportController.getAvailableRegressionModels().size(); i++){
            regressionModel.getItems().add(sendCovid19ReportController.getAvailableRegressionModels().get(i));
        }
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
            System.out.println("Erro no lougout: " + ex);
        }
        stage.close();

    }

}
