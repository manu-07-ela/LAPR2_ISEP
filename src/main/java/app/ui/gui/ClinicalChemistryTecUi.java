package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.ui.console.AuthUI;
import app.ui.console.functionalities.RecordResultsUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ClinicalChemistryTecUi {

    private Stage stageViewTests;

    private ClientsUi clientsUI;

    private Stage stage;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private VBox consultTheTests;

    @FXML
    private VBox recordResults;

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
            ex.printStackTrace();
        }
        stage.close();

    }


    @FXML
    void consultTheTestsClick() throws IOException {
        viewTest();
        clientsUI.setLabelUI(stageViewTests);

    }

    @FXML
    void recordResultsClick() {
        RecordResultsUI recordResultsUI = new RecordResultsUI();
        recordResultsUI.run();
    }

    private void viewTest(){
        try {
            stageViewTests = new Stage();
            stageViewTests.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ViewHistoricalTests.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageViewTests.setScene(scene);
            clientsUI = loader.getController();
            stageViewTests.show();

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }


}



