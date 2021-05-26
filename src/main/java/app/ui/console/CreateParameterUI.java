package app.ui.console;

import app.controller.CreateParameterController;
import app.mappers.dto.ParameterCategoryDtoTest;
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
        if(createParameterCtrl.getParameterCategories().size() == 0){
            System.out.println("To proceed with the creation of the parameter, you must first create a parameter category.");
        } else {
            System.out.printf("%nCreating a new Parameter%n");
            createParameter();
        }
    }

    /**
     *
     */
    public void createParameter(){

        boolean dadosInvalidos=true;

        do{
            try {

                Utils.showList(createParameterCtrl.getParameterCategories(),"Select the category to insert the Parameter ");
                Object option = Utils.selectsObject(createParameterCtrl.getParameterCategories());
                if (option == null){
                    throw new IllegalArgumentException("There must be at least one parameter category associated.");
                }
                ParameterCategoryDtoTest selectedCategoryDto = (ParameterCategoryDtoTest) option;
                System.out.printf("%nEnter the following data about the parameter you want to create%n");
                String code = Utils.readLineFromConsole("Code: ");
                String shortName = Utils.readLineFromConsole("Short Name: ");
                String description = Utils.readLineFromConsole("Description: ");

                Boolean result = createParameterCtrl.createParameter(code,shortName,description,selectedCategoryDto);

                dadosInvalidos = false;

                if(result) {

                    System.out.printf("Do you want to create a Parameter with the code %s, short name %s, description: %s in the category %s", code, shortName, description, selectedCategoryDto);

                    String answer = Utils.readLineFromConsole("S/N:");

                    if (answer.equalsIgnoreCase("S")) {
                        if (createParameterCtrl.saveParameter()) {
                            System.out.println("The Parameter was created successfully");

                            String confirm = Utils.readLineFromConsole("Do you want to create another one? (S/N)");

                            if (confirm.equalsIgnoreCase("S"))
                                dadosInvalidos = true;
                        } else {
                            System.out.println("The Parameter has not been created.");
                        }
                    }
                } else {
                    System.out.println("There's already a Parameter with that code in the System. The Parameter has not been created.");
                }

            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n",e.getMessage());
            }
        } while (dadosInvalidos);
    }

}
