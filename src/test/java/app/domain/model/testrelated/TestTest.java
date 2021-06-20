package app.domain.model.testrelated;

import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.users.Client;
import app.mappers.dto.TestParameterDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
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

    @Test
    public void getStateOfTest(){
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



        app.domain.model.testrelated.Test.StateOfTest state = test.getStateOfTest();
        app.domain.model.testrelated.Test.StateOfTest state1 = app.domain.model.testrelated.Test.StateOfTest.testRegistered;
        Assert.assertEquals(state1,state);
    }

    @Test
    public void getClient(){
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



       Client cl = test.getCl();
        Client cl2 = client;
        Assert.assertEquals(cl,cl2);
    }

    @Test
    public void getNhsCode(){
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



        NhsCode nhsCode = test.getNhsCode();
        Assert.assertEquals(nhsCode,nhs);
    }


    @Test
    public void getInternalCode(){
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



        String internalcode = test.getInternalCode();
        String Internal = "123123123123";
        Assert.assertEquals(internalcode,Internal);
    }

    @Test
    public void getTestType(){
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



        TestType testType = test.getTestType();
        Assert.assertEquals(tt,testType);
    }



    @Test
    public void getDescription(){
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



        String description = test.getDescription();
        String description2 = "syringe";
        Assert.assertEquals(description2,description);
    }

    @Test
    public void getChemicalAnalysisDate(){
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



        List<Date> date = test.getChemicalAnalysisDate();

        List<Date> dateList = new ArrayList<>();
        for (TestParameter testParameter : test.getTestParameterList()) {
            dateList.add(testParameter.getParamResult().getChemicalAnalysisDate());
        }

        Assert.assertEquals(dateList,date);
    }

    @Test
    public void getMedicalReport(){
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



        MedicalReport description = test.getMedicalReport();
        MedicalReport medicalReport = null;
        Assert.assertEquals(medicalReport,description);
    }

    @Test
    public void getLab(){
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



        ClinicalAnalysisLaboratory laboratory = test.getLab();
        Assert.assertEquals(lab,laboratory);
    }

    @Test
    public void getSamples(){
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



        List<Sample> list1 = test.getSamples();
        List<Sample>  sampleList = new ArrayList<>();
        Assert.assertEquals(list1,sampleList);
    }

    @Test
    public void TestEquals(){
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
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");


        Assert.assertTrue(test.equals(test2));
    }

    @Test
    public void TestEqualsReference(){
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
        app.domain.model.testrelated.Test test2 = test;


        Assert.assertTrue(test.equals(test2));
    }

    @Test
    public void TestEqualsNull(){
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
        app.domain.model.testrelated.Test test2 = null;


        Assert.assertFalse(test.equals(test2));
    }

    @Test
    public void TestEqualsOtherClass(){
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


        Assert.assertFalse(test.equals(tt));
    }

    @Test
    public void TestAddTestResultValidation() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
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



        Assert.assertFalse(test.addTestResult("HB000","    ","    "));
    }

    @Test
    public void TestAddTestResultValidation2() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
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

        Date chemicalDate = new Date("17/05/2021  10:07:00");

        Assert.assertTrue(test.addTestResultWithDate("HB000","213","mg",chemicalDate));
    }

    @Test
    public void TestAddTestResultValidation3() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
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

        Date chemicalDate = new Date("17/05/2021  10:07:00");

        Assert.assertFalse(test.addTestResultWithDate("HB000","   ","   ",chemicalDate));
    }

    @Test
    public void AddMedicalReport() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
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



        Assert.assertTrue(test.addMedicalReport("fergergerger"));
    }

    @Test
    public void ValidateWork() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
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



        Assert.assertTrue(test.validateWork());
    }

    @Test
    public void AddSamples() throws BarcodeException {
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

        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        Sample sample = new  Sample (barcodeDomain);

        test.addSamples(sample);
        app.domain.model.testrelated.Test.StateOfTest state = app.domain.model.testrelated.Test.StateOfTest.samplesCollected;

        Assert.assertEquals(state,test.getStateOfTest());
    }



}