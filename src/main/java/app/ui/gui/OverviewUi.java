package app.ui.gui;

import app.controller.OverviewController;
import app.mappers.dto.TestDTO;
import app.ui.console.utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OverviewUi implements Runnable{

    /**
     * Represents a instance of write medical report controller.
     */
    private OverviewController overviewController;

    /**
     * Initializes the Write Medical Report Interface and the controller.
     */
    public OverviewUi(){
        overviewController = new OverviewController();
    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
       String initial = Utils.readLineFromConsole("Initial Date: ");
       String end = Utils.readLineFromConsole("End Date: ");
       try {
           Date initialDate = formatter.parse(initial);
           Date endDate = formatter.parse(end);
           overviewController.getIntervalTestList(initialDate, endDate);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       System.out.printf("Number of clients: %d\n" , overviewController.getNumberOfClients());
       System.out.printf("Number Of Tests Waiting For Results: %d\n" , overviewController.getNumberOfTestsWaitingForResults());
       System.out.printf("Number Of Tests Waiting For Diagnosis: %d\n" , overviewController.getNumberOfTestsWaitingForDiagnosis());

    }

}
