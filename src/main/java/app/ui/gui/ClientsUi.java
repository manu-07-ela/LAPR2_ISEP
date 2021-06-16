package app.ui.gui;


import app.controller.ItemClientController;
import app.controller.ItemController;
import app.controller.ViewTestsClientController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
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

    private ViewTestsClientController viewTestsClientController = new ViewTestsClientController();

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
    void orderedTinClick() {

    }


    @FXML
    void OrderedNameClick() {
    }

    private List<ClientDTO> getData(){
        List<ClientDTO> clients = new ArrayList<>();
        ClientDTO clientDTO;

        for (int i=0;i<20;i++){
            clientDTO=new ClientDTO("Manuela", "1111111111111111", "11111", "07/09/2002", "female", "283740", "18273", "manu@gmail.com");
            clients.add(clientDTO);
        }
        return clients;
    }


    public void in(MouseEvent mouseEvent) {
        exit.setStyle("-fx-background-color: #1a7180; -fx-border-radius:  15px;-fx-border-width:  3px; -fx-border-color: black;-fx-background-radius: 15px;");
        exit.setTextFill(Paint.valueOf("black"));
    }
    public void out(MouseEvent mouseEvent) {
        exit.setStyle("-fx-background-color:  transparent;-fx-border-radius:  15px;-fx-border-width:  3px;-fx-border-color: #1a7180;-fx-background-radius: 15px;");
        exit.setTextFill(Paint.valueOf("#1a7180"));
    }

    public void inlog(MouseEvent mouseEvent) {
        logout.setStyle("-fx-background-color: #1a7180; -fx-border-radius:  15px;-fx-border-width:  3px; -fx-border-color: black;-fx-background-radius: 15px;");
        logout.setTextFill(Paint.valueOf("black"));
    }
    public void outlog(MouseEvent mouseEvent) {
        logout.setStyle("-fx-background-color:  transparent;-fx-border-radius:  15px;-fx-border-width:  3px;-fx-border-color: #1a7180;-fx-background-radius: 15px;");
        logout.setTextFill(Paint.valueOf("#1a7180"));
    }
}

