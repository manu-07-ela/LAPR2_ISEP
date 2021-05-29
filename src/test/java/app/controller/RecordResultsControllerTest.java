package app.controller;

import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestParameter;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
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

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");


        TestStore testStore = company.getTestStore();
        testStore.addTest(test);
        RecordResultsController controller = new RecordResultsController(company);

        controller.getTestParameterList("00000000000");


        boolean verificacao = controller.addTestResult("PLT00","1234","mg");

        Assert.assertTrue(verificacao);

    }



    /*

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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test (la,nhs,tt,listaDeParametros,"123456789012");

        RecordResultsController controller = new RecordResultsController();
        boolean verificacao = controller.addTestResult("TBF23","1234","mg");

        System.out.println(verificacao);

        Assert.assertFalse(verificacao);

    }

     */

    /*

    @Test
    public void possibilityOfRecordResult() {
        Company company = new Company("defgrgtgr");
        RecordResultsController controller = new RecordResultsController(company);
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
        app.domain.model.testrelated.Test test1 = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");

        TestStore testStore1 = company.getTestStore();
        testStore1.addTest(test1);

        List<app.domain.model.testrelated.Test> testWithSamplesCollectedList = new ArrayList();
        testWithSamplesCollectedList.add(test1);

        boolean verificacao = controller.PossibilityOfRecordResult();

        Assert.assertTrue(verificacao);

    }

     */
}