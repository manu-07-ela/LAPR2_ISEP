package app.ui.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

    public class MedLabTecUi {

        @FXML
        private Button exit;

        @FXML
        private VBox recordSample;

        @FXML
        private Button logout;

        @FXML
        private BorderPane brdPane;

        @FXML
        void exitClick() {
            System.exit(0);
        }

        @FXML
        void logoutClick() {

        }

        @FXML
        void recordSampleClick() {
        }
    }
