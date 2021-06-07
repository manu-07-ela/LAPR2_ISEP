package app.ui.gui;


import app.controller.AuthController;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;



import javafx.scene.control.Button;

import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;


public class LoginUi {

    private int attempts = 3;
    private Stage stageLabCoordinatorUi;
    private LabCoordinatorUi labCoordinatorUi;
    AuthController ctrl = new AuthController();

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;


    /**
     * Login.
     */
    @FXML
    void login() {
        if (attempts > 0) {
            String emailEntered = txtEmail.getText().trim();
            String passwordEntered = txtPassword.getText();
            boolean success = ctrl.doLogin(emailEntered, passwordEntered);
            if (success) {
                redirectToRoleUI(ctrl.getUserRoles());
                txtEmail.getScene().getWindow().hide();
            } else {
                attempts--;
            }
        } else {

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
    private void redirectToRoleUI (List<UserRoleDTO> rolesUi) {

        if ( (rolesUi == null) || (rolesUi.isEmpty()) ) {

        } else {
            UserRoleDTO role = selectsRole(ctrl.getUserRoles());
            if (role.getId().equals("LABORATORY COORDINATOR")) {
                runLabCoordinator();
                //labCoordinatorUi.setLabelUI(stageLabCoordinatorUi);
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

}
