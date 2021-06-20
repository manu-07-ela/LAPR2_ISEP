package app.domain.model;

import app.domain.SendAutomaticallyCovid19Report;
import app.domain.model.laboratories.ChemicalLaboratory;
import app.domain.model.testrelated.Covid19Report;
import app.domain.model.testrelated.Overview;
import app.domain.model.testrelated.Test;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import app.domain.store.TestTypeStore;
import app.domain.store.*;
import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company implements Serializable {
    private static final long serialVersionUID = -2873965375442155042L;
    /**
     * Company's designation
     */
    private final String designation;

    /**
     * Represents an instance Auth facade
     */
    private final AuthFacade authFacade;

    /**
     * Represents an instance of the store of TestTypes
     */
    private final TestTypeStore testTypeStore;

    /**
     * Represents an instance of the store of ParameterCategories
     */
    private final ParameterCategoryStore parameterCategoryStore;

    /**
     * Represents an instance of the store of Parameters
     */
    private final ParameterStore parameterStore;

    /**
     * Represents an instance of the store of ClinicalAnalysisLaboratories
     */
    private final ClinicalAnalysisLaboratoryStore clinicalAnalysisLaboratoryStore;

    /**
     * Represents a instance of the chemical laboratory
     */
    private final ChemicalLaboratory chemicalLaboratory;

    /**
     * Represents a instance of the store of employees
     */
    private final EmployeeStore employeeStore;

    /**
     * Represents a instance of the store of organization roles
     */
    private final OrganizationRoleStore organizationRoleStore;

    /**
     * Represents a instance of the store of Client
     */
    private final ClientStore clientStore;

    /**
     *  Represents a instance of the store of Tests
     */
    private final TestStore testStore;

    /**
     * A List with all API's available in the system
     */
    private final List<String> listDeAPI = new ArrayList(Arrays.asList("CovidReferenceValues1API", "ExternalModule1API","ExternalModule2API"));

    /**
     * A list with the types of dates available in the system
     */
    private final List<String> availableTypesOfData = new ArrayList(Arrays.asList("Day", "Week"));

    /**
     * A list with the types of regression models available in the system
     */
    private final List<String> availableRegressionModels = new ArrayList(Arrays.asList("Simple Linear", "Multiple Linear"));

    /**
     *
     */
    private final List<String> availableIndependentVariables = new ArrayList(Arrays.asList("Mean Age", "Tests Performed"));
    /**
     *
     */
    private final SendAutomaticallyCovid19Report sendAutomaticallyCovid19Report;

    /**
     * Creates an instance of Company
     * @param designation Company's designation
     */
    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testTypeStore = new TestTypeStore();
        this.parameterStore = new ParameterStore();
        this.parameterCategoryStore = new ParameterCategoryStore();
        this.clinicalAnalysisLaboratoryStore = new ClinicalAnalysisLaboratoryStore();
        this.employeeStore = new EmployeeStore();
        this.organizationRoleStore = new OrganizationRoleStore();
        this.clientStore = new ClientStore();
        this.testStore = new TestStore();
        this.chemicalLaboratory = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");

        this.sendAutomaticallyCovid19Report = new SendAutomaticallyCovid19Report();


        //setTask();
    }

    /**
     * Get the instance of chemical laboratory
     * @return the chemical laboratory
     */
    public ChemicalLaboratory getChemicalLaboratory() {
        return chemicalLaboratory;
    }

    /**
     * Get the company designation.
     * @return The company designation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets AuthFacade
     * @return The AuthFacade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Get the instance of employee store
     * @return the instance of employee store
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * Get the instance of organization role store
     * @return the instance of organization role store
     */
    public OrganizationRoleStore getOrganizationRoleStore() {
        return organizationRoleStore;
    }

    /**
     * Get the instance of TestTypeStore.
     * @return the instance of TestTypeStore.
     */
    public TestTypeStore getTestTypeStore(){
        return testTypeStore;
    }

    /**
     * Get the instance of ParameterCategoryStore.
     * @return the instance of ParameterCategoryStore.
     */
    public ParameterCategoryStore getParameterCategoryStore(){
        return parameterCategoryStore;
    }

    /**
     * Gets the list containing the company's parameters.
     * @return The ParameterStore
     */
    public ParameterStore getParameterStore(){
        return parameterStore;
    }

    /**
     * Gets the list containing the ClinicalAnalysisLaboratoryStore
     * @return The ClinicalAnalysisLaboratoryStore
     */
    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore(){ return clinicalAnalysisLaboratoryStore; }

    /**
     * Gets the instance of ClientStore
     * @return the instance of clientStore.
     */
    public ClientStore getClientStore() {
        return clientStore;
    }

    /**
     * Gets the instance of TestStore
     * @return the instance of testStore
     */
    public TestStore getTestStore(){
        return testStore;
    }

    /**
     * Gets the list of API´s
     * @return the list of API´s
     */
    public  List<String> getListDeAPI() {
        return listDeAPI;
    }

    /**
     * Get the available types of data in the system
     * @return the list of data
     */
    public List<String> getAvailableTypesOfData(){
        return availableTypesOfData;
    }

    /**
     * Get the available models of regression in the system
     * @return the list of available models of regression in the system
     */
    public List<String> getAvailableRegressionModels(){
        return availableRegressionModels;
    }

    public List<String> getAvailableIndependentVariables() {
        return availableIndependentVariables;
    }

    public Covid19Report createCovid19ReportSimple(double[] xInterval, double[] yInterval, double[] xHistoricalPoints, double[] yHistoricalPoints, double confidenceLevel, double significanceLevel, Date currentDay, String typeOfData){
        return new Covid19Report(xInterval,yInterval,xHistoricalPoints,yHistoricalPoints,confidenceLevel,significanceLevel,currentDay, typeOfData);

    }
    public Covid19Report createCovid19ReportMultiple(double[] x1Interval, double[] x2Interval, double[] yInterval, double[] x1HistoricalPoints, double[] x2HistoricalPoints, double[] yHistoricalPoints, double confidenceLevel, double significanceLevel, Date currentDay, String typeOfData){
        return new Covid19Report(x1Interval, x2Interval, yInterval, x1HistoricalPoints, x2HistoricalPoints, yHistoricalPoints, confidenceLevel, significanceLevel, currentDay, typeOfData);
    }
    public void sendCovid19Report(String report){
        Covid19Report.sendReportNhs(report);
    }
    public Overview createOverview(Date initialDate, Date endDate, List<Test> testList) throws ParseException {
        return new Overview(initialDate,endDate,testList);
    }

    /*private void setTask(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            //final SendAutomaticallyCovid19ReportController sendAutomaticallyCovid19ReportController = new SendAutomaticallyCovid19ReportController();
            @Override
            public void run() {
                /*
                try {
                    System.out.println("OLA");
                    sendAutomaticallyCovid19ReportController.readFromConfigurationFile();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                 */
                //System.out.println("OLA");
            //}
       // };
        //timer.scheduleAtFixedRate(timerTask, 0,5000);

    //}
}
