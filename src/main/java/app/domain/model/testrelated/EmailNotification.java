package app.domain.model.testrelated;

<<<<<<< HEAD

import app.ui.console.functionalities.Notification;
=======

import app.ui.console.functionalities.Notification;


>>>>>>> 34c31475da197b9d538787e3ef89effb52874241
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the email notification used to notify the customer that the results are available in the app
 * @author Pedro Rocha <1201302@isep.ipp.pt>
 */

public class EmailNotification implements Notification {

    /**
     * Notifies results availability by email
     * @param selectedTest
     */

    public void notification(Test selectedTest) throws IOException {
        String pwd = System.getProperty("user.dir");

        File archive = new File(pwd + "\\src\\main\\notificationsEMAIL");
        if (!archive.exists()) {
            archive.mkdirs();
        }
        File arch = new File(pwd + "\\src\\main\\notificationsEMAIL\\"+ selectedTest.getNhsCode().getCode() + ".txt");

        FileWriter fw = new FileWriter(arch, true);

        try {
            if (arch.exists()) arch.delete();
            fw.write("Sender: noreply@manylabs.com \n");
            fw.write("Recipient: " + selectedTest.getCl().getEmail() + "\n");
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