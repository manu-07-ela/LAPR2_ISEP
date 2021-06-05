package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Test;
import app.domain.model.users.Client;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.mappers.ClientMapper;
import app.mappers.TestParameterMapper;
import app.mappers.dto.ClientDTO;
import auth.domain.model.Email;

import java.util.List;

public class UpdateDataController {

    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of Client Store
     */
    private ClientStore store;
    /**
     * Represents an instance of Client Mapper
     */
    private ClientMapper clMapper;
    /**
     * Representes an instance of Client
     */
    private Client client;


    /**
     * Creates an instance of UpdateDataController
     */
    public UpdateDataController() {
        this(App.getInstance().getCompany());
    }
    /**
     * Creates an instance of UpdateDataController receiving the company
     * @param company The company
     */
    public UpdateDataController(Company company) {
        this.company = company;
        this.store = company.getClientStore();
        this.clMapper = new ClientMapper();
        this.client= null;
    }


    public ClientDTO getUserSession(){
        Email email = company.getAuthFacade().getCurrentUserSession().getEmail();
        client = store.getClientByEmail(email.getEmail());
        return clMapper.toDto(client);
    }

    public List<String> getListOfAttributesAssociatedWithAClient(){
        return client.getListOfAttributesAssociatedWithAClient();
    }

    public  void updateAttribute(String attribute){
        store.updateAttribute(attribute,client);
    }
}
