package app.controller;

import app.mappers.dto.ClientDTO;
import app.ui.gui.ClientsUi;
import app.ui.gui.TestsUi;
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
    private Label tin;

    private ClientDTO clientDTO;

    private Stage testStage;

    private ViewTestsClientController viewTestsClientController;

    private TestsUi testsUi;

    public ItemClientController(){
        viewTestsClientController = new ViewTestsClientController();
    }

    public void setClient(ClientDTO client){
        this.clientDTO = client;
        name.setText(clientDTO.getName());
        tin.setText(clientDTO.getTin());
    }
    @FXML
    void selectClientClick(){
        runClients();
        testsUi.setLabelUi(testStage);
        name.getScene().getWindow().hide();
    }

    public ClientDTO getClient(){
        return viewTestsClientController.getClientByTin(tin.getText());
    }

    public void runClients(){
        try {
            testStage = new Stage();
            testStage.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Tests.fxml"));
            System.out.println("1");
            Parent root;

            root = loader.load();
            System.out.println("3");

            Scene scene = new Scene(root);

            System.out.println("4");
            testStage.setScene(scene);
            System.out.println("2");
            testsUi = loader.getController();
            System.out.println(testsUi);
            testStage.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

}

