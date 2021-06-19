package app.domain.store;

import app.domain.model.users.Client;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDTO;
import auth.AuthFacade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class ClientStore implements Serializable {
    /**
     * List of all existing clients in the company.
     */
    private List<Client> clientList;

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
    public Client createClient(ClientDTO cldto, ClientMapper clMapper) {
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

        File archive = new File("Login\\" + cl.getName() + ".txt");
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
            String pwd = generatelogin(cl);
            return clAuthFacade.addUserWithRole(cl.getName(),cl.getEmail(), pwd,"CLIENT");
        }
    }

    /**
     * Get a client through his Tax indentification number
     * @param tin The Tax indentification number of the client we want to get
     * @return The client associated with that Tax indentification number
     */
    public Client getClientbytin(String tin) {
        for (Client cl : clientList) {
            if (cl.getTin().equals(tin)) {
                return cl;
            }
        }
        return null;
    }

    /**
     * It gets the Client by it's email
     * @param email The email of the Client
     * @return The Client if it exists otherwise return null
     */
    public Client getClientByEmail(String email) {
        for (Client cl :clientList ) {
            if (cl.getEmail().equals(email)){
                return cl;
            }
        }
        return null;

    }

    /**
     * It cheks if the Client exists
     * @param client The Client
     * @return true if thr Client exists otherwise return false
     */
    /*
    private boolean clientExists(Client client){
        for (Client cl : clientList){
            if (cl.equals(client)) return true;
        }
        return false;
    }*/

    /**
     *  It updates the name of the Client
     * @param client The Client
     * @param name the name of the Client
     */
    public void updateName(Client client, String name){
        /*if (clientExists(client))*/ client.setName(name);
    }


    /**
     * It updates the sex of the Client
     * @param client the Client
     * @param sex the sex of the Client
     */
    public void updateSex(Client client, String sex){
        /*if (clientExists(client))*/ client.setSex(sex);
    }

    /**
     * It updates the Phone Number of the Client
     * @param client the Client
     * @param phoneNumber the Phone Number of the Client
     */
    public void updatePhoneNumber(Client client, String phoneNumber) {
        /*if (clientExists(client))*/ client.setPhoneNumber(phoneNumber);
    }

    /**
     * It updates the Address of the Client
     * @param client The Client
     * @param address THe Address of the Client you want to update
     */
    public void updateAddress(Client client, String address) {
        /*if (clientExists(client))*/ client.setAddress(address);
    }



}