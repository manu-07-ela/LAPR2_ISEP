package app.controller;

import app.mappers.dto.ClientDTO;
import app.ui.gui.ClientsUi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ItemClientController {

    @FXML
    private Button selectClient;

    @FXML
    private Label name;

    @FXML
    private Label citizenCardNumber;

    private ClientDTO clientDTO;

    private Stage clientStage;

    private ClientsUi clientsUi;

    public void setClient(ClientDTO client){
        this.clientDTO = client;
        name.setText(clientDTO.getName());
        citizenCardNumber.setText(clientDTO.getCitizenCardNumber());
    }
    @FXML
    void selectClientClick() throws IOException {
        runClients();
        clientsUi.setLabelUI(clientStage);
        name.getScene().getWindow().hide();

    }

    public void runClients(){
        try {
            clientStage = new Stage();
            clientStage.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("/fxml/ViewHistoricalTests.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            clientStage.setScene(scene);

            clientsUi = loader.getController();
            clientStage.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

}

