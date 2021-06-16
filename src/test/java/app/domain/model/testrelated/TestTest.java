package app.domain.model.testrelated;

import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.users.Client;
import app.mappers.dto.TestParameterDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestTest {

    @Test
    public void getTestParameterList() {
        List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);
        Parameter p = new Parameter("HB000","test","method", pc);
        Parameter p2 = new Parameter("PLT00","test","method", pc);
        TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PLT00");
        List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        Assert.assertEquals(listaDeParametros,test.getTestParameterList());
    }

    @Test
    public void addTestResult1() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);
        Parameter p = new Parameter("HB000","test","method", pc);
        Parameter p2 = new Parameter("PLT00","test","method", pc);
        TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PLT00");
        List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");


    }
    @Test
    public void addSample() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);
        Parameter p = new Parameter("HB000","test","method", pc);
        Parameter p2 = new Parameter("PLT00","test","method", pc);
        TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PLT00");
        List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        NhsCode nhs = new NhsCode("123456789012");
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");
        boolean verificacao = test.addTestResult("PLT00","23","mg");
        Assert.assertTrue(verificacao);
    }

    @Test
    public void addTestResult2() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);
        Parameter p = new Parameter("HB000","test","method", pc);
        Parameter p2 = new Parameter("PLT00","test","method", pc);
        TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PLT00");
        List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        boolean verificacao = test.addTestResult("PRIGF","23","mg");

        Assert.assertFalse(verificacao);
    }

    @Test
    public void validateValidMedicalReport(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
        boolean result = test.validateMedicalReport();
        Assert.assertTrue(result);
    }

    @Test
    public void validateInvalidMedicalReport(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
        test.addMedicalReport("The patient is healthy");
        boolean result = test.validateMedicalReport();
        Assert.assertFalse(result);
    }

    @Test
    public void addInvalidMedicalReport(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
        test.addMedicalReport("The patient is healthy");
        boolean result = test.addMedicalReport("The patient is healthy");
        Assert.assertFalse(result);
    }

    @Test
    public void validateValidLabCoordinatorValidation(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
        boolean result = test.validateLabCoordinatorValidation();
        Assert.assertTrue(result);
    }

    @Test
    public void validateInvalidLabCoordinatorValidation(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
        test.validateWork();
        boolean result = test.validateLabCoordinatorValidation();
        Assert.assertFalse(result);
    }

    @Test
    public void validateWork(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
        test.validateWork();
        boolean result = test.validateWork();
        Assert.assertFalse(result);
    }
}