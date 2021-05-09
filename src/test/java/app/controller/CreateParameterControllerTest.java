package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import app.mappers.dto.ParameterCategoryDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CreateParameterControllerTest {

    CreateParameterController pCtrl;
    List<ParameterCategoryDto> lpcDto;
    List<ParameterCategory> lpc;
    ParameterCategoryStore pcStore;
    ParameterStore pStore;
    ParameterCategoryDto pcDto;
    ParameterCategory pc;
    Company company;
    Parameter p;

    @Before
    public void setup(){
        App app = App.getInstance();
        company = new Company("Many Labs");
        lpcDto = new ArrayList();
        pcStore = company.getParameterCategoryStore();
        pStore = company.getParameterStore();
        pc = new ParameterCategory("AAA00","Hemogram");
        pcStore.addParameterCategory(pc);
        lpc=pcStore.getParameterCategoryList();
        pcDto = new ParameterCategoryDto("AAA00","Hemogram");
        lpcDto.add(pcDto);
        pCtrl = new CreateParameterController(company);
        p = new Parameter ("TT030","rbc","Red Blood Cells",pc);
    }

    @Test
    public void getParameterCategories() {
        List<ParameterCategoryDto> result = pCtrl.getParameterCategories();
        Assert.assertEquals(lpcDto,result);
    }


    @Test
    public void createValidParameter() {
        boolean result = pCtrl.createParameter("TT030","rbc","Red Blood Cells",pcDto);
        Assert.assertTrue(result);
    }

    @Test
    public void createInvalidParameter() {
        pStore.addParameter(p);
        boolean result = pCtrl.createParameter("TT030","rbc","Red Blood Cells",pcDto);
        Assert.assertFalse(result);
    }

    @Test
    public void saveValidParameter() {
        pCtrl.createParameter("TT030","rbc","Red Blood Cells",pcDto);
        boolean result = pCtrl.saveParameter();
        Assert.assertTrue(result);
    }

    @Test
    public void saveInvalidParameter() {
        pCtrl.createParameter("TT030","rbc","Red Blood Cells",pcDto);
        pStore.addParameter(p);
        boolean result = pCtrl.saveParameter();
        Assert.assertFalse(result);
    }


}