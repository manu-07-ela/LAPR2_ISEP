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
     * Represents an instance of Client
     */
    private Client client;



    /**
     * Creates an instance of UpdateDataController
     */
    public UpdateDataController() {
        this.company = App.getInstance().getCompany();
        this.store = company.getClientStore();
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

    /**
     * It gets the Client logged in
     * @return the Client logged in
     */
    public ClientDTO getUserSession(){
        Email email = company.getAuthFacade().getCurrentUserSession().getEmail();
        client = store.getClientByEmail(email.getEmail());
        return clMapper.toDto(client);
    }


    /**
     * It updates the name of the Client
     * @param name the name of the Client
     */
    public void updateName(Client client, String name){
        store.updateName(client, name);
    }

    /**
     * It updates the sex of the Client
     * @param sex the sex of the Client
     */
    public  void updateSex(Client client, String sex){
        store.updateSex(client, sex);
    }


    /**
     * It updates the Phone Number of the Client
     * @param phoneNumber the Phone Number of the Client
     */
    public void updatePhoneNumber (Client client, String phoneNumber){store.updatePhoneNumber(client, phoneNumber);}

    /**
     * It updates the Address of the Client
     * @param client The Client
     * @param address The address of the Client you want to update
     */
    public void updateAddress (Client client, String address){store.updateAddress(client, address);}

    /**
     * Get a client by his email
     * @param email the client email
     * @return the client associated with the email
     */
    public Client getClientByEmail(String email){
       return store.getClientByEmail(email);
    }
}
