package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.ItemController;
import app.controller.ViewResultsController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTestResultUi implements Initializable {

    /**
     * Represents a instance of view results controller
     */
    private final ViewResultsController viewResultsCtrl = new ViewResultsController();

    private Stage stage;

    private ClientDTO client;

    private List<TestDTO> testsList;

    @FXML
    private Label testCode;

    @FXML
    private GridPane grid;

    @FXML
    private Label testDescription;

    public void setLabelUI(Stage stageViewResult) throws IOException {
        this.stage = stageViewResult;
        getClient();
        getTestsList();
        showTestsList();
    }

    public void getClient(){
        client = viewResultsCtrl.getUserSession();
    }

    public void getTestsList(){
       testsList = viewResultsCtrl.getTestList(client);
    }

    public void showTestsList() throws IOException {
        int row = 1;
        try {
            for (int i=0; i<testsList.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(testsList.get(i));

                grid.prefHeight(grid.getPrefHeight()+60);
                grid.add(anchorPane, 0, row);

                row++;

            }
        } catch (IOException e) {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
