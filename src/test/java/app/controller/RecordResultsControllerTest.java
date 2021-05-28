package app.controller;

import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import app.domain.store.TestStore;
import app.mappers.dto.TestParameterDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecordResultsControllerTest {

    @Test
    public void getTestParameterList() {


    }

    @Test
    public void addTestResult1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
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
        app.domain.model.Test test = new app.domain.model.Test(la,nhs,tt,listaDeParametros);

        RecordResultsController controller = new RecordResultsController();
        boolean verificacao = controller.addTestResult("PLT00","1234","mg");
        Assert.assertTrue(verificacao);

    }

    @Test
    public void addTestResult2() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
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
        app.domain.model.Test test = new app.domain.model.Test(la,nhs,tt,listaDeParametros);

        RecordResultsController controller = new RecordResultsController();
        boolean verificacao = controller.addTestResult("TBF23","1234","mg");
        Assert.assertFalse(verificacao);

    }

    @Test
    public void possibilityOfRecordResult() {
        Company company = new Company("defgrgtgr");
        RecordResultsController controller = new RecordResultsController(company);
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
        app.domain.model.Test test1 = new app.domain.model.Test(la,nhs,tt,listaDeParametros);
        app.domain.model.Test test2 = new app.domain.model.Test(la,nhs,tt,listaDeParametros);


        List<app.domain.model.Test> testWithSamplesCollectedList = new ArrayList();
        test1.changeStateForSamplesCollected();
        testStore.addTest(test1);

        boolean verificacao = controller.PossibilityOfRecordResult();

        Assert.assertTrue(verificacao);

    }
}