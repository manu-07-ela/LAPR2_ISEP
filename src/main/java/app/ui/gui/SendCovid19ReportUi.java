package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.SendCovid19ReportController;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

public class SendCovid19ReportUi {

    /**
     * Represents a instance of Send Covid-19 Report Controller.
     */
    private SendCovid19ReportController sendCovid19ReportController;

    private Stage stage;

    @FXML
    private TextField txtHistoricalPoints;

    @FXML
    private Button logout;

    @FXML
    private TextField txtSignificanceLevel;

    @FXML
    private DatePicker currentDay;

    @FXML
    private TextField txtConfidenceLevel;

    @FXML
    private DatePicker endDate;

    @FXML
    private ComboBox<String> independentVariable;

    @FXML
    private Button closePlatform;

    @FXML
    private ComboBox<String> regressionModel;

    @FXML
    private ComboBox<String> typeOfData;

    @FXML
    private DatePicker initialDate;


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
        for (int i = 0; i< sendCovid19ReportController.getAvailableRegressionModels().size(); i++){
            independentVariable.getItems().add(sendCovid19ReportController.getAvailableIndependentVariable().get(i));
        }
    }

    @FXML
    void sendCovid19Report() {
        String initialAux = initialDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String endAux = endDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String currentAux = currentDay.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date initial = formatter.parse(initialAux);
            Date end = formatter.parse(endAux);
            Date current = formatter.parse(currentAux);
            sendCovid19ReportController.createCovid19Report(initial,end,current,Integer.parseInt(String.valueOf(txtHistoricalPoints)),typeOfData.getValue(),regressionModel.getValue(),independentVariable.getValue(),Double.parseDouble(String.valueOf(txtSignificanceLevel)),Double.parseDouble(String.valueOf(txtConfidenceLevel)));
        } catch (ParseException e) {
            e.printStackTrace();
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
