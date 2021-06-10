package app.controller;

import app.adapter.SortAlphabetically;
import app.adapter.SortByTin;
import app.adapter.interfaces.Algorithm;
import app.domain.model.Company;
import app.domain.model.users.Client;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.mappers.ClientMapper;
import app.mappers.TestMapper;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;

import java.util.List;
import java.util.Properties;

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
     * Creates an instance of ViewTestsClientController
     */
    public ViewTestsClientController() {
        this(App.getInstance().getCompany());
    }
    /**
     * Creates an instance of ViewTestsClientController receiving the company
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
    private List<ClientDTO>  getCLientslist () {
        tstore = company.getTestStore();
        return clMapper.toDto(tstore.getClientWithTestsValidated());
    }

    public List<ClientDTO> getClientListByTin() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<ClientDTO> list = getCLientslist();

        Properties props = App.getInstance().getProps();
        String algorithm = props.getProperty("Controller.SortByTin.Class");
        Class<?> oClass = Class.forName(algorithm);
        Algorithm sort = (Algorithm) oClass.newInstance();

        return sort.compare(list);
    }

    public List<ClientDTO> getClientsListByAlphabeticalOrder() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<ClientDTO> list = getCLientslist();

        Properties props = App.getInstance().getProps();
        String algorithm = props.getProperty("Controller.SortAlphabetically.Class");
        Class<?> oClass = Class.forName(algorithm);
        Algorithm sort = (Algorithm) oClass.newInstance();

        return sort.compare(list);
    }

    /**
     * It gets a list of tests of a Client
     * @param selectedClient the Client we want to see his tests
     * @return a Dto list of tests of a Client
     */
    public List<TestDTO> getTestsByClient(ClientDTO selectedClient){
        return tmapper.toDto(tstore.getClientTestsList(selectedClient.getPhonenumber()));
    }


}
