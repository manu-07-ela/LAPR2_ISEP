package app.domain.store;

import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.domain.store.TestTypeStore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTypeStoreTest {

    String api;
    TestType tt;
    ParameterCategory pc;
    List<ParameterCategory> listPC;
    TestTypeStore ttStore;
    List<TestType> listTT;

    @Before
    public void setup(){
        String api = "ExternalModule3Adapter";
        ttStore = new TestTypeStore();
        pc = new ParameterCategory("12A4D","Covid-19");
        listPC = new ArrayList();
        listPC.add(pc);
        tt = new TestType ("12345","test","collecting",listPC,api);
        listTT = new ArrayList();
    }

    @Test
    public void createAnTestType(){
        TestType result = ttStore.createTestType("12345","test","collecting",listPC,api);
        Assert.assertEquals(tt, result);
    }

    @Test
    public void validateAnValidTestType(){
        boolean result = ttStore.validateTestType(tt);
        Assert.assertTrue(result);
    }

    @Test
    public void validateAnInvalidTestType(){
        ttStore.addTestType(tt);
        boolean result = ttStore.validateTestType(tt);
        Assert.assertFalse(result);
    }

    @Test
    public void validateAnNullTestType(){
        TestType test = null;
        boolean result = ttStore.validateTestType(test);
        Assert.assertFalse(result);
    }

    @Test
    public void getAnExistingTestTypeByCode(){
        ttStore.addTestType(tt);
        TestType result=ttStore.getTestTypeByCode("12345");
        Assert.assertEquals(tt,result);
    }

    @Test
    public void getAnNonexistentTestTypeByCode(){
        TestType result=ttStore.getTestTypeByCode("12345");
        Assert.assertEquals(null,result);
    }

    @Test
    public void getAnNonexistentParameterCategoryByCode_2(){
        ttStore.addTestType(tt);
        TestType result=ttStore.getTestTypeByCode("12s4D");
        Assert.assertEquals(null,result);
    }

    @Test
    public void saveAnValidTestType() {
        boolean result = ttStore.saveTestType(tt);
        Assert.assertTrue(result);
    }

    @Test
    public void saveAnInvalidTestType() {
        ttStore.addTestType(tt);
        boolean result = ttStore.saveTestType(tt);
        Assert.assertFalse(result);
    }

    @Test
    public void saveANullTestType(){
        TestType test = null;
        boolean result = ttStore.saveTestType(test);
        Assert.assertFalse(result);
    }

    @Test
    public void getAnTestTypeList(){
        listTT.add(tt);
        ttStore.addTestType(tt);
        List<TestType> result = ttStore.getTestTypeList();
        Assert.assertEquals(listTT,result);
    }

}







