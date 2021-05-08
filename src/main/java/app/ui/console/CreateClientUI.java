package app.ui.console;

import app.controller.CreateClientController;
import app.ui.console.utils.Utils;

public class CreateClientUI {

    private CreateClientController createClientctrl;

    public CreateClientUI(){
        createClientctrl = new CreateClientController();
    }

    public void run() {
        System.out.printf("%nCreating a new Client%n");
        createClient();
    }

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
                createClientctrl.CreateClient();
                dadosInvalidos = false;
                System.out.printf("Do you want to create a Client with the name %s, citizen card number %s, National Healthcare Service number %s, birth date %s, gender %s, phone number %s, and e-mail %s?",name,citizencardnumber,nhs,date,sex,tin,phonenumber,email);

                String resposta = Utils.readLineFromConsole("S/N:");

                if (resposta.equalsIgnoreCase("S")) {
                    if (createClientctrl.saveClient()) {
                        System.out.println("The Client was registered successfully");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("%nMessage: %s%n", e.getMessage());
            }
        } while (dadosInvalidos);
    }
}
