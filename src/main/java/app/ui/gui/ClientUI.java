package app.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import java.awt.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseEvent;

public class ClientUI {
    private UpdateDataUi updateDataUi;
    @FXML
    private TextField typedSearch;

    @FXML
    private Button searchButton;

    @FXML
    private VBox updateDataButton;

    @FXML
    private VBox viewTextResultsButton;

    @FXML
    void UpdateDataClickBotton(MouseEvent event) {
        if (updateDataButton.isPressed()){
            
        }

    }

    @FXML
    void searchClickButton(MouseEvent event) {

    }

    @FXML
    void typedSearchData(InputMethodEvent event) {

    }

    @FXML
    void viewTextResultsClickBotton(MouseEvent event) {

    }

}
