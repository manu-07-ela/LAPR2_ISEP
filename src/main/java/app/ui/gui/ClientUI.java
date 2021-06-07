
package app.ui.gui;


import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseEvent;

public class ClientUI {
    
    private Stage stage;
    private UpdateDataUi updateDataUi;
    @FXML
    private TextField typedSearch;

    @FXML
    private Button searchButton;

    @FXML
    private VBox updateDataButton;

    @FXML
    private VBox viewTextResultsButton;

    public void setLabelUI(Stage stageClient) {
        this.stage = stageClient;
    }

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


