
package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.TestTypeDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClinicalAnalysisLaboratoryStoreTest {

    String api;
    TestType tt;
    ParameterCategory pc;
    List<ParameterCategory> listPC;
    ClinicalAnalysisLaboratoryStore calStore;
    List<TestType> listTT;


    ParameterCategory pc1;
    ParameterCategory pc2;
    ParameterCategoryDTO pcDto;
    List<ParameterCategory> listPC1;
    List<ParameterCategory> listPC2;
    List<ParameterCategory> listPC3;
    List<ParameterCategoryDTO> listPC1DTO;
    TestType tt1;
    TestType tt2;
    TestType tt3;
    TestTypeDTO tt1DTO;
    List<TestType> testTypeList;
    List<TestTypeDTO> testTypeListDTO;
    ClinicalAnalysisLaboratory cal;
    List<ClinicalAnalysisLaboratory> calList;
    CreateClinicalAnalysisLaboratoryMapper calMapper;

    @Before
    public void setup() {
        calStore = new ClinicalAnalysisLaboratoryStore();
        calMapper = new CreateClinicalAnalysisLaboratoryMapper();
        String api = "ExternalModule3Adapter";

        pc1 = new ParameterCategory("12A4D","Covid-19");
        pc2 = new ParameterCategory("345vH","Covid-19");
        pcDto = new ParameterCategoryDTO("345vH","Covid-19");
        listPC1 = new ArrayList();
        listPC1.add(pc1);

        listPC2 = new ArrayList();
        listPC2.add(pc2);

        listPC3 = new ArrayList();
        listPC3.add(pc1);
        listPC3 = new ArrayList();
        listPC3.add(pc2);
        listPC1DTO = new ArrayList<>();
        listPC1DTO.add(pcDto);

        tt1 = new TestType("98765","test","method",listPC1,api);
        tt2 = new TestType("32424","Teste","swab",listPC2,api);
        tt3 = new TestType("47832","Teste","swab",listPC3,api);
        tt1DTO = new TestTypeDTO("98765","test","method",listPC1DTO,api);

        testTypeList = new ArrayList();
        testTypeList.add(tt1);

        testTypeListDTO = new ArrayList<>();
        testTypeListDTO.add(tt1DTO);

        cal = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);

        calList= new ArrayList<>();
        calList.add(cal);

    }

    @Test
    public void createLaboratory(){
        ClinicalAnalysisLaboratoryDTO calDTO = new ClinicalAnalysisLaboratoryDTO("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeListDTO);
        ClinicalAnalysisLaboratory result = calStore.createClinicalAnalysisLaboratory(calDTO,calMapper);
        Assert.assertEquals(cal, result);
    }

    @Test
    public void validateLaboratory1(){
        boolean result = calStore.validateClinicalAnalysisLaboratory(cal);
        Assert.assertTrue(result);
    }

    @Test
    public void validateLaboratory2(){
        calStore.addClinicalAnalysisLaboratory(cal);
        boolean result = calStore.validateClinicalAnalysisLaboratory(cal);
        Assert.assertFalse(result);
    }

    @Test
    public void validateLaboratory3(){
        ClinicalAnalysisLaboratory cal = null;
        boolean result = calStore.validateClinicalAnalysisLaboratory(cal);
        Assert.assertFalse(result);
    }

    @Test
    public void validateGlobalLaboratory1(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Ricardo","Rua das cavalas","12345678913","1234567892","12ki7",testTypeList);
        calStore.addClinicalAnalysisLaboratory(call);
        boolean result = calStore.validateClinicalAnalysisLaboratoryglobal(cal);
        Assert.assertFalse(result);
    }

    @Test
    public void validateGlobalLaboratory2(){
        boolean result = calStore.validateClinicalAnalysisLaboratoryglobal(cal);
        Assert.assertTrue(result);
    }

    @Test
    public void saveLaboratory1() {
        boolean result = calStore.saveClinicalAnalysisLaboratory(cal);
        Assert.assertTrue(result);
    }

    @Test
    public void saveLaboratory2() {
        calStore.addClinicalAnalysisLaboratory(cal);
        boolean result = calStore.saveClinicalAnalysisLaboratory(cal);
        Assert.assertFalse(result);
    }

    @Test
    public void saveLaboratory3() {
        ClinicalAnalysisLaboratory cal = null;
        boolean result = calStore.saveClinicalAnalysisLaboratory(cal);
        Assert.assertFalse(result);
    }

    @Test
    public void getClinicalAnalysisLaboratory() {
        calStore.addClinicalAnalysisLaboratory(cal);
        List<ClinicalAnalysisLaboratory> result = calStore.getClinicalAnalysisLaboratoryList();
        Assert.assertEquals(calList,result);
    }

}
