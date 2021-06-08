package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.mappers.*;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
import auth.domain.model.Email;

import java.util.List;

public class ViewResultsController {
    /**
     * Represents an instance of app.
     */
    private App app;
    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of the test store.
     */
    private TestStore tStore;
    /**
     * Represents an instance of the test mapper.
     */
    private TestMapper tmapper;
    /**
     * Represents an instance of Client Store
     */
    private ClientStore clstore;
    /**
     * Represents an instance of Client Mapper
     */
    private ClientMapper clMapper;

    public ViewResultsController() {
        this(App.getInstance().getCompany());
    }

    public ViewResultsController(Company company) {
        this.app = App.getInstance();
        this.company = app.getCompany();
        this.tStore = company.getTestStore();
        this.clstore = company.getClientStore();
        this.clMapper = new ClientMapper();
        this.tmapper = new TestMapper();
    }

    public List<TestDTO> getTestList(ClientDTO cl){
        Client client = clMapper.toModel(cl);
        List<Test> listTest = tStore.getClientTestsList(client);
        return tmapper.toDto(listTest);
    }

    public ClientDTO getUserSession(){
        Email empemail= company.getAuthFacade().getCurrentUserSession().getUserId();
        Client cl = clstore.getClientByEmail(empemail.toString());
        return clMapper.toDto(cl);
    }
}
