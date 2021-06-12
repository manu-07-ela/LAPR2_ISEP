package app.ui.gui;

import app.controller.UpdateDataController;
import app.domain.model.users.Client;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ClientUi /*implements Initializable*/{

    private Stage stage;
    private Stage stageUpdateData;
    private UpdateDataUi updateDataUi;
    private Stage stageViewResult;
    private ViewTestResultUi viewTestResultUi;
    private String email;


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

    @FXML
    private ImageView imageTouch;

    @FXML
    private Label phoneNumberField;

    @FXML
    private Label tinField;

    @FXML
    private Label emailField;

    @FXML
    private Label citizenCardField;

    UpdateDataController updateDataController;

    Client client;
    @FXML
    private TextField nameField;

    public ClientUi(){
        updateDataController = new UpdateDataController();
    }
    public void emailClient(String email){
        this.email = email;
        client = updateDataController.getClientByEmail(email);
        System.out.println(client);
    }

    public void setLabelUI(Stage stageClient) {
        this.stage = stageClient;
    }

    @FXML
    public void updateDataClick() {
        runUpdateData();
        updateDataUi.setLabelUI(stageUpdateData);
        updateDataUi.getClient(email);
        updateDataButton.getScene().getWindow().hide();
    }

    @FXML
    void viewTestResultsClick() throws IOException {
        runViewTestResult();
        viewTestResultUi.setLabelUI(stageViewResult);
        updateDataButton.getScene().getWindow().hide();
    }

    @FXML
    void searchButtonClick(ActionEvent event) {

    }

    @FXML
    void logoutButtonClick() {

    }


    @FXML
    private void runUpdateData(){
        try {
            stageUpdateData = new Stage();
            stageUpdateData.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("\\fxml\\UpdateData.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageUpdateData.setScene(scene);

            updateDataUi = loader.getController();
            stageUpdateData.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }
    @FXML
    private void runViewTestResult(){
        try {
            stageViewResult = new Stage();
            stageViewResult.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("\\fxml\\ViewTests.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageViewResult.setScene(scene);

            viewTestResultUi = loader.getController();
            stageViewResult.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

   /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateDataController updateDataController = new UpdateDataController();
        Client client = updateDataController.getClientByEmail(email);

    }*/


   /* @FXML
    void logoutMouseClick() {
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
            System.out.println("Logout error: " + ex);
        }
        stage.close();
    }*/
    @FXML
    void closeButtonClick() {
        System.exit(0);
    }
    @FXML
    void tinShow() {
        tinField.setText(client.getTin());
        tinField.setVisible(true);
    }
    @FXML
    void citizenCardShow() {
        citizenCardField.setText(client.getCitizenCardNumber());
        citizenCardField.setVisible(true);
    }
    @FXML
    void emailShow() {
        emailField.setText(client.getEmail());
        emailField.setVisible(true);
    }
    @FXML
    void phoneNumberShow() {
        phoneNumberField.setText(client.getPhoneNumber());
        phoneNumberField.setVisible(true);
    }

    @FXML
    void nameFieldAction() {
        nameField.setText(client.getName());
        nameField.setVisible(true);
    }
}
