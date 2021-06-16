package app.mappers.dto;

import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDtoTest {

    @Test
    public void getInternalCode() {
        TestDTO tDto = new TestDTO("123456789123","Zaragatoa");
        String result = tDto.getInternalCode();
        Assert.assertEquals("123456789123",result);
    }

    @Test
    public void testDtoCodeEquals(){
        TestDTO tDto1 = new TestDTO("1f5ac", "test");
        TestDTO tDto2 = new TestDTO("1f5ac", "teste");
        Assert.assertEquals(tDto1,tDto2);
    }

    @Test
    public void testDtoNotEqualsNull(){
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("José Pedrosa","2234567891234567","2234567891","14/12/1995","3231231231","12345678900","pedrosa@gmail.com","Rua da República");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        NhsCode nhs = new NhsCode("123456789012");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab, "123123123123");
        TestDTO tDto1 = new TestDTO(test);
        TestDTO tDto2 = null;
        Assert.assertNotEquals(tDto1,tDto2);
    }

    @Test
    public void testDtoRefEquals(){
        TestDTO tDto1 = new TestDTO("1f5ac", "test");
        TestDTO tDto2 = tDto1;
        Assert.assertEquals(tDto1,tDto2);
    }

}