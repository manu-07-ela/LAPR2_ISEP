package app.ui.console;

import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the interface where the Laboratory Coordinator validates the work done by the clinical chemistry technologist and specialist doctor.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class LabCoordinatorUI implements Runnable{

    /**
     * Initializes the Specialist Doctor Interface.
     */
    public LabCoordinatorUI(){

    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Validate Work", new ValidateWorkUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nLab Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }

        } while (option != -1 );

    }
}
