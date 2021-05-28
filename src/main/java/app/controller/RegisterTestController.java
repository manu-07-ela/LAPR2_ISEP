package app.controller;

import app.controller.App;
import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import app.domain.model.testRelated.*;
import app.domain.model.users.Client;
import app.domain.store.*;
import app.mappers.ClientMapper;
import app.mappers.ParameterCategoryMapper;
import app.mappers.ParameterMapper;
import app.mappers.TestTyperMapper;

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
     * Represents an instance of the parameter category store.
     */
    private TestStore tStore;

    /**
     * Represents an instance of TestType Mapper
     */
    private TestTyperMapper ttmapper;

    private ClientMapper clmapper;

    private ParameterCategoryMapper pmcmapper;

    private ParameterMapper pmmapper;


    public RegisterTestController() {
        this(App.getInstance().getCompany());
    }

    public RegisterTestController(Company company) {
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.tStore=company.getTestStore();
        this.t = null;
        ttmapper = new TestTyperMapper();
        pmcmapper = new ParameterCategoryMapper();
        pmmapper = new ParameterMapper();
        clmapper = new ClientMapper();
    }

    public boolean createTest(Client cl, NhsCode nhscode, TestType testType, List<TestParameter> testParameterList) {
        this.t=tStore.createTest(cl,nhscode,testType,testParameterList);
        return this.tStore.validateTest(t);
    }

    public boolean saveTest() {
        return this.tStore.saveTest(t);
    }

    public Client getClient(String tin){
        ClientStore store = company.getClientStore();
        return store.getClientbytin(tin);
    }

    public List<TestType> getTestTypeList(){
        TestTypeStore store = company.getTestTypeStore();
        return store.getTestTypeList();
    }

    public List<ParameterCategory> getParameterCategoryList(){
        ParameterCategoryStore store = company.getParameterCategoryStore();
        return store.getParameterCategoryList();
    }

    public List<Parameter> getParameterList(){
        ParameterStore store = company.getParameterStore();
        return store.getParameterList();
    }

}
