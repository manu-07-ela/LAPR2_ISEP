package app.domain.model.testRelated;

import app.domain.model.users.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the email notification used to notify the customer that the results are available in the app
 * @author Pedro Rocha <1201302@isep.ipp.pt>
 */

public class EmailNotification {

    /**
     * Notifies results availability by email
     * @param client a client
     */
    public void notifyByEmail(Client client) throws IOException {
        File arch = new File("./" + "EmailNotification_"+ client.getNhs() + ".txt");
        FileWriter fw = new FileWriter(arch, true);

        try {
            if (arch.exists()) arch.delete();
            fw.write("Sender: noreply@manylabs.com \n");
            fw.write("Recipient" + client.getEmail() + "\n");
            fw.write("Subject matter: Results are available ");
            fw.write("Dear Client, \n");
            fw.write("The results are available in the central application, you must access them.");
            fw.write("Many Labs");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
}