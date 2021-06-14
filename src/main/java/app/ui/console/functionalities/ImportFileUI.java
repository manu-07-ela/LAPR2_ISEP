package app.ui.console.functionalities;

import app.controller.ImportFileController;

import java.io.File;

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
        readfile();
    }

    public void readfile(){
        filectrl.loadFile();
    }
}
