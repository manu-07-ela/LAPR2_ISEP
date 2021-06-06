package app.ui.console.functionalities;


import app.controller.ViewResultsController;
import app.mappers.dto.ClientDTO;
import app.ui.console.utils.Utils;

public class ViewResultsUI implements Runnable{

    /**
     * Represents a instance of view results controller
     */
    private final ViewResultsController viewResultsctrl;

    public ViewResultsUI(){
        viewResultsctrl = new ViewResultsController();
    }

    public void run() {
        System.out.printf("%nViewing Test Results%n");
    }
    public void viewResults(){
        ClientDTO cl = viewResultsctrl.getUserSession();
        Object option = Utils.showAndSelectOne(viewResultsctrl.getTestList(cl), "Choose what kind of Test Type should be registered");
    }
}
