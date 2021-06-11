package app.ui.gui;

import app.domain.model.users.Client;
import app.ui.console.AuthUI;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ClientUi /*implements Initializable*/ {

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



    public void setLabelUI(Stage stageClient) {
        this.stage = stageClient;
    }

    @FXML
    public void updateDataClick() {
        runUpdateData();
        updateDataUi.setLabelUI(stageUpdateData);
        updateDataUi.getClient(email);
    }

    @FXML
    void viewTestResultsClick() throws IOException {
        runViewTestResult();
        viewTestResultUi.setLabelUI(stageViewResult);
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

   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageTouch.setImage(new Image(getClass().getResourceAsStream("images/touch.png")));

    }*/
   public void emailClient(String email){
       this.email = email;
   }
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
}
