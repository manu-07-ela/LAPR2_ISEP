package app.ui.gui;

import app.Serialization;
import app.controller.App;
import app.controller.UpdateDataController;
import app.domain.model.users.Client;
import app.ui.console.AuthUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class UpdateDataUi {
    private UpdateDataController updateDataController;

    private Stage stage;

    private Client client;

    @FXML
    private TextField writeName;

    @FXML
    private TextField writePhoneNumber;

    @FXML
    private Label errorMessage;

    @FXML
    private Button saveSex;

    @FXML
    private TextField writeTin;

    @FXML
    private Button saveNhsCode;

    @FXML
    private TextField writeNhsCode;

    @FXML
    private Button exit;

    @FXML
    private Button saveBirthDate;

    @FXML
    private Button logout;

    @FXML
    private TextField writeBirthDate;

    @FXML
    private Button saveCitizenCard;

    @FXML
    private TextField writeSex;

    @FXML
    private Button saveEmail;

    @FXML
    private TextField writeEmail;

    @FXML
    private Button savePhoneNumber;

    @FXML
    private Button saveName;

    @FXML
    private Button saveTin;

    @FXML
    private TextField writeCitizenCard;

    @FXML
    private TextField writeAddress;

    @FXML
    private Button saveAddress;

    public void setLabelUI(Stage stage) {
        this.stage = stage;
    }

    public UpdateDataUi() {
        updateDataController = new UpdateDataController();
    }

    public void getClient(String email){
        client = updateDataController.getClientByEmail(email);
    }


    @FXML
    void saveNameClick() {

        String name = writeName.getText().trim();
        try {
            updateDataController.updateName(client, name);
            errorMessage.setText("Name was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        writeName.clear();



    }



    @FXML
    void saveSexClick() {

        String sex = writeSex.getText().trim();
        try {
            updateDataController.updateSex(client, sex);
            errorMessage.setText("Sex was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        writeSex.clear();

    }


    @FXML
    void savePhoneNumberClick() {
        String phoneNumber = writePhoneNumber.getText().trim();
        try {
            updateDataController.updatePhoneNumber(client, phoneNumber);
            errorMessage.setText("Phone number was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        writePhoneNumber.clear();
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
            System.out.println("Logout error: " + ex);
        }
        stage.close();
    }
    @FXML
    void saveAddressClick() {

        String address = writeAddress.getText().trim();
        try {
            updateDataController.updateAddress(client, address);
            errorMessage.setText("Address was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        writeAddress.clear();

    }
    @FXML
    void exitIn() {
        exit.setStyle("-fx-background-color: #1a7180;-fx-background-radius: 15px");
        exit.setTextFill(Paint.valueOf("#ffffff"));
    }

    @FXML
    void exitOut(){
        exit.setStyle("-fx-background-color: #EAEEEE;-fx-background-radius: 15px");
        exit.setTextFill(Paint.valueOf("#0f3648"));

    }

    @FXML
    void logoutIn() {
        logout.setStyle("-fx-background-color: #1a7180;-fx-background-radius: 15px");
        logout.setTextFill(Paint.valueOf("#ffffff"));
    }

    @FXML
    void logoutOut(){
        logout.setStyle("-fx-background-color: #EAEEEE;-fx-background-radius: 15px");
        logout.setTextFill(Paint.valueOf("#0f3648"));

    }


}
