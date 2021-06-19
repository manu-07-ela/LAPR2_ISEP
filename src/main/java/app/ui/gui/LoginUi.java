package app.ui.gui;


import app.Serialization;
import app.controller.App;
import app.controller.AuthController;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class LoginUi {

    private int attempts = 3;
    private Stage stageLabCoordinatorUi;
    private LabCoordinatorUi labCoordinatorUi;
    private Stage stageAdminUi;
    private AdmUi adminUi;
    private Stage stageClinicalCheTec;
    private ClinicalChemistryTecUi clinicalChemistryTecUI;
    AuthController ctrl = new AuthController();
    private Stage stageClient;
    private ClientUi clientUI;
    private Stage stageReceptionist;
    private ReceptionistUi receptionistUi;
    private Stage stageMedLabTec;
    private MedLabTecUi medLabTecUi;
    private Stage stageDoctor;
    private SpecialistDoctorUi specialistDoctorUi;

    @FXML
    private Button exit;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblInformation;
    String emailEntered;


    /**
     * Login.
     */
    @FXML
    void login() {

        if (attempts > 1) {
            emailEntered = txtEmail.getText().trim();
            String passwordEntered = txtPassword.getText();
            boolean success = ctrl.doLogin(emailEntered, passwordEntered);
            if (success) {
                redirectToRoleUI(ctrl.getUserRoles());
                txtEmail.getScene().getWindow().hide();
            } else {
                attempts--;
                lblInformation.setText("Incorrect Data. Remaining Attempts: " + attempts);
                lblInformation.setVisible(true);
            }
        } else {
            Serialization.saveApp(App.getInstance(), "SavedData.data");
            closePlatform();
        }
    }

    /**
     * Close platform.
     */
    @FXML
    public void closePlatform() {
        System.exit(0);
    }

    /**
     * redirects to ui method
     *
     * @param
     */
    private void redirectToRoleUI(List<UserRoleDTO> rolesUi) {
        UserRoleDTO role = selectsRole(ctrl.getUserRoles());
        if (!Objects.isNull(role))
        {
            if (role.getId().equals("LABORATORY COORDINATOR")) {
                runLabCoordinator();
                labCoordinatorUi.setLabelUI(stageLabCoordinatorUi);
            }
            if(role.getId().equals("CLIENT")){
                runClient();
                clientUI.setLabelUI(stageClient);
            }
            if(role.getId().equals("ADMINISTRATOR")){
                runAdmin();
                adminUi.setLabelUI(stageAdminUi);
            }
            if (role.getId().equals("RECEPTIONIST")){
                runReceptionist();
                receptionistUi.setLabelUI(stageReceptionist);
            }
            if (role.getId().equals("MEDICAL LAB TECHNICIAN")){
                runMedLabTec();
                medLabTecUi.setLabelUI(stageMedLabTec);
            }
            if (role.getId().equals("SPECIALIST DOCTOR")){
                runDoctor();
                specialistDoctorUi.setLabelUI(stageDoctor);
            }
            if(role.getId().equals("CLINICAL CHEMISTRY TECHNICIAN")){
                runClinicalCheTec();
                clinicalChemistryTecUI.setLabelUI(stageClinicalCheTec);
            }
        }
    }

    /**
     * selects user role
     *
     * @param roles
     * @return
     */
    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }

    /**
     * runs collaborator menu
     */
    private void runLabCoordinator() {
        try {
            stageLabCoordinatorUi = new Stage();
            stageLabCoordinatorUi.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LabCoordinatorUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);

            stageLabCoordinatorUi.setScene(scene);
            labCoordinatorUi = loader.getController();
            stageLabCoordinatorUi.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void runClient(){
        try {
            stageClient = new Stage();
            stageClient.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ClientUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageClient.setScene(scene);

            clientUI = loader.getController();
            clientUI.emailClient(emailEntered);
            stageClient.show();


        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
    /**
     * runs collaborator menu
     */
    private void runAdmin() {
        try {
            stageAdminUi = new Stage();
            stageAdminUi.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);

            stageAdminUi.setScene(scene);
            adminUi = loader.getController();
            stageAdminUi.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void runClinicalCheTec() {
        try {
            stageClinicalCheTec = new Stage();
            stageClinicalCheTec.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClinicalCheTecUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);

            stageClinicalCheTec.setScene(scene);
            clinicalChemistryTecUI = loader.getController();
            stageClinicalCheTec.show();

        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    private void runReceptionist() {
        try {
            stageReceptionist = new Stage();
            stageReceptionist.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReceptionistUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);

            stageReceptionist.setScene(scene);
            receptionistUi = loader.getController();
            stageReceptionist.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void runMedLabTec() {
        try {
            stageMedLabTec = new Stage();
            stageMedLabTec.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MedLabTecUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);

            stageMedLabTec.setScene(scene);
            medLabTecUi = loader.getController();
            stageMedLabTec.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void runDoctor() {
        try {
            stageDoctor = new Stage();
            stageDoctor.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SpecialistDoctor.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);

            stageDoctor.setScene(scene);
            specialistDoctorUi = loader.getController();
            stageDoctor.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void exitIn(){
        exit.setStyle("-fx-background-color: #ffffff;-fx-background-radius: 15px; -fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 , 10.0)");
        exit.setTextFill(Paint.valueOf("#1a7180"));

    }
    @FXML
    void exitOut(){
        exit.setStyle("-fx-background-color: #1a7180;-fx-background-radius: 15px; -fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 , 10.0)");
        exit.setTextFill(Paint.valueOf("#ffffff"));
    }
    @FXML
    void logoutIn(){
        btnLogin.setStyle("-fx-background-color: #ffffff;-fx-background-radius: 15px; -fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 , 10.0)");
        btnLogin.setTextFill(Paint.valueOf("#1a7180"));

    }
    @FXML
    void logoutOn(){
        btnLogin.setStyle("-fx-background-color: #1a7180;-fx-background-radius: 15px; -fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0.1), 10.0 , 0.0 , 0.0 , 10.0)");
        btnLogin.setTextFill(Paint.valueOf("#ffffff"));
    }
}
