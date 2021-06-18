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
        this.samples=null;
        this.tpr=null;
        this.mr=null;
        this.lcv=null;
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
    /**
     * Represents an instance of Date when samples were registered
     */
    private Date samples;
    /**
     * Represents an instance of Date when the results of a given test are recorded
     */
    private Date tpr;
    /**
     * Represents an instance of Date when the medical report was registered
     */
    private Date mr;
    /**
     * Represents an instance of Date when the test was validated
     */
    private Date lcv;


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
        List<String> allParametersString=new ArrayList<>();
        List<String> validParametersString=new ArrayList<>();
        List<Integer> parametersNumb=new ArrayList<>();
        List<TestParameter> tpList = new ArrayList<>();
        List<String> invalidParameters= new ArrayList<>();
        List<Parameter> pmList = new ArrayList<>();
//        List<Integer> parameterCategory=new ArrayList<>();
        fillParameters(tempArr,parametersNumb,allParametersString);
        validParametersString=fillValidParameters(allParametersString,invalidParameters,validParametersString);
        pmList=convertStringIntoParameter(validParametersString,pmList);
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
                        NhsCode nhsCode = new NhsCode(tempArr[1]);
                        createTest(tpList,cl,nhsCode, ttStore.getTestTypeByCode("BL000"), calStore.getClinicalAnalysisLaboratoryByLabId(tempArr[2]),validParametersString,parametersNumb,tempArr);
                    } catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                        System.out.printf("Error in line %d : %s\n", i, e.getMessage());
                    }
                }else{
                    System.out.printf("Error in line %d : That client alredy exists in the system\n", i);
                }
            }
            br.close();
    }

    private void createTest(List<TestParameter> tpList, Client cl, NhsCode nhscode, TestType testType,ClinicalAnalysisLaboratory lab, List<String> parametersString,List<Integer> parametersIndextest,String[] tempArr) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        samples=generateDate(tempArr,"Test_Reg_DateHour");
        tpr=generateDate(tempArr,"Test_Chemical_DateHour");
        mr=generateDate(tempArr,"Test_Doctor_DateHour");
        lcv=generateDate(tempArr,"Test_Validation_DateHour");
        Test t = tStore.createTestByCsvFile(cl,nhscode,testType,tpList,lab,samples,tpr,lcv,mr);
        for(String parameterID : parametersString){
            for(int place : parametersIndextest) {
                t.addTestResult(parameterID,tempArr[place], "N");
            }
        }
        t.setStateOfTest(Test.StateOfTest.Validated);
        tStore.saveTest(t);
    }

    private void fillParameters(String[] tempArr,List<Integer> parametersNumb,List<String> allParametersString){
        for (int n=1; n<tempArr.length;n++){

            if (tempArr[n-1].equalsIgnoreCase("Category")){
//                parameterCategory.add(n-1);
                while (!tempArr[n].equalsIgnoreCase("Category") && !tempArr[n].equalsIgnoreCase("Test_Reg_DateHour")){
                    allParametersString.add(tempArr[n]);
                    parametersNumb.add(n);
                    n++;
                }
            }
        }
    }

    private List<String> fillValidParameters(List<String> parameterstest, List<String> invalidParameters,List<String> pmList) {
        int j = 0;
        while (j < parameterstest.size()) {
                if(!(null==pmStore.getParameterByCode(parameterstest.get(j)))) {
                    pmList.add(parameterstest.get(j));
                }else{
                    invalidParameters.add(parameterstest.get(j));
                }
            j++;
        }
        System.out.printf("These parameters are invalid in the file : %s"+invalidParameters);
        return pmList;
    }
//    private void parameterCategory(List<Integer> parameterCategory,String[] tempArr) {
//        int j=0;
//        while (j < parameterCategory.size()) {
//            try {
//
//
//                if (!tempArr[parameterCategory.get(j)].equalsIgnoreCase("NA")) {
//                    pmcStore.getParameterCategoryList().add(pmcStore.getParameterCategoryByCode(tempArr[parameterCategory.get(j)]));
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

    private Date generateDate(String[] tempArr,String title){
        Date test=null;
        for (int n=1; n<tempArr.length;n++){

            if (tempArr[n].equalsIgnoreCase(title)){
                test = new Date(tempArr[n]);
            }
        }
        return test;
    }

//    private List<TestParameter> testParameterList(){
//    }

    }
