package app.ui.gui;

import app.controller.SeeTestsController;
import app.mappers.dto.ClientDTO;
import app.ui.console.AuthUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientsUi implements Initializable {

    private final SeeTestsController seeTestsController;

    private List<ClientDTO> clientDTOList;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private CheckBox orderedName;

    @FXML
    private CheckBox orderedTin;

    @FXML
    private Label errorMessage;

    private int disableName;

    private int disableTin;
    @FXML
    private TableColumn<ClientDTO, String> name;

    @FXML
    private TableColumn<ClientDTO, String> tin;

    @FXML
    private TableView<ClientDTO> table;

    @FXML
    private Button selectedClient;


    @FXML
    void selectedClientClick() throws IOException {
        ClientDTO client = table.getSelectionModel().getSelectedItems().get(0);

        Stage tests = new Stage();
        tests.initStyle(StageStyle.UNDECORATED);

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Tests.fxml"));
        Parent root;

        root = loader.load();

        Scene scene = new Scene(root);


        tests.setScene(scene);
        TestsUi testsUi = loader.getController();
        testsUi.getTestsByClient(client);
        tests.show();
        testsUi.setLabelUi(tests, client);
        logout.getScene().getWindow().hide();

    }

    public ClientsUi(){
        seeTestsController = new SeeTestsController();
    }

    public void setLabelUI(Stage stage) throws IOException {
        try {
            getListOfClients();
       }catch (Exception e){
            errorMessage.setText("There are no clients with validated tests");
            table.setVisible(false);
            errorMessage.setVisible(true);
            orderedTin.setDisable(true);
            orderedName.setDisable(true);
            selectedClient.setDisable(true);
       }
    }

    public void getListOfClients(){
        clientDTOList = seeTestsController.getClientList();
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
            System.out.println("Logout error: " + ex);
        }
        logout.getScene().getWindow().hide();

    }



   @FXML
    void orderedTinClick() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        disableName++;
        clientDTOList = seeTestsController.getClientListByTin();
        try {
            if (disableName %2 != 0){
                orderedName.setDisable(true);
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                tin.setCellValueFactory(new PropertyValueFactory<>("tin"));
                table.setItems(getClients());
                table.setVisible(true);
            }else {
                orderedName.setDisable(false);
                table.setVisible(false);
            }

        }catch (Exception e){
            errorMessage.setText("There are no clients with validated tests");
            errorMessage.setVisible(true);
        }
    }


    @FXML
    void OrderedNameClick() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        disableTin++;
        clientDTOList = seeTestsController.getClientsListByAlphabeticalOrder();
        try {
            if (disableTin %2 != 0){
                orderedTin.setDisable(true);
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                tin.setCellValueFactory(new PropertyValueFactory<>("tin"));
                table.setItems(getClients());
                table.setVisible(true);
            }else {
                orderedTin.setDisable(false);
                table.setVisible(false);
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

    public ObservableList<ClientDTO> getClients() {
        ObservableList<ClientDTO> clients = FXCollections.observableArrayList();
        for (ClientDTO c : clientDTOList){
            clients.add(c);
        }

        return clients;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setVisible(false);
    }
}

