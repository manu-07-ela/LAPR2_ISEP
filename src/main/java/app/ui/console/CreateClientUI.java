package app.ui.console;

import app.controller.CreateClientController;
import app.mappers.dto.ClientDto;
import app.ui.console.utils.Utils;

import java.io.IOException;

/**
 * Represents an interface with the user to be able to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class CreateClientUI implements Runnable {

    /**
     * Represents a instance of register employee controller
     */
    private CreateClientController createClientctrl;

    /**
     * Initializes the controller
     */
    public CreateClientUI(){
        createClientctrl = new CreateClientController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {
        System.out.printf("%nCreating a new Client%n");
        createClient();
    }

    /**
     * Create an instance of client
     */
    public void createClient() {
        boolean dadosInvalidos=true;
        do {
            try {
                System.out.printf("%nEnter the following data about the Client you want to register%n");

                String name = Utils.readLineFromConsole("Name: ");
                String citizencardnumber = Utils.readLineFromConsole("Citizen card number: ");
                String nhs = Utils.readLineFromConsole("National Healthcare Service number: ");
                String date = Utils.readLineFromConsole("Birth date: ");
                String sex = Utils.readLineFromConsole("Gender: ");
                String tin = Utils.readLineFromConsole("Tax identification number: ");
                String phonenumber = Utils.readLineFromConsole("Phone number: ");
                String email = Utils.readLineFromConsole("E-mail: ");
                ClientDto cldto = new ClientDto(name,citizencardnumber,nhs,date,sex,tin,phonenumber,email);
                createClientctrl.CreateClient(cldto);
                dadosInvalidos = false;
                System.out.printf("Do you want to create a Client with the name %s, citizen card number %s, National Healthcare Service number %s, \n birth date %s, gender %s, phone number %s, and e-mail %s?",name,citizencardnumber,nhs,date,sex,tin,phonenumber,email);

                String resposta = Utils.readLineFromConsole("S/N:");

                if (resposta.equalsIgnoreCase("S")) {
                    if (createClientctrl.saveClient()) {
                        System.out.println("The Client was registered successfully");
                        System.out.println("Your credentials are in the file named:" + cldto.getName());
                    }
                }
            } catch (IllegalArgumentException | IOException e) {
                System.out.printf("%nMessage: %s%n", e.getMessage());
            }
        } while (dadosInvalidos);
    }
}