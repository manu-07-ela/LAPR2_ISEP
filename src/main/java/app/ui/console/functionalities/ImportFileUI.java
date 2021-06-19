package app.ui.console.functionalities;

import app.controller.ImportFileController;
import app.controller.RegisterTestController;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportFileUI implements Runnable{

    /**
     * Represents a instance of register test controller
     */
    private final ImportFileController importFileController;

    public ImportFileUI(){
        importFileController = new ImportFileController();
    }

    @Override
    public void run() {
        System.out.printf("%nReading file(s)%n");
        try {
            readfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readfile() throws IOException {
        File f = new File("tests_BloodMDISCCSV.csv");
        List<File> flist = new ArrayList<>();
        flist.add(f);
        importFileController.loadFile(flist);
    }
}
