package app.domain.store;

import app.domain.model.attributes.NhsCode;
import app.domain.model.testRelated.Sample;
import app.domain.model.testRelated.Test;
import app.domain.model.testRelated.TestParameter;
import app.domain.model.testRelated.TestType;
import app.domain.model.users.Client;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static app.domain.model.testRelated.Test.StateOfTest.*;

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
     *
     * @return
     */
    public Test getTestByBarcode(String barcodenumber){
        for (Test test: testList ) {
            for (Sample sample : test.getSamples() ) {
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
        return new Test(cl,nhscode,testType,testParameterList, generateInternalCode(testList.size()));
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

    public static String generateInternalCode(int numtest) {
        DecimalFormat df = new DecimalFormat("000000000000");
        return df.format(numtest);
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
            if (test.getStateOfTest() == TestRegistered) testsWaintingForSamples.add(test);
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
            if(test.getStateOfTest() == SamplesAnalyzed){
                testHasSamplesAnalyzedList.add(test);
            }
        }
        return testHasSamplesAnalyzedList;
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public List<Test> getTestHasReportList(){
        List<Test> testHasReportList = new ArrayList();
        for(Test test : testList){
            if(test.getStateOfTest() == Validated){
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


}
