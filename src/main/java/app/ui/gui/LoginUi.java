package app.ui.gui;


import app.Serialization;
import app.controller.App;
import app.controller.AuthController;
import app.ui.console.MenuItem;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
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
    AuthController ctrl = new AuthController();
    private Stage stageClient;
    private ClientUi clientUI;


    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblInformation;



    /**
     * Login.
     */
    @FXML
    void login() {

        if (attempts > 1) {
            String emailEntered = txtEmail.getText().trim();
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
                labCoordinatorUi.setLabelUI( stageLabCoordinatorUi);
            }
            if(role.getId().equalsIgnoreCase("CLIENT")){
                runClient();
                //clientUI.setLabelUI(stageClient);
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
            System.out.println("Problems reading the Collaborator's Menu File \n" + ex);
        }
    }
    private void runClient(){
        try {
            stageClient = new Stage();
            stageClient.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("\\fxml\\ClientUi.fxml"));
            Parent root;

            root = loader.load();

            Scene scene = new Scene(root);


            stageClient.setScene(scene);

            clientUI = loader.getController();
            stageClient.show();

        }catch (IOException exception){
            System.out.println("Problems reading the Collaborator's Menu File \n" + exception);
        }
    }

}
