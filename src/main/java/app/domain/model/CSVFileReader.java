package app.domain.model;

import app.controller.App;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.TestParameter;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
import app.domain.store.*;
import auth.AuthFacade;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVFileReader {

    public CSVFileReader(){
        this(App.getInstance().getCompany());
    }

    public CSVFileReader(Company company){
        this.company = App.getInstance().getCompany();
        this.clStore = company.getClientStore();
        clAuthFacade = company.getAuthFacade();
        this.tStore=company.getTestStore();
        this.ttStore=company.getTestTypeStore();
        this.pmStore = company.getParameterStore();
        this.calStore = company.getClinicalAnalysisLaboratoryStore();
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
    private ClientStore clStore;
    /**
     * Represents an instance of the test store
     */
    private TestStore tStore;
    /**
     * Represents an instance Auth facade
     */
    private AuthFacade clAuthFacade;
    /**
     * Represents an instance of the Parameter store
     */
    private ParameterStore pmStore;
    /**
     * Represents an instance of the Test Type store
     */
    private TestTypeStore ttStore;
    /**
     * Represents an instance of the Clinical Analysis Laboratory store
     */
    private ClinicalAnalysisLaboratoryStore calStore;

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
                cl= clStore.getClientbytin(tempArr[5]);
                if(cl==null) {
                    try {
                        cl = new Client(tempArr[8], tempArr[3], tempArr[4], tempArr[6], tempArr[5], tempArr[7], tempArr[9],tempArr[10]);
                    } catch (IllegalArgumentException e) {
                        System.out.printf("Error in line %d : %s\n", i, e.getMessage());
                    }
                    clStore.saveClient(cl, clAuthFacade);
                    Date mr = new Date(tempArr[23]);
                    Date lcv = new Date(tempArr[24]);
                    Date samples = new Date(tempArr[21]);
                    Date tpr = new Date(tempArr[22]);
                    NhsCode nhsCode = new NhsCode(tempArr[1]);
                    createTest(pmStore.getParameterByCode("HB000"),cl,nhsCode, ttStore.getTestTypeByCode("BL000"), calStore.getClinicalAnalysisLaboratoryByLabId(tempArr[2]), tStore.generateInternalCode(i), samples, tpr, lcv,mr);
                }else{
                    System.out.printf("Error in line %d : That client alredy exists in the system\n", i);
                }
            }
            br.close();
    }

    private void createTest(Parameter parameter, Client cl, NhsCode nhscode, TestType testType,ClinicalAnalysisLaboratory lab, String internalCode, Date samplesAddDate, Date chemicalAnalysisDate, Date LabCoordDate, Date createdAt){
        TestParameter tparam = new TestParameter(parameter);
        List<TestParameter> listpm = new ArrayList<>();
        listpm.add(tparam);
        Test t = new Test(cl,nhscode,testType,listpm,lab,internalCode,samplesAddDate,chemicalAnalysisDate,LabCoordDate,createdAt);
        tStore.saveTest(t);
    }

//    private List<TestParameter> testParameterList(){
//
//    }

    }
