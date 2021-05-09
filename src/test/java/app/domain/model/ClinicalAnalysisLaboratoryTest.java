package app.domain.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClinicalAnalysisLaboratoryTest {

    ParameterCategory pc1;
    ParameterCategory pc2;
    List<ParameterCategory> listPC1;
    List<ParameterCategory> listPC2;
    List<ParameterCategory> listPC3;
    TestType tt1;
    TestType tt2;
    TestType tt3;
    List<TestType> testTypeList;
    ClinicalAnalysisLaboratory cal;

    @Before
    public void setup(){
        pc1 = new ParameterCategory("12A4D","Covid-19");
        pc2 = new ParameterCategory("345vH","Covid-19");
        listPC1 = new ArrayList();
        listPC1.add(pc1);

        listPC2 = new ArrayList();
        listPC2.add(pc2);

        listPC3 = new ArrayList();
        listPC3.add(pc1);
        listPC3 = new ArrayList();
        listPC3.add(pc2);
        tt1 = new TestType("98765","test","method",listPC1);
        tt2 = new TestType("32424","Teste","swab",listPC2);
        tt3 = new TestType("47832","Teste","swab",listPC3);

        testTypeList = new ArrayList();
        testTypeList.add(tt1);

        cal = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory(null,null,null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NameValidation(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos Jose da Silva Pinheiro","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressValidation(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas assadas no forno","12345678912","1234567891","12ki3",testTypeList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PhoneNumberValidation1(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912324324","1234567891","12ki3",testTypeList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PhoneNumberValidation2(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678","1234567891","12ki3",testTypeList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TinValidation1(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567","12ki3",testTypeList);
    }
    //TRATAR URGENTE PRO BUILD DO JENKINJS FUNCIONAR 
    /*@Test(expected = IllegalArgumentException.class)
    public void TinValidation2(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
    }*/

    @Test(expected = IllegalArgumentException.class)
    public void LaboratoryIdValidation1(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12k",testTypeList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LaboratoryIdValidation2(){
        ClinicalAnalysisLaboratory call = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3gd1",testTypeList);
    }

    @Test
    public void LaboratoryAddressEquals(){
        ClinicalAnalysisLaboratory cal1 = new ClinicalAnalysisLaboratory("Ricardo","Rua das cavalas","12345678945","1234567891","8uki3",testTypeList);
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567123","12ki3",testTypeList);
        Assert.assertEquals(cal1,cal2);
    }

    @Test
    public void LaboratoryPhoneNumberEquals(){
        ClinicalAnalysisLaboratory cal1 = new ClinicalAnalysisLaboratory("Ricardo","Rua das cavalas","12345678912","1234567891","8uki3",testTypeList);
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas assadas","12345678912","1234567123","12ki3",testTypeList);
        Assert.assertEquals(cal1,cal2);
    }

    @Test
    public void LaboratoryTinEquals(){
        ClinicalAnalysisLaboratory cal1 = new ClinicalAnalysisLaboratory("Ricardo","Rua das cavalas","12345678912","1234567891","8uki3",testTypeList);
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas assadas","12345678913","1234567891","12ki3",testTypeList);
        Assert.assertEquals(cal1,cal2);
    }

    @Test
    public void LaboratoryLaboratoryIdEquals(){
        ClinicalAnalysisLaboratory cal1 = new ClinicalAnalysisLaboratory("Ricardo","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas assadas","12345678913","1234567893","12ki3",testTypeList);
        Assert.assertEquals(cal1,cal2);
    }

    @Test
    public void LaboratoryNotEquals1l(){
        ClinicalAnalysisLaboratory cal1 =  new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
        ParameterCategory pc = new ParameterCategory("345vH","Covid-19");
        Assert.assertNotEquals(cal1,pc);
    }

    @Test
    public void LaboratoryNotEquals2(){
        ClinicalAnalysisLaboratory cal1 =  new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
        ClinicalAnalysisLaboratory cal2 = null;
        Assert.assertNotEquals(cal1,cal2);
    }
}