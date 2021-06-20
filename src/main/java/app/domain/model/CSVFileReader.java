package app.domain.model;

import app.controller.App;
import app.controller.RecordSampleController;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import app.domain.store.*;
import auth.AuthFacade;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */
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
     * Represents an instance of Clinical Analysis Laboratory
     */
    private ClinicalAnalysisLaboratory lab;
    /**
     * Represents an instance of the client store
     */
    private final ClientStore clStore;
    /**
     * Represents an instance of the test store
     */
    private final TestStore tStore;
    /**
     * Represents an instance Auth facade
     */
    private final AuthFacade clAuthFacade;
    /**
     * Represents an instance of the Parameter store
     */
    private final ParameterStore pmStore;
    /**
     * Represents an instance of the Test Type store
     */
    private final TestTypeStore ttStore;
    /**
     * Represents an instance of the Clinical Analysis Laboratory store
     */
    private final ClinicalAnalysisLaboratoryStore calStore;
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
     * Represents an instance of Record Samples Controller
     */
    private final RecordSampleController samplesctrl;

    /**
     * Constructs an instance of {@code CSVFileReader}
     */
    public CSVFileReader(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructs an instance of {@code CSVFileReader} receiving a company
     * @param company The company
     */
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
        this.lab = null;
        this.samples=null;
        this.tpr=null;
        this.mr=null;
        this.lcv=null;
    }


    /**
     * Reads a file receiving a file as a parameter
     * @param file
     * @throws IOException
     */
    public void read(File file) throws IOException {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String delimiter = ";";
            int i=1;
            int date=0;
            String[] tempArr;
        line = br.readLine();
        tempArr = line.split(delimiter);
        List<String> allParametersStringList=new ArrayList<>();
        List<String> validParametersStringList=new ArrayList<>();
        List<Integer> parametersNumbList=new ArrayList<>();
        List<Integer> parameterNumbTestValid= new ArrayList<>();
        date=fillParametersString(tempArr,parametersNumbList,allParametersStringList);
        fillValidParametersString(allParametersStringList,validParametersStringList,parametersNumbList,parameterNumbTestValid);

            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                i++;
                cl= clStore.getClientbytin(tempArr[5]);
                    try {
                        if(cl==null) {
                        cl = new Client(tempArr[8], tempArr[3], tempArr[4], tempArr[6], tempArr[5], tempArr[7], tempArr[9],tempArr[10]);
                        }else{
                            System.out.printf("Error in line %d : That client alredy exists in the system\n", i);
                        }
                        clientList.add(cl);
                        clStore.saveClient(cl, clAuthFacade);
                        NhsCode nhsCode = new NhsCode(tempArr[1]);
                        lab = calStore.getClinicalAnalysisLaboratoryByLabId(tempArr[2]);
                        if(lab!=null) {
                            createTest(cl, nhsCode, ttStore.getTestTypeByDescription(tempArr[11]), lab, validParametersStringList, parametersNumbList, tempArr, date);
                        }else{
                            System.out.printf("Error in line %d : This laboratory doesn´t exist\n", i);
                        }
                        } catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException | ParseException | BarcodeException e) {
                        System.err.printf("Error in line %d : %s%n", i, e.getMessage());
                    }
            }
            br.close();
    }

    /**
     * Creates a Test
     * @param cl a Client
     * @param nhscode The Client's National Healthcare Service code
     * @param testType the test type
     * @param lab the Clinical Analysis Laboratory
     * @param parametersString A list of parameterID
     * @param parametersIndextest a list of where the parameters are located
     * @param tempArr a String Array
     * @param date where the dates are located
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws ParseException
     * @throws IOException
     * @throws BarcodeException
     */
    private void createTest(Client cl, NhsCode nhscode, TestType testType,ClinicalAnalysisLaboratory lab, List<String> parametersString,List<Integer> parametersIndextest,String[] tempArr,int date) throws IllegalAccessException, ClassNotFoundException, InstantiationException, ParseException, IOException, BarcodeException {
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
        if(t!=null) {
            createBarcode(t);
            t.setSamplesAddDate(samples);
            for (int i = 0; i < test.size(); i++) {
                t.addTestResultWithDate(test.get(i), tempArr[testnumb.get(i)], testType.getExternalModule().getRefValue(parametersString.get(i)).getMetric(),tpr);
            }
            t.setStateOfTest(Test.StateOfTest.validated);
            tStore.saveTest(t);
        }
    }

    /**
     * Fills a List with parameterID's
     * @param tempArr a String Array
     * @param parametersNumb a List of where the parameters are located
     * @param allParametersString a list with all parameters ID's
     * @return
     */
    private int fillParametersString(String[] tempArr, List<Integer> parametersNumb, List<String> allParametersString){
        for (int n=1; n<tempArr.length;n++){

            if (tempArr[n-1].equalsIgnoreCase("Category")){
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

    /**
     * Fills a List with valid parameterID's
     * @param parameterstest a List of valid parameters
     * @param pmList a List of parameters
     * @param parameterNumbTest a List of where the parameters are located
     * @param parameterNumbTestValid a List of where the valid parameters are located
     */
    private void fillValidParametersString(List<String> parameterstest, List<String> pmList,List<Integer> parameterNumbTest,List<Integer> parameterNumbTestValid) {
        int j = 0;
        while (j < parameterstest.size()) {
            if (!(null == pmStore.getParameterByCode(parameterstest.get(j)))) {
                if(!parameterstest.get(j).equalsIgnoreCase("NA")){

                    pmList.add(parameterstest.get(j));
                    parameterNumbTestValid.add(parameterNumbTest.get(j));
                }
            }
            j++;
        }

    }

    /**
     * Converts a list of parameterID's into a list of parameters
     * @param parameter a parameter ID's list
     * @param pmList a parameters list
     */
    private void convertStringIntoParameter(List<String> parameter, List<Parameter> pmList){
        Parameter pm;
        int j=0;
        while (j < parameter.size()) {
            pm = pmStore.getParameterByCode(parameter.get(j));
            pmList.add(pm);
            j++;
        }
    }

    /**
     * Converts a list of parameters into a list of Test parameters
     * @param pmList a parameters list
     * @param tpList a Test parameters list
     */
    private void convertParameterIntoTestParameter(List<Parameter> pmList, List<TestParameter> tpList){
        TestParameter tp;
        for(Parameter pm : pmList){
            tp = new TestParameter(pm);
            tpList.add(tp);
        }
    }

    /**
     * Generates all the data
     * @param tempArr a String Array
     * @param n Where the data is located
     * @throws ParseException
     */
    private void generateDate(String[] tempArr,int n) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        samples=formatter.parse(tempArr[n]);
        tpr=formatter.parse(tempArr[n+1]);
        mr=formatter.parse(tempArr[n+2]);
        lcv=formatter.parse(tempArr[n+3]);
    }

    /**
     * Gets a Clients List
     * @return a Clients List
     */
    public List<Client> getClientsList(){
        return clientList;
    }

    /**
     * Generates a Barcode and associates a Barcode to a test
     * @param t a test
     * @throws IOException
     * @throws InstantiationException
     * @throws BarcodeException
     * @throws IllegalAccessException
     */
    public void createBarcode(Test t) throws IOException, InstantiationException, BarcodeException, IllegalAccessException {
        Sample sample;
        try {
            BarcodeDomain barcodeDomain = samplesctrl.generateBarcode();
            sample = samplesctrl.associateBarcodeWithSample(barcodeDomain);
            samplesctrl.associateSamplesWithTest(t, sample);
            samplesctrl.imageIoWrite(samplesctrl.barcodeImage(barcodeDomain), "Barcode_" + barcodeDomain.getBarcodeNumber());
            samplesctrl.saveSample(sample);
        } catch (ClassNotFoundException | OutputException e) {
            e.printStackTrace();
        }

    }
}