package app.controller;

import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import app.domain.model.testRelated.Parameter;
import app.domain.model.testRelated.ParameterCategory;
import app.domain.model.testRelated.TestParameter;
import app.domain.model.testRelated.TestType;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.dto.TestParameterDto;
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
        TestParameterDto temDto2 = new TestParameterDto("frefrfe","PLT00");
        List<TestParameterDto> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");
        app.domain.model.testRelated.Test test = new app.domain.model.testRelated.Test(la,nhs,tt,listaDeParametros,"123456789012");

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
        TestParameterDto temDto2 = new TestParameterDto("frefrfe","PLT00");
        List<TestParameterDto> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");
        app.domain.model.testRelated.Test test = new app.domain.model.testRelated.Test (la,nhs,tt,listaDeParametros,"123456789012");

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
        TestParameterDto temDto2 = new TestParameterDto("frefrfe","PLT00");
        List<TestParameterDto> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);
        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        // listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");
        app.domain.model.testRelated.Test test1 = new app.domain.model.testRelated.Test (la,nhs,tt,listaDeParametros,"123456789012");
        app.domain.model.testRelated.Test test2 = new  app.domain.model.testRelated.Test (la,nhs,tt,listaDeParametros,"123456789012");


        List<app.domain.model.testRelated.Test> testWithSamplesCollectedList = new ArrayList();
        testStore.addTest(test1);

        boolean verificacao = controller.PossibilityOfRecordResult();

        Assert.assertTrue(verificacao);

    }
}