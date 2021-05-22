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

}
