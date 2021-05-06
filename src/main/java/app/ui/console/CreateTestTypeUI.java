package app.ui.console;

import app.controller.CreateTestTypeController;

/**
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateTestTypeUI implements Runnable {

    /**
     *
     */
    private CreateTestTypeController createTestTypectrl;

    /**
     *
     */
    public CreateTestTypeUI(){
        createTestTypectrl = new CreateTestTypeController();
    }

    /**
     *
     */
    public void run(){

        System.out.printf("\nCreating a new test type\n");

    }

}
