package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.store.ClientStore;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;
import auth.AuthFacade;

import java.io.IOException;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class CreateClientController {
    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of client
     */
    private Client cl;
    /**
     * Represents an instance of the client store
     */
    private ClientStore store;
    /**
     * Represents an instance Auth facade
     */
    private AuthFacade clAuthFacade;
    /**
     * Represents an instance of the client mapper
     */
    private ClientMapper clMapper;

    /**
     * Constructs an instance of {@code CreateClientController}
     */
    public CreateClientController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructs an instance of {@code CreateClientController} receiving a company
     * @param company The company
     */
    public CreateClientController(Company company) {
        this.company = App.getInstance().getCompany();
        this.store = company.getClientStore();
        clAuthFacade = company.getAuthFacade();
        clMapper = new ClientMapper();
        this.cl = null;
    }

    /**
     * Create a client by receiving a client DTO as a parameter
     * @param cldto The client DTO
     * @return the client
     */
    public boolean CreateClient(ClientDto cldto) {
        this.cl = store.createClient(cldto,clMapper);
        return store.validateClient(cl);
    }

    /**
     * Saves the client
     * @return True if the client is saved in the client store, false otherwise
     */
    public boolean saveClient() throws IOException {
        return store.saveClient(cl,clAuthFacade);
    }
}