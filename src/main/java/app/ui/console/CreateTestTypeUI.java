package app.ui.console;

import app.controller.CreateTestTypeController;
import app.ui.console.utils.Utils;

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
    @Override
    public void run(){

        System.out.printf("\nCreating a new test type\n");
        createTestType();

    }

    /**
     *
     */
    public void createTestType(){

        System.out.printf("\nEnter the following data about the type of test you want to create\n");
        String code = Utils.readLineFromConsole("Code: ");
        String description = Utils.readLineFromConsole("Description: ");
        String collectingMethod = Utils.readLineFromConsole("Collecting Method: ");

        Utils.showList(createTestTypectrl.getParameterCategories(),"Choose the category of parameters associated with the test type");

        Utils.selectsObject(createTestTypectrl.getParameterCategories());

    }

}
