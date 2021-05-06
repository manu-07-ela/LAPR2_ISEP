package app.domain.model;


import org.junit.Before;
import org.junit.Test;

public class TestTypeTest {

    @Before
    public void setup(){
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNullsNotAllowed(){
        TestType tt = new TestType(null,null,null,null);
    }

  
}