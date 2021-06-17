package app.ui.gui;

import app.controller.ItemClientController;
import app.controller.ItemController;
import app.controller.ViewTestsClientController;
import app.mappers.dto.TestDTO;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class TestsUi {
    private Stage stage;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private GridPane grid;

    private List<TestDTO> tests;

    private ItemClientController itemClientController;

    private ViewTestsClientController viewTestsClientController;

    public TestsUi(){
        itemClientController = new ItemClientController();
        viewTestsClientController = new ViewTestsClientController();
        this.tests = viewTestsClientController.getAssociatedWithClient(itemClientController.getClient());
    }
    public void setLabelUi(Stage stage){
        this.stage = stage;
        showTestsList();
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
            System.out.println("Logout Error: " + ex);
        }
        stage.close();

    }

    public void showTestsList(){
        int row = 1;
        try {
            for (int i=0; i<tests.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(tests.get(i));

                grid.prefHeight(grid.getPrefHeight()+60);
                grid.add(anchorPane, 0, row);

                row++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


