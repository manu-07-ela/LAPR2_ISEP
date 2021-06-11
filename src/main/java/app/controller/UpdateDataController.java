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
     * It updates the Birth Date of the Client
     * @param birthDate the Birth Date
     */
    public  void updateBirthDate(String birthDate){
        store.updateBirthDate(client, birthDate);
    }

    /**
     * It updates the Citizen Card Number of the Client
     * @param citizenCard the Citizen Card Number of the Client
     */
    public  void updateCitizenCard(String citizenCard){
        store.updateCitizenCard(client, citizenCard);
    }

    /**
     * It updates the email of the Client
     * @param email the email of the Client
     */
    public  void updateEmail(String email){
        store.updateEmail(client, email);
    }

    /**
     * It updates the name of the Client
     * @param name the name of the Client
     */
    public  void updateName(String name){
        store.updateName(client, name);
    }

    /**
     * It updates the NHS Code of the Client
     * @param nhsCode the NHS Code of the Client
     */
    public  void updateNhsCode(String nhsCode){
        store.updateNhsCode(client, nhsCode);
    }

    /**
     * It updates the sex of the Client
     * @param sex the sex of the Client
     */
    public  void updateSex(String sex){
        store.updateSex(client, sex);
    }

    /**
     * It updates the TIN of the Client
     * @param tin the TIN of the Client
     */
    public  void updateTin(String tin){
        store.updateTin(client, tin);
    }

    /**
     * It updates the Phone Number of the Client
     * @param phoneNumber the Phone Number of the Client
     */
    public void updatePhoneNumber (String phoneNumber){store.updatePhoneNumber(client, phoneNumber);}
    public void  clientData(){
        System.out.println(client);
    }
}
