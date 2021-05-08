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

        System.out.printf("%nCreating a Test Type%n");
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
                boolean resposta;
                do{
                    ParameterCategoryDto pcDto = (ParameterCategoryDto) Utils.selectsObject(createTestTypectrl.getParameterCategories());
                    if (!listOfParameterCategories.contains(pcDto)){
                        listOfParameterCategories.add(pcDto);
                    }
                    System.out.printf("%nDo you want to select any more categories?%n");
                    resposta = Utils.confirm("S/N:");
                } while (resposta);

                boolean result = createTestTypectrl.createTestType(code,description,collectingMethod,listOfParameterCategories);
                dadosInvalidos = false;

                if(result){

                    System.out.printf("%nDo you want to create a Test Type with the following data:%n%s",createTestTypectrl.toString());

                    String answer = Utils.readLineFromConsole("S/N:");

                    if(answer.equalsIgnoreCase("S")){
                        if(createTestTypectrl.saveTestType()){
                            System.out.println("The Test Type was created successfully");
                        }
                    } else {
                        System.out.println("The test type has not been created.");
                    }
                } else {
                    System.out.println("There is already an equivalent test type in the system");
                    System.out.println("The test type has not been created.");
                }
            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n" ,e.getMessage());
            }
        } while (dadosInvalidos);
    }

}
