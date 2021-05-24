package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.*;
import app.mappers.ClientMapper;
import app.mappers.ParameterCategoryMapper;
import app.mappers.ParameterMapper;
import app.mappers.TestTyperMapper;
import app.mappers.dto.ClientDto;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestTypeDTO;

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

    public boolean createTest(Client cl, String nhscode) {
        this.t=tStore.createTest(cl,nhscode);
        return this.tStore.validateTest(t);
    }

    public boolean saveTest() {
        return this.tStore.saveTest(t);
    }

    public List<ClientDto> getClientList(){
        ClientStore store = company.getClientStore();
        return clmapper.toDto(store.getClientList());
    }

    public List<TestTypeDTO> getTestTypeList(){
        TestTypeStore store = company.getTestTypeStore();
        return ttmapper.toDTO(store.getTestTypeList());
    }
    public List<ParameterCategoryDto> getParameterCategoryList(){
        ParameterCategoryStore store = company.getParameterCategoryStore();
        return pmcmapper.toDto(store.getParameterCategoryList());
    }
    public List<ParameterDTO> getParameterList(){
        ParameterStore store = company.getParameterStore();
        return pmmapper.toDto(store.getParameterList());
    }

}
