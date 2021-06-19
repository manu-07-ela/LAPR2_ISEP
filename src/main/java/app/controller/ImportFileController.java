package app.controller;

import app.domain.model.CSVFileReader;
import app.domain.model.users.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImportFileController {
    /**
     * Represents a instance of CSVFileReader
     */
    private CSVFileReader fileread;

    /**
     * Initialize the instance variable
     */
    public ImportFileController(){
        this.fileread= new CSVFileReader();
    }

    /**
     * Calls the FileReader method to read from the file
     * @param files the list of file we need to read
     * @throws IOException if we have problems to open or close the file
     */
    public void loadFile(List<File> files) throws IOException {
        for (File f : files){
            fileread.read(f);
        }

    }

    /**
     * Gets the customer list created by uploading the file
     * @return the list of clients
     */
    public List<Client> getClientList(){
        return fileread.getClientsList();
    }
}
