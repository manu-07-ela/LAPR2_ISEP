package app.ui.console;

import app.controller.CreateParameterController;
import app.domain.model.Parameter;
import app.mappers.dto.ParameterCategoryDto;
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

                ParameterCategoryDto selectedCategoryDto = (ParameterCategoryDto) Utils.showAndSelectOne(createParameterCtrl.getParameterCategories(),"Select the category to insert the Parameter ");

                System.out.printf("%nEnter the following data about the parameter you want to create%n");
                String code = Utils.readLineFromConsole("Code: ");
                String shortName = Utils.readLineFromConsole("Short Name: ");
                String description = Utils.readLineFromConsole("Description: ");

                Parameter parameter = createParameterCtrl.createParameter(code,shortName,description,selectedCategoryDto);

                dadosInvalidos = false;

                System.out.printf("Do you want to create a Parameter with the code %s, short name %s, description: %s in the category %s", code, shortName,description,selectedCategoryDto);

                String answer = Utils.readLineFromConsole("S/N:");

                if(answer.equalsIgnoreCase("S")){

                    if(createParameterCtrl.saveParameter(parameter)){
                        System.out.println("The Parameter was created successfully");
                        String confirm = Utils.readLineFromConsole("Do you want to create another one? (S/N)");
                        if (confirm.equalsIgnoreCase("S"))
                            dadosInvalidos = true;
                    }
                }

            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n",e.getMessage());
            }
        } while (dadosInvalidos);
    }

}
