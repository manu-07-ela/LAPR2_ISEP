package app.controller;

import app.domain.store.ClientStore;
import app.interfaces.SortingAlgorithms;
import app.domain.model.Company;
import app.domain.model.users.Client;
import app.domain.store.TestStore;
import app.mappers.ClientMapper;
import app.mappers.TestMapper;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;

import java.util.*;

public class SeeTestsController {

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
     * Represents an instance of Client
     */
    private Client client;
    /**
     * Represents an instance of the test mapper.
     */
    private TestMapper tmapper;

    /**
     * Represents an instance of the client store.
     */
    private ClientStore clientStore;

    /**
     * Creates an instance of ViewTestsClientController
     */
    public SeeTestsController() {
        this.company = App.getInstance().getCompany();
        this.tstore = company.getTestStore();
        this.clMapper = new ClientMapper();
        this.clientStore = company.getClientStore();
        this.tmapper = new TestMapper();

    }
    /**
     * Creates an instance of ViewTestsClientController receiving the company
     * @param company The company
     */
    public SeeTestsController(Company company) {
        this.company = company;
        this.tstore = new TestStore();
        this.clMapper = new ClientMapper();
        this.tmapper = new TestMapper();
        this.client= null;
    }

    /**
     * It gets a list of Clients with at least one test validated
     * @return a Dto list of Clients with at least one test validated
     */
    public List<ClientDTO> getClientList() {
        tstore = company.getTestStore();
        return clMapper.toDto(tstore.getClientWithTestsValidated());
    }

    /**
     * Sort the list of clients by Tin
     * @return the ordered list
     * @throws ClassNotFoundException if it is not possible to instantiate the desired class
     * @throws IllegalAccessException if the object we intend to create it's not  correctly
     * @throws InstantiationException if we can't instantiate an object
     */
    public List<ClientDTO> getClientListByTin() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<ClientDTO> list = getClientList();

        Properties props = App.getInstance().getProps();
        String algorithm = props.getProperty("Controller.SortByTin.Class");
        Class<?> oClass = Class.forName(algorithm);
        SortingAlgorithms sort = (SortingAlgorithms) oClass.newInstance();

        return sort.orderClientList(list);
    }

    /**
     * Sort the client list alphabetically
     * @return the ordered list
     * @throws ClassNotFoundException if it is not possible to instantiate the desired class
     * @throws IllegalAccessException if the object we intend to create it's not  correctly
     * @throws InstantiationException if we can't instantiate an object
     */
    public List<ClientDTO> getClientsListByAlphabeticalOrder() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<ClientDTO> list = getClientList();

        Properties props = App.getInstance().getProps();
        String algorithm = props.getProperty("Controller.SortAlphabetically.Class");

        Class<?> oClass = Class.forName(algorithm);
        SortingAlgorithms sort = (SortingAlgorithms) oClass.newInstance();

        return sort.orderClientList(list);
    }

    /**
     * It gets a list of tests of a Client
     * @param selectedClient the Client we want to see his tests
     * @return a Dto list of tests of a Client
     */
    public List<TestDTO> getAssociatedWithClient(ClientDTO selectedClient){
        return tmapper.toDto(tstore.getTestListAssociatedWithClient(selectedClient));
    }


}
