package app.controller;

import app.domain.model.Company;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.ClientMapper;
import app.mappers.TestMapper;
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
    private TestStore tstore;
    /**
     * Represents an instance of Client Mapper
     */
    private ClientMapper clMapper;
    /**
     * Representes an instance of Client
     */
    private Client client;
    /**
     * Represents an instance of the test mapper.
     */
    private TestMapper tmapper;

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
        this.tstore = null;
        this.clMapper = new ClientMapper();
        this.client= null;
    }

    /**
     * It gets a list of Clients with at least one test validated
     * @return a Dto list of Clients with at least one test validated
     */
    public List<ClientDTO>  getCLientslist () {
        tstore = company.getTestStore();
        return clMapper.toDto(tstore.getClientWithTestsValidated());
    }

    /**
     * It gets a list of tests of a Client
     * @param selectedClient the Client we want to see his tests
     * @return a Dto list of tests of a Client
     */
    public List<TestDTO> getTestsByClient(ClientDTO selectedClient){
        return tmapper.toDto(tstore.getClientTestsList(selectedClient.getPhoneNumber()));
    }


}
