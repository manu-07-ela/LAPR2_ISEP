package app.domain.store;

import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    /**
     *
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

    public boolean validateTest(Test test) {
        if (test == null)
            return false;
        return !this.testList.contains(test);
    }

   // public Test createTest(String citizencardnumber, String nhscode){
   //     return new Test(citizencardnumber,nhscode);
   // }
//    public static String generateTestCode(Test t){
//
//    }

    public boolean saveTest(Test t) {
        if (!validateTest(t)){
            return false;
        }else{
            return this.addTest(t);
        }
    }

    public boolean addTest(Test t) {
        return testList.add(t);
    }
    
}
