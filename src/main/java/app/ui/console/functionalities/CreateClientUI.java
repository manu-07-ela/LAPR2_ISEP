package app.ui.console.functionalities;

import app.controller.CreateClientController;
import app.mappers.dto.ClientDTO;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Represents an interface with the user to be able to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class CreateClientUI implements Runnable {

    /**
     * Represents a instance of register client controller
     */
    private final CreateClientController createClientctrl;

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
                ClientDTO cldto;
                System.out.printf("%nEnter the following data about the Client you want to register%n");

                String name = Utils.readLineFromConsole("Name: ");
                String citizencardnumber = Utils.readLineFromConsole("Citizen card number: ");
                assert citizencardnumber != null;
                if (citizencardnumber.length()!=16){
                    citizencardnumber=String.format("%0"+ (16 - citizencardnumber.length() )+"d%s",0 ,citizencardnumber);
                }
                String nhs = Utils.readLineFromConsole("National Healthcare Service number: ");
                String date = Utils.readLineFromConsole("Birth date: ");
                String sex = Utils.readLineFromConsole("Gender: ");
                String tin = Utils.readLineFromConsole("Tax identification number: ");
                String phonenumber = Utils.readLineFromConsole("Phone number: ");
                String email = Utils.readLineFromConsole("E-mail: ");
                String address = Utils.readLineFromConsole("Address: ");
                if(sex==null){
                    cldto = new ClientDTO(name, citizencardnumber, nhs, date,tin, phonenumber, email, address);
                }else {
                    cldto = new ClientDTO(name, citizencardnumber, nhs, date, sex, tin, phonenumber, email, address);
                }
                createClientctrl.CreateClient(cldto);
                dadosInvalidos = false;
                System.out.printf("%nDo you want to create a Client with this data?%n");
                System.out.println(cldto.toString());
                String resposta = Utils.readLineFromConsole("S/N:");

                if (resposta.equalsIgnoreCase("S")) {
                    if (createClientctrl.saveClient()) {
                        System.out.println("The Client was registered successfully");
                        System.out.println("Your credentials are in the file named: " + cldto.getName());
                    }else{
                        System.out.println("There is a Client already registered with that data");
                    }
                }
            } catch (IllegalArgumentException | IOException e) {
                System.out.printf("%nMessage: %s%n", e.getMessage());
            }
        } while (dadosInvalidos);
    }
}