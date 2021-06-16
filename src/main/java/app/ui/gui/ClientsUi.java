package app.ui.gui;


import app.controller.ItemClientController;
import app.controller.ViewTestsClientController;
import app.mappers.dto.ClientDTO;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
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
    private CheckBox orderedName;

    @FXML
    private CheckBox orderedTin;

    @FXML
    private GridPane grid;

    @FXML
    private Label errorMessage;

    private int disableName;

    private int disableTin;

    public ClientsUi(){
        viewTestsClientController = new ViewTestsClientController();
    }

    public void setLabelUI(Stage stage) throws IOException {
        this.stage = stage;
       try {
            getListOfClients();
       }catch (Exception e){
            errorMessage.setText("There are no clients with validated tests");
            errorMessage.setVisible(true);
            orderedTin.setDisable(true);
            orderedName.setVisible(true);
       }
    }

    public void getListOfClients(){
        clientDTOList = viewTestsClientController.getClientList();
    }

    private void showClientList() {
        //clientDTOList = getData();
        int row = 1;
        try {
            for (int i=0; i<clientDTOList.size();i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/ClientItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemClientController itemClientController = fxmlLoader.getController();
                System.out.println(clientDTOList.get(i));
                System.out.println(i);
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
        logout.getScene().getWindow().hide();

    }



   @FXML
    void orderedTinClick() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        disableName++;
        clientDTOList = viewTestsClientController.getClientListByTin();
        try {
            if (disableName %2 != 0){
                orderedName.setDisable(true);
                showClientList();
                grid.setVisible(true);
            }else {
                orderedName.setDisable(false);
                grid.setVisible(false);
            }

        }catch (Exception e){
            errorMessage.setText("There are no clients with validated tests");
            errorMessage.setVisible(true);
        }
    }


    @FXML
    void OrderedNameClick() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        disableTin++;
        clientDTOList = viewTestsClientController.getClientsListByAlphabeticalOrder();
        try {
            if (disableTin %2 != 0){
                orderedTin.setDisable(true);
                showClientList();
                grid.setVisible(true);
            }else {
                orderedTin.setDisable(false);
                grid.setVisible(false);
            }
        }catch (Exception e){
            errorMessage.setText("There are no clients with validated tests");
            errorMessage.setVisible(true);
        }
    }



    public void in() {
        exit.setStyle("-fx-background-color: #ffffff ;-fx-background-radius: 15px");
        exit.setTextFill(Paint.valueOf("#1a7180"));
    }
    public void out() {
        exit.setStyle("-fx-background-color: #1a7180;-fx-background-radius: 15px");
        exit.setTextFill(Paint.valueOf("#ffffff"));
    }

    public void inLog() {
        logout.setStyle("-fx-background-color: #ffffff ;-fx-background-radius: 15px");
        logout.setTextFill(Paint.valueOf("#1a7180"));
    }
    public void onLog(){
        logout.setStyle("-fx-background-color: #1a7180;-fx-background-radius: 15px");
        logout.setTextFill(Paint.valueOf("#ffffff"));
    }
}

