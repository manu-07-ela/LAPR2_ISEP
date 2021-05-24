package app.ui.console;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class SpecialistDoctorUI implements Runnable{

    /**
     *
     */
    public SpecialistDoctorUI(){

    }

    /**
     *
     */
    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Write a Report", new CreateMedicalReportUI()));

    }
}
