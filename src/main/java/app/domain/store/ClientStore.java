package app.domain.store;

import app.domain.model.Client;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientStore {
    /**
     *
     */
    List<Client> clientList;

    /**
     *
     */
    public ClientStore() {
        clientList = new ArrayList<>();
    }

    /**
     * @param cldto
     * @return
     */
    public Client createClient(ClientDto cldto) {
        return ClientMapper.toModel(cldto);
    }

    /**
     * @param cl
     * @return
     */
    public boolean validateClient(Client cl) {
        if (cl == null)
            return false;
        return !this.clientList.contains(cl);
    }

    /**
     *
     * @param cl
     * @return
     */
    public boolean addClient(Client cl){
        return clientList.add(cl);
    }

    /**
     * @return
     */
    public List<Client> getClientList() {
        return clientList;
    }

    public boolean saveClient(Client cl) {
        if (!validateClient(cl)) {
            return false;
        } else {
            this.clientList.add(cl);
            return true;
        }
    }
}