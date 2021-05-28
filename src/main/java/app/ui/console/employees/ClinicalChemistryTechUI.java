package app.ui.console.employees;

import app.ui.console.MenuItem;
import app.ui.console.RecordResultsUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClinicalChemistryTechUI implements  Runnable{
    public ClinicalChemistryTechUI(){

    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Record results for a given test", new RecordResultsUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nClinical Chemistry Technologist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }

        } while (option != -1 );
    }
}
