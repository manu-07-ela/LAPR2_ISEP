package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.SeeTestsController;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestsUi implements Initializable {

    private Stage stageViewResult;
    private Stage stage;
    private ViewResultsUi viewResultsUi;
    private ClientDTO clientDTO;

    private List<TestDTO> testDTOList;

    private SeeTestsController seeTestsController;
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
        seeTestsController = new SeeTestsController();
        this.testDTOList = seeTestsController.getAssociatedWithClient(clientDTO);
        internalCode.setCellValueFactory(new PropertyValueFactory<>("internalCode"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tests.setItems(getTests());

    }
    @FXML
    void exitClick() {
        Serialization.saveApp(App.getInstance(), "SavedData.data");
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
            ex.printStackTrace();
        }
        stage.close();

    }
    @FXML
    void selectTestClick() throws IOException {
        TestDTO test = tests.getSelectionModel().getSelectedItems().get(0);
        runViewResults();
        viewResultsUi.setLabelUI(stageViewResult, test);
        viewResultsUi.getLabelMedicalReport().setText("You are not allowed to see the medical report");
        tests.getScene().getWindow().hide();


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
    public void runViewResults(){
        try {
            stageViewResult = new Stage();
            stageViewResult.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ViewResults.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageViewResult.setScene(scene);

            viewResultsUi = loader.getController();
            stageViewResult.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }
}


