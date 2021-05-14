package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.TestTypeStore;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateClinicalAnalysisLaboratoryControllerTest {

    CreateClinicalAnalysisLaboratoryController ctrl;
    List<ParameterCategoryDto> lpcDto;
    List<ParameterCategory> lpc;
    List<TestType> ttlist;
    List<TestTypeDTO> ttlistDTO;
    ParameterCategoryStore pcStore;
    TestTypeStore ttStore;
    ParameterCategoryDto pcDto;
    ParameterCategory pc;
    Company company;
    TestType tt;
    TestTypeDTO ttDTO;
    ClinicalAnalysisLaboratory cal;
    ClinicalAnalysisLaboratoryDTO calDTO;
    ClinicalAnalysisLaboratoryStore calStore;

    @Before
    public void setup(){
        App app = App.getInstance();

        company = new Company("Many Labs");
        lpcDto = new ArrayList();
        pcStore = company.getParameterCategoryStore();
        ttStore = company.getTestTypeStore();
        calStore = company.getClinicalAnalysisLaboratoryStore();

        pc = new ParameterCategory("12A4D","Covid-19");
        pcDto = new ParameterCategoryDto("12A4D","Covid-19");
        pcStore.addParameterCategory(pc);

        lpc=pcStore.getParameterCategoryList();
        pcDto = new ParameterCategoryDto("12A4D","Covid-19");
        lpcDto.add(pcDto);

        ctrl = new CreateClinicalAnalysisLaboratoryController(company);
        tt= new TestType("12345","test","collecting",lpc);
        ttStore.addTestType(tt);
        ttlist = new ArrayList<>();
        ttlist.add(tt);
        ttDTO = new TestTypeDTO("12345","test","collecting",lpcDto);
        ttlistDTO = new ArrayList<>();
        ttlistDTO.add(ttDTO);

        cal = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",ttlist);
        calDTO = new ClinicalAnalysisLaboratoryDTO("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",ttlistDTO);

    }


    /*@Test
    public void getTestTypeList(){
        List<TestTypeDTO> result = ctrl.getTestTypeList();
        Assert.assertEquals(ttlistDTO,result);
    }*/




    @Test
    public void CreateClinicalAnalysisLaboratory1(){
        calStore.addClinicalAnalysisLaboratory(cal);
        boolean result = ctrl.CreateClinicalAnalysisLaboratory(calDTO);
        Assert.assertFalse(result);
    }

    @Test
    public void CreateClinicalAnalysisLaboratory2(){
        boolean result = ctrl.CreateClinicalAnalysisLaboratory(calDTO);
        Assert.assertTrue(result);
    }

    @Test
    public void saveClinicalAnalysisLaboratory() {
        ctrl.CreateClinicalAnalysisLaboratory(calDTO);
        calStore.addClinicalAnalysisLaboratory(cal);
        boolean result = ctrl.saveClinicalAnalysisLaboratory();
        Assert.assertFalse(result);
    }

    @Test
    public void saveClinicalAnalysisLaboratory2() {
        ctrl.CreateClinicalAnalysisLaboratory(calDTO);
        boolean result = ctrl.saveClinicalAnalysisLaboratory();
        Assert.assertTrue(result);
    }
}