package app.domain.store;

import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.mappers.dto.ClientDTO;
import org.apache.commons.lang3.StringUtils;
import app.domain.model.testrelated.Sample;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.TestParameter;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

import static app.domain.model.testrelated.Test.StateOfTest.*;

/**
 * Stores laboratory tests provided to customers
 * @author Group 22
 */

public class TestStore implements Serializable {

    /**
     * Represents a list of tests
     */
    private List<Test> testList;

    /**
     * Instantiates a new TestStore.
     */
    public TestStore(){
        testList = new ArrayList();
    }

    /**
     * Get the list of tests
     * @return the list of tests
     */
    public List<Test> getTestList() {
        return testList;
    }

    /**
     *  Gets a test by the barcode
     * @param barcodeNumber the barcode
     * @return the test
     */
    public Test getTestByBarcode(String barcodeNumber){
        barcodeValidation(barcodeNumber);
        for (Test test: testList ) {
            for (Sample sample : test.getSamples() ) {
                if (sample.getBarcode().getBarcodeNumber().equals(barcodeNumber)){
                    return test;
                }
            }
        }
        return null;
    }

    /**
     * Global validation of a Test
     * @param test Test that we intend to validate
     * @return false if the employee already exists or is null. Otherwise, it returns true.
     */
    public boolean validateTest(Test test) {
        if (test == null)
            return false;
        return !this.testList.contains(test);
    }

    /**
     * Create a test
     * @param cl the client associated with the test
     * @param nhsCode the nhs code of the test
     * @param testType the test type associated with the test
     * @param testParameterList the list of parameters associated with the test
     * @return the test created
     */
    public Test createTest(Client cl, NhsCode nhsCode, TestType testType, List<TestParameter> testParameterList,ClinicalAnalysisLaboratory lab){
        return new Test(cl,nhsCode,testType,testParameterList,lab,generateInternalCode(testList.size()));
   }

    /**
     * Create a test through a csv file
     * @param cl the client associated with the test
     * @param nhsCode the nhs code of the test
     * @param testType the test type associated with the test
     * @param testParameterList the list of parameters associated with the test
     * @param lab the ClinicalAnalysisLaboratory associated with the test
     * @param samplesAddDate the samples registered date associated with the test
     * @param chemicalAnalysisDate the chemical analysis date associated with the test
     * @param LabCoordDate the Lab Coordinator date associated with the test
     * @param createdAt the medical report date associated with the test
     * @return the test created
     */
    public Test createTestByCsvFile(Client cl, NhsCode nhsCode, TestType testType, List<TestParameter> testParameterList,ClinicalAnalysisLaboratory lab,Date samplesAddDate,Date chemicalAnalysisDate,Date LabCoordDate,Date createdAt){
        Test test = new Test(cl, nhsCode, testType, testParameterList, lab, generateInternalCode(testList.size()), samplesAddDate, chemicalAnalysisDate, LabCoordDate, createdAt);
        for(Test t : testList) {
            if(t.equals(test)) {
                return null;
            }
        }
        return test;
    }

    /**
     * Save the Test case it is in a valid state.
     * @param t The Test we intend to save
     * @return true if Test was saved. Otherwise, false.
     */
    public boolean saveTest(Test t) {
        if (!validateTest(t)){
            return false;
        }else{
            return testList.add(t);
        }
    }

    /**
     * Generate the internal code that will be associated with a test
     * @param numTest the number of test already registered
     * @return th internal code of a test
     */
    public static String generateInternalCode(int numTest) {
        DecimalFormat df = new DecimalFormat("000000000000");
        return df.format(numTest+1);
    }

    /**
     * Adds a new Test to the list
     * @param t the test to which you want to add
     * @return true if the test is added to the list, false otherwise
     */
    public boolean addTest(Test t) {
        return testList.add(t);
    }

    /**
     * Get a list of test waiting for the collection of samples
     * @return a list of test waiting for samples
     */
    public List<Test> getListOfTestWaitingForSample(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory){
        List<Test> testsWaitingForSamples = getTestByLaboratory(clinicalAnalysisLaboratory);
        List<Test> test = new ArrayList<>();
        for (Test t : testsWaitingForSamples){
            if (t.getStateOfTest() == testRegistered) test.add(t);
        }
        return test;
    }

