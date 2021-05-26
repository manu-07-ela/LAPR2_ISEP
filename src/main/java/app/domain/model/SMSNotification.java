package app.domain.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the SMS notification used to notify the customer that the results are available in the app
 * @author Pedro Rocha <1201302@isep.ipp.pt>
 */

public class SMSNotification {

    /**
     * Notifies results availability by SMS
     * @param client a client
     */
    public void notifyBySMS(Client client) throws IOException {
        File arch = new File("./"+"SMSNotification_"+ client.getNhs() + ".txt");
        FileWriter fw = new FileWriter(arch, true);

        try {
            if (arch.exists()) arch.delete();
            fw.write("Sender: noreply@manylabs.com \n");
            fw.write("Recipient" + client.getPhonenumber() + "\n");
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