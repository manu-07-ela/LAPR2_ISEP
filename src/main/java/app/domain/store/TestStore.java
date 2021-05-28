package app.domain.store;

import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import org.apache.commons.lang3.StringUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static app.domain.model.Test.StateOfTest.*;

/**
 * Stores laboratory tests provided to customers
 * @author Group 22
 */

public class TestStore {

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
     *
     * @return
     */
    public List<Test> getTestList() {
        return testList;
    }

    /**
     *  Gets a test by the barcode
     * @param barcodenumber the barcode
     * @return the test
     */
    public Test getTestByBarcode(String barcodenumber){
        barcodeValidation(barcodenumber);
        for (Test test: testList ) {
            for (Sample sample: test.getSamples() ) {
                if (sample.getBarcode().getBarcodeNumber().equals(barcodenumber)){
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

    public Test createTest(Client cl, NhsCode nhscode, TestType testType, List<TestParameter> testParameterList){
        return new Test(cl,nhscode,testType,testParameterList);
   }

//    public static String generateTestCode(Test t){
//
//    }

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

    public static String generateInternalcode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int randomIndex = random.nextInt(chars.length());
            code.append(chars.charAt(randomIndex));
        }

        return code.toString();
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
    public List<Test> getListOfTestWaitingForSample(){
        List<Test> testsWaintingForSamples = new ArrayList<>();
        for (Test test : testList){
            if (test.getState() == TestRegistered) testsWaintingForSamples.add(test);
        }
        return testsWaintingForSamples;
    }

    /**
     *
     * @return
     */
    public List<Test> getTestHasSamplesAnalyzedList(){
        List<Test> testHasSamplesAnalyzedList = new ArrayList();
        for(Test test : testList){
            if(test.getState() == SamplesAnalyzed){
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
            if(test.getState() == SamplesCollected){
                testWithSamplesCollectedList.add(test);
            }
        }
        return testWithSamplesCollectedList;
    }

    /**
     *
     * @return
     */
    public List<Test> getTestHasReportList(){
        List<Test> testHasReportList = new ArrayList();
        for(Test test : testList){
            if(test.getState() == Validated){
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
     * Generates the date and time when the samples were associated with a test
     * @param test the test that will be associated with the date and time of sample collection
     */
    public void generateDataAndTimeForSamplesCollected(Test test){
        test.generateDataAndTimeForSamplesCollected();
    }

    /**
     * After the samples are added to the test, it needs to change its status to SamplesCollected
     * @param test the test that needs to change state
     */
    public void changeTheStatusOfTest(Test test){
        test.changeStateForSamplesCollected();
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

}
