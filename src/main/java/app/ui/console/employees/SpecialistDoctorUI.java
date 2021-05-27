package app.ui.console.employees;

import app.ui.console.MenuItem;
import app.ui.console.WriteMedicalReportUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the interface where the specialist doctor selects what he wants to accomplish.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class SpecialistDoctorUI implements Runnable{

    /**
     * Initializes the Specialist Doctor Interface.
     */
    public SpecialistDoctorUI(){

    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Write a Report", new WriteMedicalReportUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nSpecialist Doctor Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }

        } while (option != -1 );

    }
}
