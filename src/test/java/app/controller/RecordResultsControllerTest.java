package app.controller;

import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.dto.TestParameterDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RecordResultsControllerTest {

    /*@Test
    public void getTestParameterList() throws BarcodeException {
        Company company = new Company("efwgtrt");
        List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);
        Parameter p = new Parameter("HB000","test","method", pc);
        Parameter p2 = new Parameter("PLT00","test","method", pc);

        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);

        TestStore testStore = company.getTestStore();
        testStore.addTest(test);
        RecordResultsController controller = new RecordResultsController(company);

        TestParameterDTO temDto2 = new TestParameterDTO("test","PLT00");
        List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);

        List<TestParameterDTO> lista = controller.getTestParameterList("00000000000");

        Assert.assertEquals(listaDeParametrosDTO,lista);
    }


    @Test
    public void addTestResult1() throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException {
        Company company = new Company("efwgtrt");
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
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);

        TestStore testStore = company.getTestStore();
        testStore.addTest(test);
        RecordResultsController controller = new RecordResultsController(company);

        controller.getTestParameterList("00000000000");


        boolean verificacao = controller.addTestResult("PLT00","1234","mg");

        Assert.assertTrue(verificacao);



    }


    @Test
    public void addTestResult2() throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException {
        Company company = new Company("efwgtrt");
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
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");


        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);

        TestStore testStore = company.getTestStore();
        testStore.addTest(test);
        RecordResultsController controller = new RecordResultsController(company);

        controller.getTestParameterList("00000000000");


        boolean verificacao = controller.addTestResult("TBF23","1234","mg");


        Assert.assertFalse(verificacao);

    }*/





   /* @Test
    public void possibilityOfRecordResult() throws BarcodeException {
        Company company = new Company("efwgtrt");
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
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");


        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);

        TestStore testStore = company.getTestStore();
        testStore.addTest(test);
        RecordResultsController controller = new RecordResultsController(company);

        controller.getTestParameterList("00000000000");


        boolean verificacao = controller.PossibilityOfRecordResult();

        Assert.assertTrue(verificacao);

    }

    @Test
    public void possibilityOfRecordResult2() throws BarcodeException {
        Company company = new Company("efwgtrt");
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
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");

        RecordResultsController controller = new RecordResultsController(company);



        boolean verificacao = controller.PossibilityOfRecordResult();

        Assert.assertFalse(verificacao);

    }*/


}