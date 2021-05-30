package app.domain.model.testrelated;

import app.controller.RecordResultsController;
import app.controller.WriteMedicalReportController;
import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDTO;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LabCoordinatorValidationTest {

    @Test
    public void checkDate() {
        /*
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

        for(TestParameterDTO tp : controller.getTestParameterList("00000000000")){
            controller.addTestResult(tp.getParameterId(),"10","mg");
        }



        WriteMedicalReportController ctrl = new WriteMedicalReportController(company);

        TestDTO tDto = new TestDTO(test);
        List<TestDTO> tList = new ArrayList<>();
        tList.add(tDto);
        List<TestDTO> result = ctrl.getTestHasSamplesAnalyzedList();
        Assert.assertEquals(tList,result);
        */
    }

    @Test
    public void recordDate() {
    }

    @Test
    public void recordLabCoordinatorValidationDate() {
    }

    @Test
    public void getLabCoordDate() {
    }
}