package app.ui.gui;

import app.controller.AuthController;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Objects;

public class LoginUi {

    private int tentativas = 3;
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
        if (tentativas > 0) {
            String emailInserido = txtEmail.getText().toLowerCase().trim();
            String passwordInserida = txtPassword.getText();
            boolean sucesso = ctrl.doLogin(emailInserido, passwordInserida);
            if (sucesso) {
                redirectToRoleUI(ctrl.getUserRoles());
                txtEmail.getScene().getWindow().hide();
            } else {
                tentativas--;
            }
        } else {

        }
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
            if (!Objects.isNull(role)) {

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

}
