
package app.domain.model.testrelated;

import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParameterTest {


    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        Parameter p = new Parameter(null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("TT0","shortName","description",pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC2() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("code","RBC","description",pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC3() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("code","shortName","Red Blood Cells",pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC5() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("code","shortName","Red Blood Cells",pc);
        String codeParam = p.getCode();
        String codeCatParam = pc.getCode();
        Assert.assertNotEquals(codeParam,codeCatParam);
    }

    @Test
    public void ShortNameValidation2() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("co4de","shortName4","RedCells",pc);
    }

    @Test
    public void DescriptionValidation2() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("co4de","shortName4","Red Blood Cells lala",pc);
    }

    @Test
    public void getCode() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getCode();
        Assert.assertEquals(result,"TT030");
    }

    @Test
    public void getShortName() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getShortName();
        Assert.assertEquals("rbc",result);
    }

    @Test
    public void getDescription() {
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p = new Parameter("TT030","rbc","Red Blood Cells",pc);
        String result = p.getDescription();
        Assert.assertEquals("Red Blood Cells",result);
    }

    @Test
    public void ParameterCodesEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        ParameterCategory pc1 = new ParameterCategory("FTB01","Hemogram");

        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","wbc","While Blood Cells",pc1);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterShortNameEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        ParameterCategory pc1 = new ParameterCategory("FTB01","Hemogram");

        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT031","rbc","While Blood Cells",pc1);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterDescriptionEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        ParameterCategory pc1 = new ParameterCategory("FTB01","Hemogram");

        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","rbc","Red Blood Cells",pc1);
        Assert.assertEquals(p1,p2);
    }

    @Test
    public void ParameterCategoryEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Assert.assertTrue(p1.equals(p2));
    }

    @Test
    public void ParameterNotEqualsNull(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Assert.assertFalse(p1.equals(null));
    }

    @Test
    public void ParameterAllDataNotEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        ParameterCategory pc1  = new ParameterCategory("FTB01","Hemogram");

        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("44LO1","wbc","White Blood Cells",pc1);
        Assert.assertFalse(p1.equals(p2));
    }

    @Test
    public void ParameterNotEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        Assert.assertFalse(pc1.equals(p1));
    }

    @Test
    public void ParameterEquals(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);
        Parameter p2 = new Parameter("TT030","rbc","Red Blood Cells",pc);

        Assert.assertTrue(p1.equals(p2));
    }

    @Test
    public void getParameterCategory(){
        ParameterCategory pc = new ParameterCategory("55Y7V","Covid-19");
        Parameter p1 = new Parameter("TT030","rbc","Red Blood Cells",pc);


        Assert.assertEquals(pc,p1.getCategory());
    }


}

