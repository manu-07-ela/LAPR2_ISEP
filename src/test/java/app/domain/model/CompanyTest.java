package app.domain.model;

import app.domain.model.laboratories.ChemicalLaboratory;
import app.domain.store.EmployeeStore;
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
    public void getChemicalLaboratory() {
        Company company = new Company("Many labs");
        ChemicalLaboratory che = new ChemicalLaboratory("Lab","rua","12312312312","1231231231");
        Assert.assertEquals(che,company.getChemicalLaboratory());
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

    @Test
    public void getEmployeeStore() {
        Company company = new Company("Many labs");
        EmployeeStore eStore = new EmployeeStore();
        Assert.assertEquals(eStore,company.getEmployeeStore());
    }

    @Test
    public void getAvailableIndependentVariables() {
        Company company = new Company("Many labs");
        List<String> availableIndependentVariablesList = new ArrayList(Arrays.asList("Mean Age", "Tests Performed"));
        Assert.assertEquals(availableIndependentVariablesList,company.getAvailableIndependentVariables());
    }

}