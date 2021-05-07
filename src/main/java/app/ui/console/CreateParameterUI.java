package app.ui.console;

import app.controller.CreateParameterController;
import app.controller.CreateTestTypeController;
import app.ui.console.utils.Utils;

/**
 *
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class CreateParameterUI implements Runnable {

    /**
     *
     */
    private CreateParameterController createParameterCtrl;


    /**
     *
     */
    public CreateParameterUI(){
       createParameterCtrl = new CreateParameterController();
    }

    /**
     *
     */
    @Override
    public void run(){

        System.out.printf("%nCreating a new Parameter%n");
        createTestType();

    }

    /**
     *
     */
    public void createTestType(){

        boolean dadosInvalidos=true;

        do{
            try {
                System.out.printf("%nEnter the following data about the parameter you want to create%n");
                String code = Utils.readLineFromConsole("Code: ");
                String shortName = Utils.readLineFromConsole("Short Name: ");
                String description = Utils.readLineFromConsole("Description: ");

                Utils.showList(createParameterCtrl.getParameterCategories(),"Select the category to insert the Parameter ");
                Utils.selectsObject(createParameterCtrl.getParameterCategories());

            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n" ,e.getMessage());
            }
        } while (dadosInvalidos);
    }

}
