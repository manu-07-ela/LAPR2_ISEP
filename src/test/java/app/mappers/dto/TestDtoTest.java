package app.mappers.dto;

import app.domain.model.attributes.NhsCode;
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
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","Female","1231231231","12312312312","rita@gmail.com");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,"123123123123");
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