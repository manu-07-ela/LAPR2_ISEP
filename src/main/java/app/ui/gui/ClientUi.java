package app.ui.gui;

import app.controller.UpdateDataController;
import app.domain.model.users.Client;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientUi {
    private Stage stage;

    private Stage stageUpdateData;

    private UpdateDataUi updateDataUi;

    private Stage stageViewResult;

    private ViewTestResultUi viewTestResultUi;

    private String email;

    UpdateDataController updateDataController;

    Client client;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private VBox updateDataButton;

    @FXML
    private ImageView imageTouch;

    @FXML
    private Label nameField;

    @FXML
    private VBox viewTestResultButton;

    @FXML
    private Label emailField;

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
    void updateDataClick() {
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
    void exitClick() {
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

    @FXML
    public void nameFieldAction(){
        nameField.setText(client.getName());
        nameField.setVisible(true);
    }

    @FXML
    public void emailFieldAction(){
        emailField.setText(client.getEmail());
        emailField.setVisible(true);
    }
}

