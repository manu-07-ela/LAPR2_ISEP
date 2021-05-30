package app.domain.model.testrelated;

import app.adapter.interfaces.Notification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the SMS notification used to notify the customer that the results are available in the app
 * @author Pedro Rocha <1201302@isep.ipp.pt>
 */

public class SMSNotification implements Notification {

    /**
     * Notifies results availability by SMS
     * @param selectedTest
     */
    public void notification(Test selectedTest) throws IOException {
        String pwd = System.getProperty("user.dir");

        File archive = new File(pwd + "\\src\\main\\notificationsSMS");
        if (!archive.exists()) {
            archive.mkdirs();
        }
        File arch = new File(pwd + "\\src\\main\\notificationsSMS\\"+ selectedTest.getCl().getNhs() + ".txt");
        FileWriter fw = new FileWriter(arch, true);

        try {
            if (arch.exists()) arch.delete();
            fw.write("Sender: +44 1980 301 565 \n");
            fw.write("Recipient" + selectedTest.getCl().getPhonenumber() + "\n");
            fw.write("Dear Client, \n");
            fw.write("The results are available in the central application, you must access them. \n");
            fw.write("\nMany Labs");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
}