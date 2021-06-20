package app.domain.model.testrelated;

import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.users.Client;
import app.mappers.dto.TestParameterDTO;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OverviewTest {

    @Test
    public void getAvailableAlgorithms() throws ParseException {
       /* Company company = new Company("efwgtrt");
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
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com","Rua das cavalas");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
        NhsCode nhs = new NhsCode("123456789012");
        List<TestType> ttlist = new ArrayList<>();
        ttlist.add(tt);
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");
        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);

        Date initialDate = new Date("15/05/2021");
        Date endDate = new Date("30/05/2021");

        Overview overview = new Overview(initialDate,endDate,testList);

        List<String> availableAlgorithms = new ArrayList(Arrays.asList("Benchmark", "BruteForce"));

        Assert.assertEquals(availableAlgorithms,overview.getAvailableAlgorithms());


        */
    }
}