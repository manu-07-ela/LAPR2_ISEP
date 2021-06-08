package app.ui.gui;

import app.controller.UpdateDataController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class UpdateDataUi {

    private UpdateDataController updateDataController;
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
    void saveBirthDateClick(MouseEvent event) {
        if (saveBirthDate.isPressed()){
            String birthDate = writeBirthDate.getText().trim();
            updateDataController.updateBirthDate(birthDate);
        }
    }

    @FXML
    void saveCitizenCardClick(MouseEvent event) {
        if (saveCitizenCard.isPressed()){
            String citizenCard = writeCitizenCard.getText().trim();
            updateDataController.updateCitizenCard(citizenCard);
        }
    }

    @FXML
    void saveEmailClick(MouseEvent event) {
        if (saveEmail.isPressed()){
            String email = writeEmail.getText().trim();
            updateDataController.updateEmail(email);
        }

    }

    @FXML
    void saveNameClick(MouseEvent event) {
        if (saveName.isPressed()){
            String name = writeName.getText().trim();
            updateDataController.updateName(name);
        }

    }

    @FXML
    void saveNhsCodeClick(MouseEvent event) {
        if (saveNhsCode.isPressed()){
            String nhsCode = writeNhsCode.getText().trim();
            updateDataController.updateNhsCode(nhsCode);
        }

    }

    @FXML
    void saveSexClick(MouseEvent event) {
        if (saveSex.isPressed()){
            String sex = writeSex.getText().trim();
            updateDataController.updateSex(sex);
        }


    }

    @FXML
    void saveTinClick(MouseEvent event) {
        if (saveTin.isPressed()){
            String tin = writeTin.getText().trim();
            updateDataController.updateTin(tin);
        }

    }
    @FXML
    void savePhoneNumberClick(ActionEvent event) {
        if (savePhoneNumber.isPressed()){
            String phoneNumber = writePhoneNumber.getText().trim();
        }

    }

}
