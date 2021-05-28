package app.controller;

import app.controller.funcionalites.CreateParameterCategoryController;
import app.domain.model.Company;
import app.domain.model.testRelated.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void saveValidParameterCategory() {
        ctrl.createParameterCategory("12345","test");
        boolean result = ctrl.saveParameterCategory();
        Assert.assertTrue(result);
    }

    @Test
    public void saveInvalidParmeterCategory() {
        ctrl.createParameterCategory("12345","test");
        pcStore.addParameterCategory(pc);
        boolean result = ctrl.saveParameterCategory();
        Assert.assertFalse(result);
    }
}