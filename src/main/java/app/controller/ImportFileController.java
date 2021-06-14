package app.controller;

import app.domain.model.CSVFileReader;
import app.domain.model.Company;

public class ImportFileController {

    /**
     * Represents an instance of app.
     */
    private App app;
    /**
     * Represents a instance of company
     */
    private Company company;

    private CSVFileReader fileread;

    public ImportFileController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.fileread= new CSVFileReader();
    }

    public void loadFile(){
        fileread.read("C:\\Users\\josed\\Documents\\lei-21-s2-1de-g22\\tests_BloodCovidMATCPMDISCCSV.csv");
    }
}
