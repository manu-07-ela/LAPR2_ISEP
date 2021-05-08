package app.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterCategoryStoreTest {

    ParameterCategory pc;
    List<ParameterCategory> listPC;
    ParameterCategoryStore pcStore;

    @Before
    public void setup(){
        pcStore = new ParameterCategoryStore();
        pc = new ParameterCategory("12A4D","Covid-19");
        listPC = new ArrayList();
        listPC.add(pc);
    }

    @Test
    public void createParameterCategory(){
        ParameterCategory result = pcStore.createParameterCategory("12A4D","Covid-19");
        Assert.assertEquals(pc, result);
    }

    @Test
    public void validateValidParameterCategory(){
        boolean result = pcStore.validateParameterCategory(pc);
        Assert.assertTrue(result);
    }

    @Test
    public void validateInvalidParameterCategory(){
        pcStore.addParameterCategory(pc);
        boolean result = pcStore.validateParameterCategory(pc);
        Assert.assertFalse(result);
    }

    @Test
    public void validateNullParameterCategory(){
        ParameterCategory test = null;
        boolean result = pcStore.validateParameterCategory(test);
        Assert.assertFalse(result);
    }

    @Test
    public void getExistingParameterCategoryByCode(){
        pcStore.addParameterCategory(pc);
        ParameterCategory result=pcStore.getParameterCategoryByCode("12A4D");
        Assert.assertEquals(pc,result);
    }

    @Test
    public void getNonexistentParameterCategoryByCode(){
        ParameterCategory result=pcStore.getParameterCategoryByCode("12A4D");
        Assert.assertEquals(null,result);
    }

    @Test
    public void saveValidParameterCategory() {
        boolean result = pcStore.saveParameterCategory(pc);
        Assert.assertTrue(result);
    }

    @Test
    public void saveInvalidParameterCategory() {
        pcStore.addParameterCategory(pc);
        boolean result = pcStore.saveParameterCategory(pc);
        Assert.assertFalse(result);
    }

    @Test
    public void saveNullParameterCategory(){
        ParameterCategory test = null;
        boolean result = pcStore.saveParameterCategory(test);
        Assert.assertFalse(result);
    }

    @Test
    public void getParameterCategoryList(){
        pcStore.addParameterCategory(pc);
        List<ParameterCategory> result = pcStore.getParameterCategoryList();
        Assert.assertEquals(listPC,result);
    }


}