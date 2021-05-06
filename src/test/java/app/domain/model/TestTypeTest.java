package app.domain.model;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTypeTest {

    @Before
    public void setup(){
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        TestType tt = new TestType(null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLengthCodeNotAllowedByExcess(){
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(new ParameterCategory("12345","hemogram"));
        TestType tt = new TestType("1g3d7h","description","method",listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLengthCodeNotAllowedByDisability(){
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(new ParameterCategory("12345","hemogram"));
        TestType tt = new TestType("1g3","description","method",listPC);
    }



  
}