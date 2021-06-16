package app.ui.console.employees;

import app.ui.console.MenuItem;
import app.ui.console.functionalities.ImportFileUI;
import app.ui.console.functionalities.OverviewUi;
import app.ui.console.functionalities.ValidateWorkUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the interface where the Lab Coordinator validates the work done by the clinical chemistry technologist and specialist doctor.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class LabCoordinatorUI implements Runnable{

    /**
     * Initializes the Lab Coordinator Interface.
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
        options.add(new MenuItem("Oveview",new OverviewUi()));
        options.add(new MenuItem("Import clinical tests from a CSV file", new ImportFileUI()));

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
