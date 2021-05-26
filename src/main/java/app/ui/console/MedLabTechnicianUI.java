package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MedLabTechnicianUI implements Runnable{
    public MedLabTechnicianUI(){

    }
    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Record samples for a given test", new RecordSampleUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMed Lab Technician Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }

        } while (option != -1 );
    }
}
