package app.domain.store;

import app.controller.RecordSampleController;
import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import app.mappers.dto.TestParameterDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestStoreTest {

    @Test
    public void getTestList() {
        TestStore testStore = new TestStore();
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
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        NhsCode nhs = new NhsCode("123456789012");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");
        testStore.addTest(test);

        List<app.domain.model.testrelated.Test> lista = new ArrayList<>();
        lista.add(test);

        Assert.assertEquals(lista,testStore.getTestList());

    }



    @Test(expected = IllegalArgumentException.class)
    public void barcodeValidation1() {
        TestStore testStore = new TestStore();
        String barcode ="    ";

        testStore.barcodeValidation(barcode);

    }

    @Test(expected = IllegalArgumentException.class)
    public void barcodeValidation2() {
        TestStore testStore = new TestStore();
        String barcode ="12345678901234456";

        testStore.barcodeValidation(barcode);

    }

    @Test
    public void getTestByBarcode() throws ClassNotFoundException, IOException, InstantiationException, BarcodeException, IllegalAccessException {
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
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        RecordSampleController controller = new RecordSampleController();

        TestStore testStore = new TestStore();
        testStore.addTest(test);

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);


        app.domain.model.testrelated.Test test2 = testStore.getTestByBarcode("00000000000");

        Assert.assertEquals(test,test2);

    }

    @Test
    public void getTestByBarcode2() throws ClassNotFoundException, IOException, InstantiationException, BarcodeException, IllegalAccessException {
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
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        NhsCode nhs = new NhsCode("123456789012");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        RecordSampleController controller = new RecordSampleController();

        TestStore testStore = new TestStore();
        testStore.addTest(test);

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);


        app.domain.model.testrelated.Test test2 = testStore.getTestByBarcode("00000000001");

        Assert.assertNull(test2);

    }


    @Test
    public void getTestWithSamplesCollectedList() throws BarcodeException {
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
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        NhsCode nhs = new NhsCode("123456789012");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);

        TestStore testStore = new TestStore();
        testStore.addTest(test);

        List<app.domain.model.testrelated.Test> lista = new ArrayList<>();
        lista.add(test);

        List<app.domain.model.testrelated.Test> testWithSamplesCollectedList = testStore.getTestWithSamplesCollectedList();

        Assert.assertEquals(lista,testWithSamplesCollectedList);

    }

    /*

    @Test
    public void getTestHasSamplesAnalyzedList() throws BarcodeException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Company company = new Company("Many Labs");
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
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);


        for (TestParameter tp : test.getTestParameterList()){
            test.addTestResult(tp.getParameterId(),"10","20");
        }

        TestStore testStore = company.getTestStore();
        testStore.addTest(test);

        List<app.domain.model.testrelated.Test> lista = new ArrayList<>();
        lista.add(test);

        List<app.domain.model.testrelated.Test> testHasSamplesAnalyzedList = testStore.getTestHasSamplesAnalyzedList();

        Assert.assertEquals(lista,testHasSamplesAnalyzedList);

    }

     */

    @Test
    public void getTestByInternalCode(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","Female","1231231231","12312312312","rita@gmail.com");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        NhsCode nhs = new NhsCode("123456789012");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab, "123123123123");
        TestStore ttStore = company.getTestStore();
        ttStore.addTest(test);
        app.domain.model.testrelated.Test result = ttStore.getTestByInternalCode("123123123123");
        Assert.assertEquals(test,result);
    }

    @Test
    public void getTestByInternalCodeNull(){
        Company company = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);
        Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","Female","1231231231","12312312312","rita@gmail.com");
        NhsCode nhs = new NhsCode("123456789012");
        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        RefValue rv = new RefValue("mg",10,20);
        TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
        TestParameter tp = new TestParameter(p1,tpr);
        List<TestParameter> tpList = new ArrayList<>();
        tpList.add(tp);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab, "123123123123");
        TestStore ttStore = company.getTestStore();
        app.domain.model.testrelated.Test result = ttStore.getTestByInternalCode("123123123123");
        Assert.assertNull(result);
    }
}