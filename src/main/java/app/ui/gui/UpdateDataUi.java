package app.ui.gui;

import app.controller.UpdateDataController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateDataUi /*implements Initializable*/ {

    private UpdateDataController updateDataController;
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

    public UpdateDataUi() {
        updateDataController = new UpdateDataController();
    }

    @FXML
    void saveBirthDateClick() {
        String birthDate = writeBirthDate.getText().trim();
        updateDataController.updateBirthDate(birthDate);
    }

    @FXML
    void saveCitizenCardClick() {
        String citizenCard = writeCitizenCard.getText().trim();
        updateDataController.updateCitizenCard(citizenCard);

    }

    @FXML
    void saveEmailClick() {
        String email = writeEmail.getText().trim();
        updateDataController.updateEmail(email);


    }

    @FXML
    void saveNameClick() {
        String name = writeName.getText().trim();
        updateDataController.updateName(name);


    }

    @FXML
    void saveNhsCodeClick() {
        String nhsCode = writeNhsCode.getText().trim();
        updateDataController.updateNhsCode(nhsCode);
    }

    @FXML
    void saveSexClick() {
        String sex = writeSex.getText().trim();
        updateDataController.updateSex(sex);

    }

    @FXML
    void saveTinClick() {
        String tin = writeTin.getText().trim();
        updateDataController.updateTin(tin);


    }
    @FXML
    void savePhoneNumberClick() {
        String phoneNumber = writePhoneNumber.getText().trim();
        updateDataController.updatePhoneNumber(phoneNumber);
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoManyLabs.setImage(new Image(getClass().getResourceAsStream("images/LogoManyLabs.png")));
    }*/
}
