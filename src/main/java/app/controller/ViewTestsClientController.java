package app.controller;

import app.domain.model.Company;
import app.domain.model.users.Client;
import app.domain.store.ClientStore;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;

import java.util.List;

public class ViewTestsClientController {

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
    public ViewTestsClientController() {
        this(App.getInstance().getCompany());
    }
    /**
     * Creates an instance of UpdateDataController receiving the company
     * @param company The company
     */
    public ViewTestsClientController(Company company) {
        this.company = company;
        this.store = null;
        this.clMapper = new ClientMapper();
        this.client= null;
    }

    public List<ClientDTO>  getCLientslist () {
        store = company.getClientStore();
        return clMapper.toDto(store.getClientList());
    }

    public List<TestDTO> getTestsByClient(ClientDTO selectedClient){
        return  null;
    }


}
