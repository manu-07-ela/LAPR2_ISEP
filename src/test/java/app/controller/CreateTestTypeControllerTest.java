package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import app.mappers.dto.ParameterCategoryDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateTestTypeControllerTest {

    List<ParameterCategoryDto> lpcDto;
    ParameterCategoryStore pcStore;
    ParameterCategoryDto pcDto;
    ParameterCategory pc;
    Company company;

    @Before
    public void setup(){
        App app = App.getInstance();
        company = new Company("Many Labs");
        lpcDto = new ArrayList();
        pcStore = company.getParameterCategoryStore();
        pc = new ParameterCategory("12A4D","Covid-19");
        pcStore.addParameterCategory(pc);
        pcDto = new ParameterCategoryDto("12A4D","Covid-19");
        lpcDto.add(pcDto);
    }

    @Test
    public void getParameterCategories(){
        CreateTestTypeController ctrl = new CreateTestTypeController(company);
        List<ParameterCategoryDto> result = ctrl.getParameterCategories();
        Assert.assertEquals(lpcDto,result);
    }

}