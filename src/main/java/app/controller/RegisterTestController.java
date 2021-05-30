package app.controller;

import app.domain.model.Company;
import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.*;
import app.domain.model.users.Client;
import app.domain.store.*;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.ParameterCategoryMapper;
import app.mappers.ParameterMapper;
import app.mappers.TestTyperMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class RegisterTestController {
    /**
     * Represents an instance of app.
     */
    private App app;
    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of test
     */
    private Test t;
    /**
     * Represents an instance of the test store.
     */
    private TestStore tStore;

    /**
     * Represents an instance of the Test Type store.
     */
    private TestTypeStore ttStore;

    /**
     * Represents an instance of the parameter category store.
     */
    private ParameterCategoryStore pmcStore;

    /**
     * Represents an instance of the parameter store.
     */
    private ParameterStore pmStore;

    /**
     * Represents an instance of the Clinical Analysis Laboratory store.
     */
    private ClinicalAnalysisLaboratoryStore labStore;

    /**
     * Represents an instance of the test mapper.
     */
    private TestTyperMapper ttmapper;

    /**
     * Represents an instance of the parameter category mapper.
     */
    private ParameterCategoryMapper pmcmapper;

    /**
     * Represents an instance of the parameter mapper.
     */
    private ParameterMapper pmmapper;

    /**
     * Represents an instance of the Clinical Analysis Laboratory mapper.
     */
    private CreateClinicalAnalysisLaboratoryMapper labmapper;
    
    /**
     * Constructs an instance of {@code RegisterTestController}
     */
    public RegisterTestController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructs an instance of {@code RegisterTestController} receiving a company
     * @param company The company
     */
    public RegisterTestController(Company company) {
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.tStore=company.getTestStore();
        this.ttStore=company.getTestTypeStore();
        this.pmStore = company.getParameterStore();
        this.pmcStore = company.getParameterCategoryStore();
        this.labStore = company.getClinicalAnalysisLaboratoryStore();
        this.t = null;
        ttmapper = new TestTyperMapper();
        pmmapper = new ParameterMapper();
        pmcmapper = new ParameterCategoryMapper();
        labmapper = new CreateClinicalAnalysisLaboratoryMapper();
    }

    /**
     * Create a test by receiving a client, nhscode, testType, testParameterList, lab as parameter
     * @param cl the client associated with the test
     * @param nhscode the clients nhscode
     * @param testType the client testtype DTO
     * @param ParameterList the ParameterDTO List 
     * @param lab the lab where the receptionist is working
     * @return false if the test already exists or is null. Otherwise, it returns true.
     */
    public boolean createTest(Client cl, NhsCode nhscode, TestTypeDTO testType, List<ParameterDTO> ParameterList, ClinicalAnalysisLaboratoryDTO lab) {
        List<TestParameter> listpm = new ArrayList<>();
        listpm = addParameter(pmmapper.toModel(ParameterList),listpm);
        this.t=tStore.createTest(cl,nhscode,ttmapper.toModel(testType),listpm,labmapper.toModel(lab));
        return this.tStore.validateTest(t);
    }

    /**
     * Fills a list of the type TestParameter
     * @param pm A list of parameters
     * @param listpm A list of Test parameters
     * @return A list of Test parameters
     */
    public List<TestParameter> addParameter(List<Parameter> pm, List<TestParameter> listpm){
        for (Parameter param : pm) {
            TestParameter tpm = new TestParameter(param);
            listpm.add(tpm);
        }
        return listpm;
    }

    /**
     * Save the test case it is in a valid state.
     * @return true if the test was saved. Otherwise, false.
     */
    public boolean saveTest() {
        return this.tStore.saveTest(t);
    }

    /**
     * Get a String with Tax identification
     * @return a Client
     */
    public Client getClient(String tin){
        ClientStore store = company.getClientStore();
        return store.getClientbytin(tin);
    }

    /**
     * Get a list of objects of type TestType
     * @return list with Test types
     */
    public List<TestTypeDTO> getTestTypeList(){
        List<TestType> listTestType = ttStore.getTestTypeList();
        return ttmapper.toDTO(listTestType);
    }

    /**
     * Get a list of objects of type ParameterCategory
     * @return list with parameter Categories
     */
    public List<ParameterCategoryDTO> getParameterCategoryList(){
        List<ParameterCategory> listParameterCategories = pmcStore.getParameterCategoryList();
        return pmcmapper.toDto(listParameterCategories);
    }

    /**
     * Get a list of objects of type Parameter
     * @return list with parameters
     */
    public List<ParameterDTO> getParameterList(){
        List<Parameter> listParameter = pmStore.getParameterList();
        return pmmapper.toDto(listParameter);
    }

    /**
     * Get a list of objects of type ClinicalAnalysisLaboratory
     * @return list with Clinical Analysis Laboratories
     */
    public List<ClinicalAnalysisLaboratoryDTO> getLaboratoryList(){
        List<ClinicalAnalysisLaboratory> listClinicalAnalysisLaboratory = labStore.getClinicalAnalysisLaboratoryList();
        return labmapper.toDto(listClinicalAnalysisLaboratory);
    }
}
