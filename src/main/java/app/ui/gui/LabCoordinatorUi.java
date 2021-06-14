package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LabCoordinatorUi {
    private Stage stage;

    private Stage stageImportFiles;

    private ImportFileUi importFileUi;
    @FXML
    private VBox viewTests;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private VBox validateWork;

    @FXML
    private VBox importTest;

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
            System.out.println("Logout Error: " + ex);
        }
        stage.close();

    }

    @FXML
    void validateWorkClick() {

    }

    @FXML
    void viewTestsClick() {

    }

    @FXML
    void importTestClick() {
        viewImportFiles();
    }

    private void viewImportFiles(){
        try {
            stageImportFiles = new Stage();
            stageImportFiles.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ImportFile.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageImportFiles.setScene(scene);
            importFileUi = loader.getController();
            stageImportFiles.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

}

