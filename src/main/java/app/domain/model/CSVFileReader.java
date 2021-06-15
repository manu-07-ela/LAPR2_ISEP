package app.domain.model;

import app.controller.App;
import app.domain.model.users.Client;
import app.domain.store.ClientStore;
import auth.AuthFacade;

import java.io.*;

public class CSVFileReader {

    public CSVFileReader(){
        this(App.getInstance().getCompany());
    }

    public CSVFileReader(Company company){
        this.company = App.getInstance().getCompany();
        this.clstore = company.getClientStore();
        clAuthFacade = company.getAuthFacade();
        this.cl = null;
    }

    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of client
     */
    private Client cl;
    /**
     * Represents an instance of the client store
     */
    private ClientStore clstore;
    /**
     * Represents an instance Auth facade
     */
    private AuthFacade clAuthFacade;

    public void read(String csvFile) throws IOException {

            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String delimiter = ";";
            int i=0;
            String[] tempArr;
            line = br.readLine();
            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                i++;
                cl=clstore.getClientbytin(tempArr[5]);
                if(cl==null) {
                    try {
                        cl = new Client(tempArr[8], tempArr[3], tempArr[4], tempArr[6], tempArr[5], tempArr[7], tempArr[9],tempArr[10]);
                    } catch (IllegalArgumentException e) {
                        System.out.printf("Error in line %d : %s\n", i, e.getMessage());
                    }
                    clstore.saveClient(cl, clAuthFacade);
                }else{
                    System.out.printf("Error in line %d : That client alredy exists in the system\n", i);
                }
            }
            br.close();
    }
    }
