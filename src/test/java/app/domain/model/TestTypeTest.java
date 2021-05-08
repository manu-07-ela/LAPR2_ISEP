package app.domain.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTypeTest {

    ParameterCategory pc;
    List<ParameterCategory> listPC;
    TestType testType;

    @Before
    public void setup(){
        pc = new ParameterCategory("12A4D","Covid-19");
        listPC = new ArrayList();
        listPC.add(pc);
        testType = new TestType("98765","test","method",listPC);
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
    public void ensureDescriptionMeetsAC2(){
        TestType tt = new TestType("1g3d7","descriptionteste","method",listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodMeetsAC3(){
        TestType tt = new TestType("1g354","description","collectingmethodteste",listPC);
    }

    @Test
    public void testTypesCodesEquals(){
        TestType tt1 = new TestType("1f5dc", "test","collecting",listPC);
        TestType tt2 = new TestType("1f5dc", "teste","collectingmethod",listPC);
        Assert.assertEquals(tt1,tt2);
    }

    @Test
    public void testTypesDescriptionEquals(){
        TestType tt1 = new TestType("1f5da", "test","collecting",listPC);
        TestType tt2 = new TestType("1f5dc", "test","collectingmethod",listPC);
        Assert.assertEquals(tt1,tt2);
    }

    @Test
    public void testTypesRefEquals(){
        TestType tt1 = new TestType("1f5da", "test","collecting",listPC);
        TestType tt2 = tt1;
        Assert.assertEquals(tt1,tt2);
    }

    @Test
    public void testTypesNotEqualsNull(){
        TestType tt1 = new TestType("1f5da", "test","collecting",listPC);
        TestType tt2 = null;
        Assert.assertNotEquals(tt1,tt2);
    }

    @Test
    public void testTypesNotEquals(){
        TestType tt1 = new TestType("1f5da", "test","collecting",listPC);
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        Assert.assertNotEquals(pc1,tt1);
    }

    @Test
    public void getListOfParameterCategories() {
        TestType tt = new TestType("1g354","description","collectingmethod",listPC);
        List<ParameterCategory> result = tt.getListOfParameterCategories();
        Assert.assertEquals(listPC,result);
    }

    @Test
    public void getCollectingMethod() {
        TestType tt = new TestType("1g354","description","collectingmethod",listPC);
        String result = tt.getCollectingMethod();
        Assert.assertEquals("collectingmethod",result);
    }

    @Test
    public void getDescription() {
        TestType tt = new TestType("1g354","description","collectingmethod",listPC);
        String result = tt.getDescription();
        Assert.assertEquals("description",result);
    }

    @Test
    public void getCode() {
        TestType tt = new TestType("1g354","description","collectingmethod",listPC);
        String result = tt.getCode();
        Assert.assertEquals("1g354",result);
    }




  
}