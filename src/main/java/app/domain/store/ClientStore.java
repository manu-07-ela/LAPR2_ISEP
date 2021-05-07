package app.domain.store;

import app.domain.model.Client;

public class ClientStore {
    public boolean validateClient(Client client){
        if (client == null) {
            return false;
        }
        return true;
    }
//    public Client saveClient(){
//    }
}
