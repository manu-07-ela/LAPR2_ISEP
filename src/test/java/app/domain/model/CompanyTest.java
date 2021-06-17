package app.domain.model;

import app.domain.model.laboratories.ChemicalLaboratory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test(expected = IllegalArgumentException.class)
    public void designationValidation() {
        new Company("");
    }

    @Test
    public void getDesignation() {
        Company company = new Company("Many labs");
        Assert.assertEquals("Many labs",company.getDesignation());
    }

    @Test
    public void getListDeAPI() {
        Company company = new Company("Many labs");
        List<String> listaDeAPI = new ArrayList(Arrays.asList("CovidReferenceValues1API", "ExternalModule1API","ExternalModule2API"));
        Assert.assertEquals(listaDeAPI,company.getListDeAPI());
    }

    @Test
    public void getAvailableTypesOfData() {
        Company company = new Company("Many labs");
        List<String> availableTypesOfData = new ArrayList(Arrays.asList("Day", "Week"));
        Assert.assertEquals(availableTypesOfData,company.getAvailableTypesOfData());
    }

    @Test
    public void getAvailableRegressionModels() {
        Company company = new Company("Many labs");
        List<String> availableRegressionModels = new ArrayList(Arrays.asList("Simple Linear", "Multiple Linear"));
        Assert.assertEquals(availableRegressionModels,company.getAvailableRegressionModels());
    }

}