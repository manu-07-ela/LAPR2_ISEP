package app.domain.model;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTypeTest {

    ParameterCategory pc;
    List<ParameterCategory> listPC;

    @Before
    public void setup(){
        pc = new ParameterCategory("12A4D","Covid-19");
        listPC = new ArrayList();
        listPC.add(pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        TestType tt = new TestType(null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1_1(){
        TestType tt = new TestType("1g3d7h","description","method",listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1_2(){
        TestType tt = new TestType("1g3","description","method",listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1_3(){
        TestType tt = new TestType("","description","method",listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionMeetsAC2(){
        TestType tt = new TestType("1g3d7","descriptionteste","method",listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodMeetsAC3(){
        TestType tt = new TestType("1g354","description","collectingmethodteste",listPC);
    }



  
}