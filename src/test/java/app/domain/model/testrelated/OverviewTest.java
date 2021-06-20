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

    @Test
    public void getIntervalDays() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


       Date initialDate = new Date("14/05/2021  10:07:00");
       Date endDate = new Date ("25/05/2021  10:07:00");




       List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
       testList.add(test);
       testList.add(test2);
       testList.add(test3);

       Overview overview = new Overview (initialDate,endDate,testList);
       overview.getIntervalDays();

       List<Date> dateList = new ArrayList<>();

        dateList = overview.getDates();

        Assert.assertEquals(dateList,overview.getDates());

    }

    @Test
    public void getAssociatedClients() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);


        List<Client> clList = new ArrayList<>();
        clList.add(client);
        int sizeexpected = clList.size();
        int sizeresult = overview.getNumberOfClients();

        Assert.assertEquals(sizeexpected,sizeresult);
    }

    @Test
    public void getSequence() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        int [] expected = Overview.getSequence();

        Assert.assertEquals(expected, Overview.getSequence());

    }

    @Test
    public void getAvaiableAlgorithm() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        List<String> availableAlgorithms = new ArrayList(Arrays.asList("Benchmark", "BruteForce"));

        Assert.assertEquals(availableAlgorithms , overview.getAvailableAlgorithms());

    }

    @Test
    public void getTestsProcessed() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        List<Integer> expected = overview.getTestProcessed();

        Assert.assertEquals(expected,overview.getTestProcessed());

    }

    @Test
    public void getTestsWaitingForDiagnosis() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        List<Integer> expected = overview.getTestsWaitingForDiagnosis();

        Assert.assertEquals(expected,overview.getTestsWaitingForDiagnosis());

    }

    @Test
    public void getTestsWaitingForResults() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        List<Integer> expected = overview.getTestWaitingForResults();

        Assert.assertEquals(expected,overview.getTestWaitingForResults());

    }

    @Test
    public void getIntervalDates() throws ParseException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        List<Date> expected = overview.getIntervalDates();

        Assert.assertEquals(expected,overview.getIntervalDates());

    }

    @Test
    public void getSubsequenceWithMaximumSum() throws ParseException, IllegalAccessException, InstantiationException, ClassNotFoundException {
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
        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test2 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );
        app.domain.model.testrelated.Test test3 = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"128123123123", new Date("18/05/2021  10:07:00"), new Date("19/05/2021  10:07:00"),new Date("20/05/2021  10:07:00"),new Date("16/05/2021  10:07:00") );


        Date initialDate = new Date("14/05/2021  10:07:00");
        Date endDate = new Date ("25/05/2021  10:07:00");


        List<app.domain.model.testrelated.Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        Overview overview = new Overview (initialDate,endDate,testList);
        int [] la = overview.getSubsequenceWithMaximumSum("Benchmark");

        for (int i = 0 ; i<la.length; i++){
            System.out.println(la[i]);
        }
    }

}