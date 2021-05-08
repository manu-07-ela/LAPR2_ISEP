package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.store.ClientStore;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;
import auth.AuthFacade;

public class CreateClientController {
    /**
     *
     */
    private Company company;
    /**
     *
     */
    private Client cl;
    /**
     *
     */
    private ClientStore store;
    /**
     *
     */
    private AuthFacade clAuthFacade;
    /**
     *
     */
    private ClientMapper clMapper;

    /**
     *
     */
    public CreateClientController() {
        this(App.getInstance().getCompany());
    }

    /**
     *
     * @param company
     */
    public CreateClientController(Company company) {
        this.company = company;
        this.store = company.getClientStore();
        clAuthFacade = new AuthFacade();
        clMapper = new ClientMapper();
        this.cl = null;
    }

    /**
     *
     * @param cldto
     * @return
     */
    public boolean CreateClient(ClientDto cldto) {
        this.cl = store.createClient(cldto,clMapper);
        return store.validateClient(cl);
    }

    /**
     *
     * @return
     */
    public boolean saveClient() {
        return store.saveClient(cl,clAuthFacade);
    }
}