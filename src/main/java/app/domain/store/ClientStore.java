package app.domain.store;

import app.domain.model.Client;
import app.domain.model.ClinicalAnalysisLaboratory;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;
import auth.AuthFacade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public boolean addClient(Client cl) {
        return clientList.add(cl);
    }

    public static String generatelogin(Client cl) throws IOException {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder pwd = new StringBuilder();

            for (int i = 0; i < 10; i++)
            {
                int randomIndex = random.nextInt(chars.length());
                pwd.append(chars.charAt(randomIndex));
            }
            File archive = new File("loginCredentials\\" + cl.getName() + ".txt");
            FileWriter fw = new FileWriter(archive, true);
            fw.write("ID: " + cl.getEmail() + "\n");
            fw.write("PASSWORD: " + pwd.toString() + "\n");
            fw.close();
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
    public boolean saveClient(Client cl,AuthFacade clAuthFacade) throws IOException {
        if (!validateClient(cl)) {
            return false;
        } else {
            clAuthFacade.addUser(cl.getName(),cl.getEmail(), generatelogin(cl));
            this.clientList.add(cl);
            return true;
        }
    }
}