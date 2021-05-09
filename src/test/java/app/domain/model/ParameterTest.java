package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParameterTest {

    ParameterCategory pc;
    List<Parameter> listParameter;
    Parameter p;

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        Parameter p = new Parameter(null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1() {
        Parameter p = new Parameter("TT0","shortName","description",pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC2() {
        Parameter p = new Parameter("code","RBC","description",pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC3() {
        Parameter p = new Parameter("code","shortName","Red Blood Cells",pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC5() {
        Parameter p = new Parameter("code","shortName","Red Blood Cells",pc);
        String codeParam = p.getCode();
        String codeCatParam = pc.getCode();
        Assert.assertNotEquals(codeParam,codeCatParam);
    }

    @Test
    public void getCode() {
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getCode();
        Assert.assertEquals("TT030",result);
    }

    @Test
    public void getShortName() {
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getShortName();
        Assert.assertEquals("rbc",result);
    }

    @Test
    public void getDescription() {
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getDescription();
        Assert.assertEquals("Red Blood Cells",result);
    }

    @Test
    public void ParameterCodesEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","wbc","While Blood Cells",pc);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterShortNameEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT031","rbc","While Blood Cells",pc);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterDescriptionEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterNotEqualsNull(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = null;
        Assert.assertNotEquals(p1,p2);
    }

    @Test
    public void ParameterNotEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        Assert.assertNotEquals(pc1,p1);
    }

    @Test
    public void testToString() {
    }
}