    /**
     * Get a list of test with the samples analyzed
     * @return the list of tests with the samples analyzed
     */
    public List<Test> getTestHasSamplesAnalyzedList(){
        List<Test> testHasSamplesAnalyzedList = new ArrayList();
        for(Test test : testList){
            if(test.getStateOfTest() == samplesAnalyzed){
                testHasSamplesAnalyzedList.add(test);
            }
        }
        return testHasSamplesAnalyzedList;
    }

    /**
     * Get a list of test waiting for the analysis of samples
     * @return  a list of test waiting for the analysis of samples
     */
    public List<Test> getTestWithSamplesCollectedList(){
        List<Test> testWithSamplesCollectedList = new ArrayList();
        for(Test test : testList){
            if(test.getStateOfTest() == samplesCollected){
                testWithSamplesCollectedList.add(test);
            }
        }
        return testWithSamplesCollectedList;
    }

    /**
     * Get a list of test waiting for the Validation of the Lab Coordinator
     * @return a list of test waiting the Validation of the Lab Coordinator
     * Get a list of tests with the diagnosis made
     * @return a list of tests with the diagnosis made
     */
    public List<Test> getTestHasReportList(){
        List<Test> testHasReportList = new ArrayList();
        for(Test test : testList){
            if(test.getStateOfTest() == diagnosisMade){
                testHasReportList.add(test);
            }
        }
        return testHasReportList;
    }


    /**
     * identifies and returns the test instance corresponding to the internal code passed by parameter
     * @param code the internal code of a test
     * @return the test corresponding to the internal code
     */
    public Test getTestByInternalCode(String code){
        for (Test test : testList) {
            if (test.getInternalCode().equals(code)) {
              return test;
            }
        }
       return null;
    }


    /**
     * Checks if the barcode contains all business rules
     * @param barcode  the barcode
     */
    public void barcodeValidation(String barcode){
        if (StringUtils.isBlank(barcode) || barcode.length() != 11){
            throw new IllegalArgumentException("The barcode number must be a code with 11 characters");
        }
    }

