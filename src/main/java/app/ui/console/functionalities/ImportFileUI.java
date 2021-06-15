package app.ui.console.functionalities;

import app.controller.ImportFileController;

import java.io.File;
import java.io.IOException;

public class ImportFileUI implements Runnable{

    /**
     * Represents a instance of register test controller
     */
    private final ImportFileController filectrl;

    public ImportFileUI(){
        filectrl = new ImportFileController();
    }

    public void run(){
        System.out.printf("%nReading File%n");
        try {
            readfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readfile() throws IOException {
        filectrl.loadFile("tests_BloodMDISCCSV.csv");
    }
}
