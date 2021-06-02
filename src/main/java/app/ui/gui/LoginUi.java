package app.ui.gui;

import app.controller.AuthController;
import app.ui.console.MenuItem;
import auth.mappers.dto.UserRoleDTO;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class LoginUi {

    private int tentativas = 3;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    /**
     * Login.
     */
    @FXML
    public void login() {
        if (tentativas > 1) {
            String emailInserido = txtEmail.getText().toLowerCase().trim();
            String passwordInserida = txtPassword.getText();
            AuthController ctrl = new AuthController();
            boolean sucesso = ctrl.doLogin(emailInserido, passwordInserida);
            if (sucesso) {

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
    private void redirectToRoleUI (List<MenuItem> rolesUI, UserRoleDTO role) {


    }

}
