package app.ui.gui;

import app.controller.UpdateDataController;
import app.domain.model.users.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UpdateDataUi /*implements Initializable*/ {

    private UpdateDataController updateDataController;
    private Stage stage;
    private Client client;

    @FXML
    private Label errorMessage;
    @FXML
    private ImageView logoManyLabs;

    @FXML
    private TextField writePhoneNumber;

    @FXML
    private Button savePhoneNumber;

    @FXML
    private TextField writeName;

    @FXML
    private Button saveName;

    @FXML
    private TextField writeCitizenCard;

    @FXML
    private Button saveCitizenCard;

    @FXML
    private TextField writeNhsCode;

    @FXML
    private Button saveNhsCode;

    @FXML
    private TextField writeBirthDate;

    @FXML
    private Button saveBirthDate;

    @FXML
    private TextField writeSex;

    @FXML
    private Button saveSex;

    @FXML
    private TextField writeTin;

    @FXML
    private Button saveTin;

    @FXML
    private TextField writeEmail;

    @FXML
    private Button saveEmail;

    public void setLabelUI(Stage stage) {
        this.stage = stage;
    }

    public UpdateDataUi() {
        updateDataController = new UpdateDataController();
    }

    @FXML
    void saveBirthDateClick() {
        String birthDate = writeBirthDate.getText().trim();
        //updateDataController.clientData(client);
        try {
            updateDataController.updateBirthDate(client, birthDate);
            errorMessage.setText("Birth date was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        //updateDataController.clientData(client);
        writeBirthDate.clear();
    }

    @FXML
    void saveCitizenCardClick() {
        //updateDataController.clientData(client);
        String citizenCard = writeCitizenCard.getText().trim();
        try {
            updateDataController.updateCitizenCard(client, citizenCard);
            errorMessage.setText("Citizen Card Number was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        //updateDataController.clientData(client);
        writeCitizenCard.clear();

    }

    @FXML
    void saveEmailClick() {
        //updateDataController.clientData(client);
        String email = writeEmail.getText().trim();
        try {
            updateDataController.updateEmail(client, email);
            errorMessage.setText("Email was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        //updateDataController.clientData(client);
        writeEmail.clear();
    }

    @FXML
    void saveNameClick() {
        //updateDataController.clientData(client);
        String name = writeName.getText().trim();
        /*if(name.isEmpty()) {
            errorMessage.setText("Name can't be empty");
            errorMessage.setVisible(true);
        }
        if (name.length()>35){
            errorMessage.setText("Name should have maximum 35 characters");
            errorMessage.setVisible(true);
        }*/
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
        }
        //updateDataController.clientData(client);
        writeName.clear();



    }

    @FXML
    void saveNhsCodeClick() {
        //updateDataController.clientData(client);
        String nhsCode = writeNhsCode.getText().trim();
        try {
            updateDataController.updateNhsCode(client, nhsCode);
            errorMessage.setText("NHS Code was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        //updateDataController.clientData(client);
        writeNhsCode.clear();

    }

    @FXML
    void saveSexClick() {
        //updateDataController.clientData(client);
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
        }
        //updateDataController.clientData(client);
        writeSex.clear();

    }

    @FXML
    void saveTinClick() {
        String tin = writeTin.getText().trim();
        //updateDataController.clientData(client);
        try {
            updateDataController.updateTin(client, tin);
            errorMessage.setText("Tax Identification Number was updated!");
            errorMessage.setVisible(true);
        }catch (NullPointerException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
        catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setVisible(true);
        }
       // updateDataController.clientData(client);
        writeTin.clear();


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
        }
        //updateDataController.clientData(client);
        writePhoneNumber.clear();
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoManyLabs.setImage(new Image(getClass().getResourceAsStream("images/LogoManyLabs.png")));
    }*/

    public void getClient(String email){
        client = updateDataController.getClientByEmail(email);
    }
}
