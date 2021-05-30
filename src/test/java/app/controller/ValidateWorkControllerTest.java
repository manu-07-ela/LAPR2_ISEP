package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidateWorkControllerTest {


    @Test
    public void getTestsToValidateList() {

        Company company = new Company("ML");

        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        company.getParameterCategoryStore().addParameterCategory(pc1);

        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        company.getParameterStore().addParameter(p1);
        Parameter p2 = new Parameter("WBC00","WBC","White Cell Count ",pc1);
        company.getParameterStore().addParameter(p2);

        List<ParameterCategory> list=new ArrayList();
        list.add(pc1);

        TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
        company.getTestTypeStore().addTestType(tt);

    }

    @Test
    public void getSelectedTest() {

    }

    @Test
    public void createTestValidation() {
    }

    @Test
    public void checkDate() {

    }

    @Test
    public void showRegistrationDate() {
    }

    @Test
    public void showChemicalAnalysisDate() {
    }

    @Test
    public void showDiagnosisDate() {
    }

    @Test
    public void showLabCoordValidationDate() {
    }

    @Test
    public void showDates() {
    }

    @Test
    public void recordValidationDate() {
    }

    @Test
    public void notifyTheClient() {
    }
}