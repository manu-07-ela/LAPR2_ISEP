package app.controller;

import app.domain.model.CSVFileReader;

import java.io.IOException;

public class ImportFileController {

    private CSVFileReader fileread;

    public ImportFileController(){
        this.fileread= new CSVFileReader();
    }

    public void loadFile(String path) throws IOException {
            fileread.read(path);
    }
}
