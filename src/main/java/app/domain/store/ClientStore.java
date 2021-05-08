package app.domain.store;

import app.domain.model.Client;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;
import auth.AuthFacade;

import java.security.SecureRandom;
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
    public Client createClient(ClientDto cldto, ClientMapper clMapper) {
        return clMapper.toModel(cldto);
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
        public static String generatepwd() {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder pwd = new StringBuilder();

            for (int i = 0; i <= 20; i++)
            {
                int randomIndex = random.nextInt(chars.length());
                pwd.append(chars.charAt(randomIndex));
            }
            return pwd.toString();
        }

    /**
     * @return
     */
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     *
     * @param cl
     * @param clAuthFacade
     * @return
     */
    public boolean saveClient(Client cl,AuthFacade clAuthFacade) {
        if (!validateClient(cl)) {
            return false;
        } else {
            clAuthFacade.addUser(cl.getName(),cl.getEmail(),generatepwd());
            this.clientList.add(cl);
            return true;
        }
    }
}