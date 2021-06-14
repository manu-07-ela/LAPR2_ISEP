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
       Date initialDate = null;
       Date endDate = null;
       try {
           initialDate = formatter.parse(initial);
           endDate = formatter.parse(end);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       overviewController.getIntervalTestList(initialDate, endDate);
       System.out.printf("Number of clients: %d" , overviewController.getNumberOfClients());

    }

}
