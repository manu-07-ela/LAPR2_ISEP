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
     * Representes an instance of Client
     */
    private Client client;
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
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.tStore=company.getTestStore();
    }
    public List<TestDTO> getTestList(ClientDTO cl){
        List<Test> listTest = tStore.getClientTestsList(cl);
        return tmapper.toDto(listTest);
    }
    public ClientDTO getUserSession(){
        Email email = company.getAuthFacade().getCurrentUserSession().getEmail();
        client = clstore.getClientByEmail(email.getEmail());
        return clMapper.toDto(client);
    }
}
