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
     * Represents an instance of the Parameter store
     */
    private ParameterCategoryStore pmcStore;
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
        tempArr = line.split(delimiter);
        List<String> parameterstest=new ArrayList<>();
        List<String> parametersString=new ArrayList<>();
        List<Integer> parametersIndextest=new ArrayList<>();
        List<TestParameter> tpList = new ArrayList<>();
//        List<Integer> parameterCategorytest=new ArrayList<>();
        List<String> invalidParameters= new ArrayList<>();
        List<Parameter> pmList = new ArrayList<>();

        for (int n=1; n<tempArr.length;n++){

            if (tempArr[n-1].equalsIgnoreCase("Category")){
//                parameterCategorytest.add(n-1);
                while (!tempArr[n].equalsIgnoreCase("Category") && !tempArr[n].equalsIgnoreCase("Test_Reg_DateHour")){
                    parameterstest.add(tempArr[n]);
                    parametersIndextest.add(i);
                    n++;
                    System.out.println(n);
                }
            }
        }

        parametersString=fillParameters(parameterstest,invalidParameters,parametersString);
        pmList=convertStringIntoParameter(parametersString,pmList);
        tpList=convertParameterIntoTestParameter(pmList,tpList);
//        parameterCategory(parameterCategorytest,tempArr);


            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                i++;
                cl= clStore.getClientbytin(tempArr[5]);
                if(cl==null) {
                    try {
                        cl = new Client(tempArr[8], tempArr[3], tempArr[4], tempArr[6], tempArr[5], tempArr[7], tempArr[9],tempArr[10]);
                        clStore.saveClient(cl, clAuthFacade);
                        Date mr = new Date(tempArr[23]);
                        Date lcv = new Date(tempArr[24]);
                        Date samples = new Date(tempArr[21]);
                        Date tpr = new Date(tempArr[22]);
                        NhsCode nhsCode = new NhsCode(tempArr[1]);
                        createTest(tpList,cl,nhsCode, ttStore.getTestTypeByCode("BL000"), calStore.getClinicalAnalysisLaboratoryByLabId(tempArr[2]), tStore.generateInternalCode(i), samples, tpr, lcv,mr,parametersString,parametersIndextest,tempArr);
                    } catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                        System.out.printf("Error in line %d : %s\n", i, e.getMessage());
                    }
                }else{
                    System.out.printf("Error in line %d : That client alredy exists in the system\n", i);
                }
            }
            br.close();
    }

    private void createTest(List<TestParameter> tpList, Client cl, NhsCode nhscode, TestType testType,ClinicalAnalysisLaboratory lab, String internalCode, Date samplesAddDate, Date chemicalAnalysisDate, Date LabCoordDate, Date createdAt,List<String> parametersString,List<Integer> parametersIndextest,String[] tempArr) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Test t = new Test(cl,nhscode,testType,tpList,lab,internalCode,samplesAddDate,chemicalAnalysisDate,LabCoordDate,createdAt);
        for(String parameterID : parametersString){
            for(int place : parametersIndextest) {
                t.addTestResult(parameterID,tempArr[place], "N");
            }
        }
        t.setStateOfTest(Test.StateOfTest.Validated);
        tStore.saveTest(t);
    }

    private List<String> fillParameters(List<String> parameterstest, List<String> invalidParameters,List<String> pmList) {
        int j = 0;
        while (j < parameterstest.size()) {
                if(!(null==pmStore.getParameterByCode(parameterstest.get(j)))) {
                    pmList.add(parameterstest.get(j));
                }else{
                    invalidParameters.add(parameterstest.get(j));
                }
            j++;
        }
        System.out.println(invalidParameters);
        return pmList;
    }
//    private void parameterCategory(List<Integer> parameterCategorytest,String[] tempArr) {
//        int j=0;
//        while (j < parameterCategorytest.size()) {
//            try {
//
//
//                if (!tempArr[parameterCategorytest.get(j)].equalsIgnoreCase("NA")) {
//                    pmcStore.getParameterCategoryList().add(pmcStore.getParameterCategoryByCode(tempArr[parameterCategorytest.get(j)]));
//                }
//
//            } catch (Exception e) {
//                System.out.println("Couldn't add this Parameter Category");
//            }
//            j++;
//        }
//    }

    private List<Parameter> convertStringIntoParameter(List<String> parameter, List<Parameter> pmList){
        Parameter pm;
        int j=0;
        while (j < parameter.size()) {
            pm = pmStore.getParameterByCode(parameter.get(j));
            pmList.add(pm);
            j++;
        }
        return pmList;
    }

    private List<TestParameter> convertParameterIntoTestParameter(List<Parameter> pmList, List<TestParameter> tpList){
        TestParameter tp;
        for(Parameter pm : pmList){
            tp = new TestParameter(pm);
            tpList.add(tp);
        }
        return tpList;
    }

//    private List<TestParameter> testParameterList(){
//    }

    }
