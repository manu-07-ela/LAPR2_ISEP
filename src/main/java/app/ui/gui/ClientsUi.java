package app.ui.gui;


import app.controller.ItemClientController;
import app.controller.ItemController;
import app.controller.ViewTestsClientController;
import app.mappers.dto.ClientDTO;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class ClientsUi {

    private Stage stage;
    private ViewTestsClientController viewTestsClientController;
    private List<ClientDTO> clientDTOList;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private CheckBox OrderedName;

    @FXML
    private CheckBox orderedTin;

    @FXML
    private GridPane grid;

    public void setLabelUI(Stage stage) throws IOException {
        this.stage = stage;
        getListOfClients();
        showClientList();
    }

    public void getListOfClients(){
        clientDTOList = viewTestsClientController.getClientList();
    }

    public void showClientList() throws IOException {
        //testsList=getData();
        int row = 1;
        try {
            for (int i=0; i<clientDTOList.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/ClientItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemClientController itemClientController = new ItemClientController();
                itemClientController.setClient(clientDTOList.get(i));

                grid.prefHeight(grid.getPrefHeight()+60);
                grid.add(anchorPane, 0, row);

                row++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void orderedTinClick() {

    }


    @FXML
    void OrderedNameClick() {
    }



}

