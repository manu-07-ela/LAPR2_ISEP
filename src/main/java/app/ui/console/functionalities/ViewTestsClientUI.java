package app.ui.console.functionalities;

import app.controller.ViewTestsClientController;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.ParameterDTO;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
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
        try {
            viewtestsclient();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void viewtestsclient() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        List<ClientDTO> clist = new ArrayList<>();

        List<String>  sortlist  = new ArrayList(Arrays.asList("Tin","Name"));
        String choice = (String) Utils.showAndSelectOne(sortlist,"Do you want to order the clients list by Tax identification number or by Name?");
        if (choice.equals("Tin")){
            clist=viewTestsctrl.getClientListByTin();
        }else if (choice.equals("Name")){
            clist=viewTestsctrl.getClientsListByAlphabeticalOrder();
        }

        for (ClientDTO cl : clist) {
            System.out.println(cl);
        }
    }
}
