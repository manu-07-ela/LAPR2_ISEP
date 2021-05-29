package app.domain.store;

import app.controller.RecordSampleController;
import app.domain.model.attributes.NhsCode;
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
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");
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
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");

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
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");

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
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");

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
}