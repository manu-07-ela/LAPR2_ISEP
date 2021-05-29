package app.controller;

import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WriteMedicalReportControllerTest {

    /*
    @Test
    public void getTestHasSamplesAnalyzedList() throws BarcodeException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Company company = new Company("Many Labs");

        List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);

        Parameter p2 = new Parameter("PLT00","test","method", pc);


        TestParameter tpm2 = new TestParameter(p2);

        listaDeParametros.add(tpm2);
        Client la = new Client("frferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");

        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros, "123123123123");

        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        test.addSamples(sample);

        TestStore testStore = company.getTestStore();
        testStore.addTest(test);

        RecordResultsController controller = new RecordResultsController(company);

        for(TestParameterDTO tpDto : controller.getTestParameterList("00000000000")){
            controller.addTestResult(tpDto.getParameterId(),"10","mg");
        }

        WriteMedicalReportController ctrl = new WriteMedicalReportController(company);

        TestDTO tDto = new TestDTO(test);
        List<TestDTO> tList = new ArrayList<>();
        tList.add(tDto);
        List<TestDTO> result = ctrl.getTestHasSamplesAnalyzedList();
        Assert.assertEquals(tList,result);

    }

     */

    /*
    @Test
    public void addMedicalReport(){
        Company company = new Company("Many Labs");
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
        WriteMedicalReportController ctrl = new WriteMedicalReportController(company);
        TestDTO tDto = new TestDTO(test);
        ctrl.getTestParameterList(tDto);
        ctrl.addMedicalReport("The patient is healthy");
    }

     */


}