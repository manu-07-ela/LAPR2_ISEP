package app.domain;


import app.domain.model.users.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateDataNotification{
    public void notification(Client client, String newAtributte, String atributte, String oldAtributte) throws IOException {
        String pwd = System.getProperty("user.dir");

        File archive = new File(pwd + "\\src\\main\\notificationsEMAIL");
        if (!archive.exists()) {
            archive.mkdirs();
        }
        File arch = new File(pwd + "\\src\\main\\notificationsEMAIL\\UpdateData" + client.getTin()+ ".txt");

        FileWriter fw = new FileWriter(arch, true);

        try {
            if (arch.exists()) arch.delete();
            fw.write("Sender: noreply@manylabs.com \n");
            fw.write("Recipient: " + client.getEmail() + "\n");
            fw.write("Subject matter: Update personal data");
            fw.write("Dear Client, \n");
            fw.write("Your "+atributte+" was updated.\n");
            fw.write("Old "+atributte+": "+oldAtributte+"\n");
            fw.write("New "+atributte+": "+newAtributte+"\n");
            fw.write("Many Labs\n");
        } catch (
                IOException e){
            e.printStackTrace();
        } finally {
            fw.close();
        }

    }


}
