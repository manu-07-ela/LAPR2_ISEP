package app.domain.model;

import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CSVFileReaderTest {

    Company company;
    app.domain.model.testrelated.Test t;
    TestStore tStore;
    Client cl;
    NhsCode nhscode;
    Date samples;
    Date tpr;
    Date lcv;
    Date mr;

//    @Test
//    public void createTest() {
//        cl = new Client("Rita","1111111111111111","1231231231","26/11/2002","Female","1231231231","11111111111","rita@gmail.com","Rua das gaitas");
//        company= new Company("Many Labs");
//        samples = new Date("17/05/2021  08:00:00");
//        tpr = new Date("17/05/2021  08:00:00");
//        lcv = new Date("17/05/2021  08:00:00");
//        mr = new Date("17/05/2021  08:00:00");
//        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Clinical laboratory", "Rua 20", "12312312312", "1234567890", "1234s",company.getTestTypeStore().getTestTypeList());
//        this.tStore = new TestStore();
//        nhscode = new NhsCode("123123123123");
//        List<ParameterCategory> list1=new ArrayList();
//        List<TestParameter> tpList=new ArrayList();
//        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
//        list1.add(pc1);
//        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
//        TestType tt = new TestType("BL000","blood","syringe",list1,"ExternalModule2API");
//        TestParameter tp = new TestParameter(p1);
//        tpList.add(tp);
//        t = tStore.createTestByCsvFile(cl, nhscode, tt, tpList, lab, samples, tpr, lcv, mr);
//        app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(cl, nhscode, tt , tpList, lab, "000000000001", samples, tpr, lcv, mr);
//    assertEquals(t,test);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void clientValidation(){
        Client cl= new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }
}