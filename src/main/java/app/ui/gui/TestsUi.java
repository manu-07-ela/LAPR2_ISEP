package app.ui.gui;

import app.controller.ViewTestsClientController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
import app.ui.console.AuthUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestsUi implements Initializable {
    private Stage stage;

    private ClientDTO clientDTO;

    private List<TestDTO> testDTOList;

    private ViewTestsClientController viewTestsClientController;
    @FXML
    private TableView<TestDTO> tests;

    @FXML
    private TableColumn<TestDTO, String> description;

    @FXML
    private TableColumn<TestDTO, String> internalCode;



    public void setLabelUi(Stage stage, ClientDTO clientDTO){
        this.stage = stage;
        this.clientDTO = clientDTO;

    }
    public void getTestsByClient(ClientDTO clientDTO){
        this.testDTOList = viewTestsClientController.getAssociatedWithClient(clientDTO);
        System.out.println(testDTOList);
        internalCode.setCellValueFactory(new PropertyValueFactory<>("internalCode"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tests.setItems(getTests());

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
    @FXML
    void selectTestClick() {


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(testDTOList);

    }

    public ObservableList<TestDTO> getTests() {
        ObservableList<TestDTO> tests = FXCollections.observableArrayList();

        for (TestDTO t : testDTOList){
            //System.out.println(c);
            tests.add(t);
        }

        return tests;

    }
}


