package app.ui.console.functionalities;

import app.controller.ViewTestsClientController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.ParameterDTO;

import java.util.ArrayList;
import java.util.List;

public class ViewTestsClientUI implements Runnable{

    /**
     * Represents a instance of ViewTestsClientController
     */
    private final ViewTestsClientController viewTestsctrl;

    public ViewTestsClientUI() {
        viewTestsctrl = new ViewTestsClientController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {
        viewtestsclient();
    }

    public void viewtestsclient(){
        List<ClientDTO> clist = new ArrayList<>();
        clist=viewTestsctrl.getCLientslist();
        System.out.println("Do you want to order the clients list by Tax identification number or by Name?");
    }
}
