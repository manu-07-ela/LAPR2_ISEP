
package app.domain.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParameterTest {

    ParameterCategory pc;
    ParameterCategory pc1;
    Parameter p;

    @Before
    public void setup(){
        pc = new ParameterCategory("55Y7V","Covid-19");
        pc1 = new ParameterCategory("FTB01","Hemogram");
        p = new Parameter("98765","test","method", pc);
    }

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
        Assert.assertEquals(result,"TT030");
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
        Parameter p2 = new Parameter("TT030","wbc","While Blood Cells",pc1);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterShortNameEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT031","rbc","While Blood Cells",pc1);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterDescriptionEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","rbc","Red Blood Cells",pc1);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterCategoryEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterNotEqualsNull(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Assert.assertNotEquals(p1, null);
    }

    @Test
    public void ParameterAllDataNotEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("44LO1","wbc","White Blood Cells",pc1);
        Assert.assertNotEquals(pc1,p1);
    }

    @Test
    public void ParameterNotEquals(){
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        Assert.assertNotEquals(pc1,p1);
    }
}

