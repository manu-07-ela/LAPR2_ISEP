package app.domain.store;

import app.domain.model.Client;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;
import auth.AuthFacade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class ClientStore {
    /**
     * List of all existing clients in the company.
     */
    List<Client> clientList;

    /**
     * Instantiates a new ClientStore.
     */
    public ClientStore() {
        clientList = new ArrayList<>();
    }

    /**
     * Creates an instance of Client receiving a Client DTO and Client Mapper by parameter
     * @param cldto a client DTO
     * @param clMapper a instance of Client Mapper
     * @return an instance of Client
     */
    public Client createClient(ClientDto cldto, ClientMapper clMapper) {
        return clMapper.toModel(cldto);
    }

    /**
     * Global validation of a Client
     * @param cl Client that we intend to validate
     * @return false if the client already exists or is null. Otherwise, it returns true.
     */
    public boolean validateClient(Client cl) {
        if (cl == null)
            return false;
        return !this.clientList.contains(cl);
    }

    /**
     * Adds a new client to the List
     * @param cl Client we want to add to the List.
     * @return true if the client is added to the List, false otherwise.
     */
    public boolean addClient(Client cl) {
        return clientList.add(cl);
    }

    /**
     * Registers a client into the system
     * @param cl a client
     * @return True if the client has been registered, false otherwise
     */
    public static String generatelogin(Client cl) throws IOException {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder pwd = new StringBuilder();

        File archive = new File("loginCredentials\\" + cl.getName() + ".txt");
        FileWriter fw = new FileWriter(archive, true);

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(chars.length());
            pwd.append(chars.charAt(randomIndex));
        }
        try {
            fw.write("ID: " + cl.getEmail() + "\n");
            fw.write("PASSWORD: " + pwd.toString() + "\n");
        } catch (IOException e) {
        }finally {
            fw.close();
        }
        return pwd.toString();
    }

    /**
     * Get the existing clients
     * @return The list of clients
     */
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Saves the client sent as parameter
     * @param cl a client
     * @param clAuthFacade a instance of Auth Facade
     * @return True if the employee has been transformed into a user of the system, false otherwise
     */
    public boolean saveClient(Client cl,AuthFacade clAuthFacade) throws IOException {
        if (!validateClient(cl)) {
            return false;
        } else {
            this.clientList.add(cl);
            return clAuthFacade.addUser(cl.getName(),cl.getEmail(), generatelogin(cl));
        }
    }
}