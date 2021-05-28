package app.ui.console.functionalities;

import app.controller.funcionalites.CreateParameterCategoryController;
import app.ui.console.utils.Utils;



/**
 * Represents an interface with the user to be able to register a new parameter category.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateParameterCategoryUI implements Runnable {

    /**
     * Represents a instance of create parameter category controller.
     */
    private CreateParameterCategoryController createParameterCategoryctrl;

    /**
     * Initializes the controller.
     */
    public CreateParameterCategoryUI(){
        createParameterCategoryctrl = new CreateParameterCategoryController();
    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
        System.out.printf("%nCreating a Parameter Category%n");
        createParameterCategory();

    }

    /**
     * Create an instance of parameter category.
     */
    public void createParameterCategory(){


        boolean dadosInvalidos=true;

        do{
            try{
                System.out.printf("%nEnter the following data about the parameter category you want to create%n");

                String code = Utils.readLineFromConsole("Code: ");

                String name = Utils.readLineFromConsole("Name: ");

                boolean result =createParameterCategoryctrl.createParameterCategory(code,name);
                dadosInvalidos=false;

                if(result){
                    System.out.printf("%nDo you want to create a Parameter Category with the following data:%n%s",createParameterCategoryctrl.toString());

                    boolean confirmation = Utils.confirm("S/N:");

                    if(confirmation) {
                        if (createParameterCategoryctrl.saveParameterCategory()) {
                            System.out.println("The parameter category was created successfully");

                            boolean confirm = Utils.confirm("Do you want to create another one? (S/N)");

                            if (confirm)
                                dadosInvalidos = true;
                        } else {
                            System.out.println("A parameter category with that name or code already exists");
                        }
                    } else {
                        System.out.println("The parameter category has not been created.");
                    }
                } else {
                    System.out.println("A parameter category with that name or code already exists");
                    System.out.println("The parameter category has not been created.");
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("%nMessage: %s%n" ,e.getMessage());
            }
        } while (dadosInvalidos);



    }
}
