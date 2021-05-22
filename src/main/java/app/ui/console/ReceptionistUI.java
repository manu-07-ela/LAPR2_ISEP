package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class ReceptionistUI implements Runnable {

    /**
     * Initializes the Receptionist interface
     */
    public ReceptionistUI() {
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register a Client", new CreateClientUI()));
        options.add(new MenuItem("Register a Test to be performed to a registered client", new RegisterTestUI()));

        int option = 0;
    do {
        option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

        if ( (option >= 0) && (option < options.size()))
        {
            options.get(option).run();
        }

    } while (option != -1 );
    }

}
