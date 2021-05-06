package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.ui.console.utils.Utils;



/**
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateParameterCategoryUI implements Runnable {

    /**
     *
     */
    private CreateParameterCategoryController createParameterCategoryctrl;

    /**
     *
     */
    public CreateParameterCategoryUI(){
        createParameterCategoryctrl = new CreateParameterCategoryController();
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.printf("%nCreating a new Parameter Category%n");
        createParameterCategory();

    }

    public void createParameterCategory(){

        System.out.printf("%nEnter the following data about the parameter category you want to create%n");

        String code = Utils.readLineFromConsole("Code: ");
        String name = Utils.readLineFromConsole("Name: ");

        createParameterCategoryctrl.createParameterCategory(code,name);

        System.out.printf("Do you want to create a Parameter Category with the code %s and name %s",code,name);

        String resposta = Utils.readLineFromConsole("S/N:");

        if(resposta.equalsIgnoreCase("S")){
            if(createParameterCategoryctrl.saveTestType()){
                System.out.println("The parameter category was created successfully");
            }
        }

    }
}
