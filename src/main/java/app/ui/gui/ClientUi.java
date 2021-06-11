package app.ui.gui;

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
import java.net.URL;
import java.util.ResourceBundle;

public class ClientUi /*implements Initializable*/ {

    private Stage stage;
    private Stage stageUpdateData;
    private UpdateDataUi updateDataUi;
    private Stage stageViewResult;
    private ViewTestResultUi viewTestResultUi;

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
    }

    @FXML
    void viewTestResultsClick() {
        runViewTestResult();
        viewTestResultUi.setLabelUI(stageViewResult);
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
}
