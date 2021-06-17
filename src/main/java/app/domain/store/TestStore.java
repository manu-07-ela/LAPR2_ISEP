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
    List<Test> testList;

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
        List<Test> testsWaintingForSamples = getTestByLaboratory(clinicalAnalysisLaboratory);
        List<Test> test = new ArrayList<>();
        for (Test t : testsWaintingForSamples){
            if (t.getStateOfTest() == TestRegistered) test.add(t);
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
            if(test.getStateOfTest() == SamplesAnalyzed){
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
            if(test.getStateOfTest() == SamplesCollected){
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
            if(test.getStateOfTest() == DiagnosisMade){
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

    public List<Client> getClientWithTestsValidated(){
        List<Client> list = new ArrayList<>();
        for (Test t: testList) {
            if (t.getStateOfTest()==Validated && !list.contains(t.getCl())){
                list.add(t.getCl());
            }
        }
        if (list.size()==0){
            throw new IllegalArgumentException("There aren't Clients with tests validated");
        }

        return list;
    }

    public List<Test> getTestListAssociatedWithClient(ClientDTO selectedClient){
        List<Test> test = new ArrayList<>();
        for (Test t : testList) {
            if (t.getCl().getPhoneNumber().equals(selectedClient.getPhoneNumber()) && t.getStateOfTest()==Validated) {
                test.add(t);
            }
        }
        return test;
    }

    public Test getTestbyInternalCode(String internalCode) {
        for (Test t :testList) {
            if (t.getInternalCode().equals(internalCode)){
                return t;
            }
        }
        return null;

    }

    public List<Test> orderClientTestsByRegistratonDate(List<Test> tlist){
        List<Date> date = new ArrayList<>();
        List<Test> test = new ArrayList<>();
        for(Test t : tlist){
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

    public List<Test> getIntervalTestList(Date initialDate, Date endDate){
        List<Test> intervalTestList = new ArrayList();
        for (Test t: testList) {
            if (t.getSamplesAddDate().after(initialDate) && t.getSamplesAddDate().before(endDate) ) {
                intervalTestList.add(t);
            }
        }
        return intervalTestList;
    }

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
            calendar.setTime(t.getLabValidationDate());
            int validationDay = calendar.get(Calendar.DAY_OF_YEAR);
            int validationYear = calendar.get(Calendar.YEAR);
            if ( ( (t.getLabValidationDate().after(initialDate) && t.getLabValidationDate().before(endDate) ) || (initialDay==validationDay && initialYear == validationYear) || (endDay==validationDay && endYear == validationYear) ) && t.getTestType().getReferenceAdapter().equals("CovidReferenceValues1API")) {
                intervalTestList.add(t);
            }
        }
        return intervalTestList;
    }

    public List<Test> getCovidTestsLstHistoricalPoints(Date currentDay, int historicalPoints){
        List<Test> intervalTestList = new ArrayList();
        int validDays=0;
        int aux=1;
        do{
            Date dateAux = new Date(currentDay.getTime());
            dateAux.setHours(dateAux.getHours()-24);

        } while (validDays<historicalPoints);
        return intervalTestList;
    }
}
