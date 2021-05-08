package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParameterTest {

    ParameterCategory pc;
    List<Parameter> listParameter;
    Parameter p;

    @Test
    public void getCode() {
    }

    @Test
    public void getShortName() {
    }

    @Test
    public void getDescription() {
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getDescription();
        Assert.assertEquals("Red Blood Cells",result);
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testToString() {
    }
}