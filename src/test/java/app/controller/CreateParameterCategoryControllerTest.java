package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateParameterCategoryControllerTest {

    CreateParameterCategoryController ctrl;
    Company company;
    ParameterCategory pc;
    ParameterCategoryStore pcStore;

    @Before
    public void setup(){
        company= new Company("Many Labs");
        ctrl = new CreateParameterCategoryController(company);
        pcStore = company.getParameterCategoryStore();
        pc = new ParameterCategory("12345","test");

    }

    @Test
    public void createValidParameterCategory() {
        boolean result = ctrl.createParameterCategory("12345","test");
        Assert.assertTrue(result);
    }

    @Test
    public void createInvalidParameterCategory() {
        pcStore.addParameterCategory(pc);
        boolean result = ctrl.createParameterCategory("12345","test");
        Assert.assertFalse(result);
    }

    @Test
    public void saveValidTestType() {
        boolean creator = ctrl.createParameterCategory("12345","test");
        boolean result = ctrl.saveTestType();
        Assert.assertTrue(result);
    }

    @Test
    public void saveInvalidTestType() {
        boolean creator = ctrl.createParameterCategory("12345","test");
        pcStore.addParameterCategory(pc);
        boolean result = ctrl.saveTestType();
        Assert.assertFalse(result);
    }
}