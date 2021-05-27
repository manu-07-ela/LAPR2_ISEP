package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.TestTypeStore;
import app.mappers.dto.ParameterCategoryDTO;
import com.example1.ExternalModule3API;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateTestTypeControllerTest {

    String api ;
    CreateTestTypeController ctrl;
    List<ParameterCategoryDTO> lpcDto;
    List<ParameterCategory> lpc;
    ParameterCategoryStore pcStore;
    TestTypeStore ttStore;
    ParameterCategoryDTO pcDto;
    ParameterCategory pc;
    Company company;
    TestType tt;

    @Before
    public void setup(){
        String api = "ExternalModule3Adapter";
        App app = App.getInstance();
        company = new Company("Many Labs");
        lpcDto = new ArrayList();
        pcStore = company.getParameterCategoryStore();
        ttStore = company.getTestTypeStore();
        pc = new ParameterCategory("12A4D","Covid-19");
        pcStore.addParameterCategory(pc);
        lpc=pcStore.getParameterCategoryList();
        pcDto = new ParameterCategoryDTO("12A4D","Covid-19");
        lpcDto.add(pcDto);
        ctrl = new CreateTestTypeController(company);
        tt= new TestType("12345","test","collecting",lpc,api);
    }

    @Test
    public void getParameterCategories(){
        List<ParameterCategoryDTO> result = ctrl.getParameterCategories();
        Assert.assertEquals(lpcDto,result);
    }

    @Test
    public void createValidTestType(){
        boolean result = ctrl.createTestType("12345","test","collecting",lpcDto,api);
        Assert.assertTrue(result);
    }

    @Test
    public void createInvalidTestType(){
        ttStore.addTestType(tt);
        boolean result = ctrl.createTestType("12345","test","collecting",lpcDto,api);
        Assert.assertFalse(result);
    }

    @Test
    public void saveValidTestType() {
        ctrl.createTestType("12345","test","collecting",lpcDto,api);
        boolean result = ctrl.saveTestType();
        Assert.assertTrue(result);
    }

    @Test
    public void saveInvalidTestType() {
        ctrl.createTestType("12345","test","collecting",lpcDto,api);
        ttStore.addTestType(tt);
        boolean result = ctrl.saveTestType();
        Assert.assertFalse(result);
    }



}