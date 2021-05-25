package app.domain.store;

import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

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
        testList=new ArrayList();
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
  //  private Test getTestByBarcode(){


    //}

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

    //public Test createTest(Client cl, String nhscode){
       // return new Test(cl,nhscode);
   //}

   // public Test createTest(String citizencardnumber, String nhscode){
   //     return new Test(citizencardnumber,nhscode);
   // }
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
            return this.addTest(t);
        }
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
     *
     * @return
     */
    public List<Test> getTestHasSamplesAnalyzedList(){
        List<Test> testHasSamplesAnalyzedList = new ArrayList();
        for(Test test : testList){
            if(test.getState().equals("SamplesAnalyzed")){
                testHasSamplesAnalyzedList.add(test);
            }
        }
        return testHasSamplesAnalyzedList;
    }

    /**
     *
     * @return
     */
    public List<Test> getTestHasReportList(){
        List<Test> testHasReportList = new ArrayList();
        for(Test test : testList){
            if(test.getState().equals("Validated")){
                testHasReportList.add(test);
            }
        }
        return testHasReportList;
    }

    /**
     *
     * @param code
     * @return
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
