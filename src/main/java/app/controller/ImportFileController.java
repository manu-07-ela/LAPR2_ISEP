package app.controller;

import app.domain.model.CSVFileReader;
import app.domain.model.users.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImportFileController {

    private CSVFileReader fileread;

    public ImportFileController(){
        this.fileread= new CSVFileReader();
    }

    public void loadFile(List<File> files) throws IOException {
        for (File f : files){
            fileread.read(f);
        }

    }
    public List<Client> getClientList(){
        return fileread.getClientsList();
    }
}
