package app.ui.console;

import app.controller.CreateTestTypeController;
import app.mappers.dto.ParameterCategoryDto;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

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

        System.out.printf("%nCreating a new Test Type%n");
        createTestType();

    }

    /**
     *
     */
    public void createTestType(){

        boolean dadosInvalidos=true;

        do{
            try {
                System.out.printf("%nEnter the following data about the Test Type you want to create%n");
                String code = Utils.readLineFromConsole("Code: ");
                String description = Utils.readLineFromConsole("Description: ");
                String collectingMethod = Utils.readLineFromConsole("Collecting Method: ");

                Utils.showList(createTestTypectrl.getParameterCategories(),"Choose the category of parameters associated with the test type");

                List<ParameterCategoryDto> listOfParameterCategories = new ArrayList();
                String resposta;
                do{
                    listOfParameterCategories.add((ParameterCategoryDto) Utils.selectsObject(createTestTypectrl.getParameterCategories()));
                    System.out.printf("%nDo you want to select any more categories?%n");
                    resposta = Utils.readLineFromConsole("S/N:");
                } while (resposta.equalsIgnoreCase("S"));
                createTestTypectrl.createTestType(code,description,collectingMethod,listOfParameterCategories);
                dadosInvalidos = false;
                System.out.printf("Do you want to create a Test Type with the code %s, description %s and collecting method %s",code,description,collectingMethod);

                String answer = Utils.readLineFromConsole("S/N:");

                if(answer.equalsIgnoreCase("S")){
                    if(createTestTypectrl.saveTestType()){
                        System.out.println("The Test Type was created successfully");
                    }
                }
            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n" ,e.getMessage());
            }
        } while (dadosInvalidos);
    }

}
