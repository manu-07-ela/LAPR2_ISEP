package app.ui.gui;

import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ClinicalChemistryTecUI {
    private Stage stageViewTests;
    private SeeTestsUI seeTestsUI;
    private Stage stage;
    @FXML
    private ImageView closeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private VBox funcionaliteButton;

    public void setLabelUI(Stage stage) {
        this.stage = stage;
    }
    @FXML
    void logoutButtonClick() {
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

    }

    @FXML
    void functionalityButtonClick() {
        viewTest();

    }

    @FXML
    void closeButtonClick() {
        System.exit(0);

    }
    private void viewTest(){
        try {
            stageViewTests = new Stage();
            stageViewTests.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("\\fxml\\UpdateData.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageViewTests.setScene(scene);

            seeTestsUI = loader.getController();
            stageViewTests.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

}