    /**
     * Get the list of tests associated with a laboratory
     * @param clinicalAnalysisLaboratory the laboratory that te test will be associated
     * @return the list of test associated with a laboratory
     */
    public List<Test> getTestByLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory){
        List<Test> test = new ArrayList<>();
        for (Test t : testList){
            if (t.getLab().equals(clinicalAnalysisLaboratory)){
                test.add(t);
            }
        }
       return test;
    }

    /**
     * Gets the list of Clients that have at least one Test Validated
     * @return the list of Clients that have at least one Test Validated
     */
    public List<Client> getClientWithTestsValidated(){
        List<Client> list = new ArrayList<>();
        for (Test t: testList) {
            if (t.getStateOfTest()== validated && !list.contains(t.getCl())){
                list.add(t.getCl());
            }
        }
        if (list.size()==0){
            throw new IllegalArgumentException("There aren't Clients with tests validated");
        }

        return list;
    }

    /**
     * Gets the list of all test associated with a specific client
     * @param selectedClient The specific client we want to gets it's tests
     * @return the list of all test associated with a specific client
     */
    public List<Test> getTestListAssociatedWithClient(ClientDTO selectedClient){
        List<Test> test = new ArrayList<>();
        for (Test t : testList) {
            if (t.getCl().getTin().equals(selectedClient.getTin()) && t.getStateOfTest()== validated) {
                test.add(t);
            }
        }
        return test;
    }

    /**
     * Orders the clients tests by registration date
     * @param tList List of tests
     * @return List of tests
     */
    public List<Test> orderClientTestsByRegistrationDate(List<Test> tList){
        List<Date> date = new ArrayList<>();
        List<Test> test = new ArrayList<>();
        for(Test t : tList){
            date.add(t.getSamplesAddDate());
        }
        Collections.reverse(date);
        for(Date d : date){
            Test t = getTestByDate(d);
            test.add(t);
        }
        return test;
    }

    private Test getTestByDate(Date d){
            for (Test t: testList) {
                if (t.getSamplesAddDate().equals(d)) {
                    return t;
                }
            }
            return null;
    }

    /**
     * Gets the interval test list
     * @param initialDate the initial date
     * @param endDate the end date
     * @return the interval test list
     */
    public List<Test> getIntervalTestList(Date initialDate, Date endDate){
        List<Test> intervalTestList = new ArrayList();
        for (Test t: testList) {
            if(t.getSamplesAddDate()!=null) {
                if ((t.getSamplesAddDate().after(initialDate) && t.getSamplesAddDate().before(endDate)) || (t.getCreatedAt().after(initialDate) && t.getCreatedAt().before(endDate)) || (t.getLabValidationDate().after(initialDate) && t.getLabValidationDate().before(endDate)) || (t.getChemicalAnalysisDate().get(t.getChemicalAnalysisDate().size() - 1).after(initialDate) && t.getChemicalAnalysisDate().get(t.getChemicalAnalysisDate().size() - 1).before(endDate))) {
                    intervalTestList.add(t);
                }
            }
        }
        return intervalTestList;
    }

    /**
     * Get covid tests by date interval
     * @param initialDate the initial date
     * @param endDate the end date
     * @return covid tests by date interval
     */
    public List<Test> getCovidTestsLstByInterval(Date initialDate, Date endDate){
        List<Test> intervalTestList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);
        int initialDay = calendar.get(Calendar.DAY_OF_YEAR);
        int initialYear = calendar.get(Calendar.YEAR);
        calendar.setTime(endDate);
        int endDay = calendar.get(Calendar.DAY_OF_YEAR);
        int endYear = calendar.get(Calendar.YEAR);
        for (Test t: testList) {
            if(t.getStateOfTest() == validated) {
                calendar.setTime(t.getSamplesAddDate());
                int validationDay = calendar.get(Calendar.DAY_OF_YEAR);
                int validationYear = calendar.get(Calendar.YEAR);
                if ((((t.getSamplesAddDate().after(initialDate) && t.getSamplesAddDate().before(endDate)) || (initialDay == validationDay && initialYear == validationYear) || (endDay == validationDay && endYear == validationYear)) )&& t.getTestType().getReferenceAdapter().equals("CovidReferenceValues1API")) {
                    intervalTestList.add(t);
                }
            }
        }
        return intervalTestList;
    }


    /**
     * Gets the number of Positive Covid tests for a day
     * @param initialDate the initial date
     * @param endDate the end date
     * @return the number of Positive Covid tests for a day
     */
    public double[] getNumberOfPositiveCovidTestsForDayInInterval(Date initialDate, Date endDate){
        List<Double> auxiliar = new ArrayList<>();

        List<Test> tests = getCovidTestsLstByInterval(initialDate,endDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);

        Date aux = new Date(initialDate.getTime());

        Date date = new Date(endDate.getTime());

        date.setHours(aux.getHours()+24);

        do{
            double temp = 0;
            if(aux.getDay()!=0){
                calendar.setTime(aux);
                int day = calendar.get(Calendar.DAY_OF_YEAR);
                int year = calendar.get(Calendar.YEAR);
                for (int i = 0; i<tests.size();i++){
                    calendar.setTime(tests.get(i).getSamplesAddDate());
                    int sampleDay = calendar.get(Calendar.DAY_OF_YEAR);
                    int sampleYear = calendar.get(Calendar.YEAR);
                    if(day == sampleDay && year == sampleYear) {
                        if (tests.get(i).getTestParameterList().get(0).getParameterId().equals("IgGAN")) {
                            if (Double.parseDouble(tests.get(i).getTestParameterList().get(0).getParamResult().getResult().replace(",", ".")) > 1.4) {
                                temp++;
                            }
                        }
                    }
                }
                auxiliar.add(temp);
            }
            aux.setHours(aux.getHours()+24);
        }while (aux.before(date));

        double[] positives = new double[auxiliar.size()];
        for(int j = 0; j<auxiliar.size(); j++){
            positives[j]=auxiliar.get(j);
        }
        return positives;

    }

    /**
     * Gets the number of Positive Covid Tests For Day Historical Points
     * @param currentDay the date of the current day
     * @param historicalPoints the number of historical points
     * @return the number of Positive Covid Tests For Day Historical Points
     */
    public double[] getNumberOfPositiveCovidTestsForDayHistoricalPoints(Date currentDay, int historicalPoints){


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);

        int validDays=0;
        Date dateAux = new Date(currentDay.getTime());

        Date endDate = null;
        do {
            dateAux.setHours(dateAux.getHours() - 24);
            if(dateAux.getDay()!=0) {
                validDays++;
                if (validDays == 1){
                    endDate = new Date(dateAux.getTime());
                }
            }
        }while (validDays<historicalPoints);

        Date initialDate = new Date(dateAux.getTime());

        return getNumberOfPositiveCovidTestsForDayInInterval(initialDate,endDate);

    }

    /**
     * Gets the number of Tests Performed for a day in a interval
     * @param initialDate the initial date
     * @param endDate the end date
     * @return the number of Tests Performed for a day in a interval
     */
    public double[] getNumberOfTestsPerformedForDayInInterval(Date initialDate, Date endDate){

        List<Double> auxiliar = new ArrayList<>();

        List<Test> test = getCovidTestsLstByInterval(initialDate,endDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);

        Date aux = new Date(initialDate.getTime());

        Date date = new Date(endDate.getTime());

        date.setHours(aux.getHours()+24);

        do{
            double temp = 0;
            if(aux.getDay()!=0){
                calendar.setTime(aux);
                int day = calendar.get(Calendar.DAY_OF_YEAR);
                int year = calendar.get(Calendar.YEAR);
                for (int i = 0; i<test.size();i++){
                    calendar.setTime(test.get(i).getSamplesAddDate());
                    int sampleDay = calendar.get(Calendar.DAY_OF_YEAR);
                    int sampleYear = calendar.get(Calendar.YEAR);
                    if(day == sampleDay && year == sampleYear) {
                        temp++;
                    }
                }
                auxiliar.add(temp);
            }
            aux.setHours(aux.getHours()+24);
        }while (aux.before(date));

        double[] performed = new double[auxiliar.size()];
        for(int j = 0; j<auxiliar.size(); j++){
            performed[j]=auxiliar.get(j);
        }

        return performed;


    }

    /**
     * Gets the number of Tests Performed for a day by historical points
     * @param currentDay the date of the current day
     * @param historicalPoints the number of historical points
     * @return the number of Tests Performed for a day by historical points
     */
    public double[] getNumberOfTestsPerformedForDayHistoricalPoints(Date currentDay, int historicalPoints){


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);

        int validDays=0;
        Date dateAux = new Date(currentDay.getTime());

        Date endDate = null;
        do {
            dateAux.setHours(dateAux.getHours() - 24);
            if(dateAux.getDay()!=0) {
                validDays++;
                if (validDays == 1){
                    endDate = new Date(dateAux.getTime());
                }
            }
        }while (validDays<historicalPoints);

        Date initialDate = new Date(dateAux.getTime());

        return getNumberOfTestsPerformedForDayInInterval(initialDate,endDate);

    }


    /**
     * Gets Mean Age For a Day in a interval
     * @param initialDate the initial date
     * @param endDate the end date
     * @return Mean Age For a Day in a interval
     * @throws ParseException
     */
    public double[] getMeanAgeForDayInInterval(Date initialDate, Date endDate) throws ParseException {

        List<Double> auxiliar = new ArrayList<>();


        List<Test> test = getCovidTestsLstByInterval(initialDate,endDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);

        Date aux = new Date(initialDate.getTime());

        Date date = new Date(endDate.getTime());

        date.setHours(aux.getHours()+24);

        do{
            int numberOfClients=0;
            double age = 0;
            if(aux.getDay()!=0){
                calendar.setTime(aux);
                int day = calendar.get(Calendar.DAY_OF_YEAR);
                int year = calendar.get(Calendar.YEAR);
                for (int i = 0; i<test.size();i++){
                    calendar.setTime(test.get(i).getSamplesAddDate());
                    int sampleDay = calendar.get(Calendar.DAY_OF_YEAR);
                    int sampleYear = calendar.get(Calendar.YEAR);
                    if(day == sampleDay && year == sampleYear) {
                        age += test.get(i).getCl().getAge();
                        numberOfClients++;
                    }
                }
                if (numberOfClients!=0) {
                    auxiliar.add(age / numberOfClients);
                }else {
                    auxiliar.add((double) numberOfClients);
                }
            }
            aux.setHours(aux.getHours()+24);
        }while (aux.before(date));

        double[] meanAge = new double[auxiliar.size()];
        for(int j = 0; j<auxiliar.size(); j++){
            meanAge[j]=auxiliar.get(j);
        }

        return meanAge;


    }

    /**
     * Gets Mean Age For a Day by historical Points
     * @param currentDay the date of the current day
     * @param historicalPoints the number of historical points
     * @return Mean Age For a Day by historical Points
     * @throws ParseException
     */
    public double[] getMeanAgeForDayHistoricalPoints(Date currentDay, int historicalPoints) throws ParseException {


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);

        int validDays=0;
        Date dateAux = new Date(currentDay.getTime());

        Date endDate = null;
        do {
            dateAux.setHours(dateAux.getHours() - 24);
            if(dateAux.getDay()!=0) {
                validDays++;
                if (validDays == 1){
                    endDate = new Date(dateAux.getTime());
                }
            }
        }while (validDays<historicalPoints);

        Date initialDate = new Date(dateAux.getTime());

        return getMeanAgeForDayInInterval(initialDate,endDate);

    }

    /**
     * Gets the number of Tests Performed for a week by historical points
     * @param currentDay the date of the current day
     * @param historicalPoints the number of historical points
     * @return the number of Tests Performed for a week by historical points
     */
    public double[] getNumberOfTestsPerformedForWeekHistoricalPoints(Date currentDay, int historicalPoints){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);
        double[] numberOfTests = new double[historicalPoints];
        double[] aux;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Date date = new Date(currentDay.getTime());
        date.setHours(date.getHours() - (day*24-48));
        date.setHours(date.getHours() - 7 * 24 * historicalPoints);
        for (int i = 0; i < historicalPoints; i++) {
            calendar.setTime(date);
            Date dateEnd = new Date(date.getTime());
            dateEnd.setHours(dateEnd.getHours() + 5*24);
            aux = getNumberOfTestsPerformedForDayInInterval(date, dateEnd);
            int temp=0;
            for (int j =0; j<aux.length; j++){
                temp+= aux[j];
            }
            numberOfTests[i] = temp;
            date.setHours(date.getHours() + 7*24);
        }
        return numberOfTests;
    }

    /**
     * Gets the number of Positive Covid Tests Performed for a week by historical points
     * @param currentDay the date of the current day
     * @param historicalPoints the number of historical points
     * @return the number of Positive Covid Tests Performed for a week by historical points
     */
    public double[] getNumberOfPositiveCovidTestsForWeekHistoricalPoints(Date currentDay, int historicalPoints) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);
        double[] numberOfPositives = new double[historicalPoints];
        double[] aux;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Date date = new Date(currentDay.getTime());
        date.setHours(date.getHours() - (day*24-48));
        date.setHours(date.getHours() - 7 * 24 * historicalPoints);
        for (int i = 0; i < historicalPoints; i++) {
            calendar.setTime(date);
            Date dateEnd = new Date(date.getTime());
            dateEnd.setHours(dateEnd.getHours() + 5*24);
            aux = getNumberOfPositiveCovidTestsForDayInInterval(date, dateEnd);
            int temp=0;
            for (int j =0; j<aux.length; j++){
                temp+= aux[j];
            }
            numberOfPositives[i] = temp;
            date.setHours(date.getHours() + 7*24);
        }
        return numberOfPositives;
    }

    /**
     * Gets the Mean Age for a Week by historical Points
     * @param currentDay the date of the current day
     * @param historicalPoints the number of historical points
     * @return the Mean Age for a Week by historical Points
     */
    public double[] getMeanAgeForWeekHistoricalPoints(Date currentDay, int historicalPoints) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);
        double[] meanAge = new double[historicalPoints];
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Date date = new Date(currentDay.getTime());
        date.setHours(date.getHours() - (day*24-48));
        date.setHours(date.getHours() - 7 * 24 * historicalPoints);
        for (int i = 0; i < historicalPoints; i++) {
            calendar.setTime(date);
            Date dateEnd = new Date(date.getTime());
            dateEnd.setHours(dateEnd.getHours() + 5*24);
            double temp = 0;
            double sum = 0;
            for (Test t: getCovidTestsLstByInterval(date,dateEnd)){
                temp++;
                sum += t.getCl().getAge();
            }
            if(temp!=0) {
                 meanAge[i] = sum / temp;
            }else{
                 meanAge[i] = temp;
            }
            date.setHours(date.getHours() + 7*24);
        }
        return meanAge;
    }






}
