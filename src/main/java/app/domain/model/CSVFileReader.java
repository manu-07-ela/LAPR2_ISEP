package app.domain.model;

import app.controller.App;
import app.controller.RecordSampleController;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.TestParameter;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
import app.domain.store.*;
import app.interfaces.ExternalModuleBarcode;
import auth.AuthFacade;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVFileReader {


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
    /**
     * Represents an instance of Client List
     */
    private List<Client> clientList;
    /**
     * Represents an instance of SamplesList
     */
    private RecordSampleController samplesctrl;

    public CSVFileReader(){
        this(App.getInstance().getCompany());
    }

    public CSVFileReader(Company company){
        clientList = new ArrayList<>();
        this.company = App.getInstance().getCompany();
        this.clStore = company.getClientStore();
        clAuthFacade = company.getAuthFacade();
        this.samplesctrl = new RecordSampleController();
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



    public void read(File file) throws IOException {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String delimiter = ";";
            int i=0;
            int date=0;
            String[] tempArr;
        line = br.readLine();
        tempArr = line.split(delimiter);
        List<String> allParametersStringList=new ArrayList<>();
        List<String> validParametersStringList=new ArrayList<>();
        List<Integer> parametersNumbList=new ArrayList<>();
//        List<Integer> parameterCategory=new ArrayList<>();
        date=fillParametersString(tempArr,parametersNumbList,allParametersStringList);
        parametersNumbList=fillValidParametersString(allParametersStringList,validParametersStringList,parametersNumbList);
//        parameterCategory(parameterCategorytest,tempArr);

            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                i++;
                cl= clStore.getClientbytin(tempArr[5]);
                if(cl==null) {
                    try {
                        cl = new Client(tempArr[8], tempArr[3], tempArr[4], tempArr[6], tempArr[5], tempArr[7], tempArr[9],tempArr[10]);
                        clientList.add(cl);
                        clStore.saveClient(cl, clAuthFacade);
                        NhsCode nhsCode = new NhsCode(tempArr[1]);
                        createTest(cl,nhsCode, ttStore.getTestTypeByDescription(tempArr[11]), calStore.getClinicalAnalysisLaboratoryByLabId(tempArr[2]),validParametersStringList,parametersNumbList,tempArr,date);
                    } catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException | ParseException e) {
                        System.out.printf("Error in line %d : %s\n", i, e.getMessage());
                    }
                }else{
                    System.out.printf("Error in line %d : That client alredy exists in the system\n", i);
                }
            }
            br.close();
    }

    private void createTest(Client cl, NhsCode nhscode, TestType testType,ClinicalAnalysisLaboratory lab, List<String> parametersString,List<Integer> parametersIndextest,String[] tempArr,int date) throws IllegalAccessException, ClassNotFoundException, InstantiationException, ParseException {
        generateDate(tempArr,date);
        List<String> test = new ArrayList<>();
        List<Integer> testnumb = new ArrayList<>();
        List<Parameter> pmList = new ArrayList<>();
        List<TestParameter> tpList = new ArrayList<>();
        for(int i=0;i<parametersString.size();i++) {
            if (!tempArr[parametersIndextest.get(i)].equalsIgnoreCase("NA")) {
                test.add(parametersString.get(i));
                testnumb.add(parametersIndextest.get(i));
            }
        }
        convertStringIntoParameter(test,pmList);
        convertParameterIntoTestParameter(pmList,tpList);
        Test t = tStore.createTestByCsvFile(cl, nhscode, testType, tpList, lab, samples, tpr, lcv, mr);
        for(int i=0;i<test.size();i++) {
            t.addTestResult(test.get(i), tempArr[testnumb.get(i)], testType.getExternalModule().getRefValue(parametersString.get(i)).getMetric());
        }
        t.setStateOfTest(Test.StateOfTest.Validated);
        tStore.saveTest(t);
    }

    private int fillParametersString(String[] tempArr, List<Integer> parametersNumb, List<String> allParametersString){
        for (int n=1; n<tempArr.length;n++){

            if (tempArr[n-1].equalsIgnoreCase("Category")){
//                parameterCategory.add(n-1);
                while (!tempArr[n].equalsIgnoreCase("Category") && !tempArr[n].equalsIgnoreCase("Test_Reg_DateHour")){
                    allParametersString.add(tempArr[n]);
                    parametersNumb.add(n);
                    n++;
                }
            }
            if(tempArr[n].equalsIgnoreCase("Test_Reg_DateHour")){
                return n;
            }
        }
        return 0;
    }

    private List<Integer> fillValidParametersString(List<String> parameterstest, List<String> pmList,List<Integer> parameterNumbTest) {
        int j = 0;
        List<Integer> parameterNumbTestValid= new ArrayList<>();
        while (j < parameterstest.size()) {
            if (!(null == pmStore.getParameterByCode(parameterstest.get(j)))) {
                if(!parameterstest.get(j).equalsIgnoreCase("NA")){

                    pmList.add(parameterstest.get(j));
                    parameterNumbTestValid.add(parameterNumbTest.get(j));
                }
            }
            j++;
        }
        return parameterNumbTestValid;

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

    private void convertStringIntoParameter(List<String> parameter, List<Parameter> pmList){
        Parameter pm;
        int j=0;
        while (j < parameter.size()) {
            pm = pmStore.getParameterByCode(parameter.get(j));
            pmList.add(pm);
            j++;
        }
    }

    private void convertParameterIntoTestParameter(List<Parameter> pmList, List<TestParameter> tpList){
        TestParameter tp;
        for(Parameter pm : pmList){
            tp = new TestParameter(pm);
            tpList.add(tp);
        }
    }

    private void generateDate(String[] tempArr,int n) throws ParseException {
        System.out.println(tempArr[n]);
        System.out.println(tempArr[n+1]);
        System.out.println(tempArr[n+2]);
        System.out.println(tempArr[n+3]);
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        samples=formatter.parse(tempArr[n]);
        tpr=formatter.parse(tempArr[n+1]);
        mr=formatter.parse(tempArr[n+2]);
        lcv=formatter.parse(tempArr[n+3]);
    }

    public List<Client> getClientsList(){
        return clientList;
    }

    public void generateBarcode(){

    }

    }

