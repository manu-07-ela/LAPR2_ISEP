package app.ui.gui;

import app.controller.ImportFileController;
import app.domain.model.users.Client;
import app.mappers.dto.TestDTO;
import app.ui.console.AuthUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportFileUi {
    @FXML
    private TableColumn<Client, String> name;

    @FXML
    private TableColumn<Client, String> tin;

    @FXML
    private TableView<Client> clientRelated;

    private Stage stage;

    @FXML
    private Button exit;

    @FXML
    private Button logout;

    @FXML
    private Button importFile;

    @FXML
    private TextArea textArea;

    private ImportFileController importFileController;

    private List<Client> clientList;
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
        importFile.getScene().getWindow().hide();
        //stage.close();

    }

    @FXML
    void importFileClick() throws IOException {
        clientList = new ArrayList<>();
        importFileController = new ImportFileController();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        List<File> f = fileChooser.showOpenMultipleDialog(null);
        try {
            importFileController.loadFile(f);
        }catch (Exception e){
            e.printStackTrace();
        }
        clientList = importFileController.getClientList();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tin.setCellValueFactory(new PropertyValueFactory<>("tin"));
        clientRelated.setItems(getClients());
        clientRelated.setVisible(true);

    }

    public ObservableList<Client> getClients() {
        ObservableList<Client> clients = FXCollections.observableArrayList();

        for (Client c : clientList){
            //System.out.println(c);
            clients.add(c);
        }

        return clients;

    }



}
