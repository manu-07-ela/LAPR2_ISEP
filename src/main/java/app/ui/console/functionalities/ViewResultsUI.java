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

    @Override
    public void run() {
        System.out.printf("%nViewing Test Results%n");
        viewResults();
    }

    public void viewResults(){
        try {
        ClientDTO cl = viewResultsctrl.getUserSession();
        Object option = Utils.showAndSelectOne(viewResultsctrl.getTestList(cl), "Choose to which Test do you want to see the results from");
        }catch(IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n", e.getMessage());
        }
        }
}
