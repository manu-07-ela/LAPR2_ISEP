package app.ui.console;

import app.controller.CreateTestTypeController;
import app.mappers.dto.ParameterCategoryDTO;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an interface with the user to be able to register a new test type.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class CreateTestTypeUI implements Runnable {

    /**
     * Represents a instance of create test type controller.
     */
    private CreateTestTypeController createTestTypectrl;


    /**
     * Initializes the controller.
     */
    public CreateTestTypeUI(){
        createTestTypectrl = new CreateTestTypeController();
    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run(){
        if(createTestTypectrl.getParameterCategories().size() == 0){
            System.out.println("There is no Parameter Category in the system so it is not possible to create a test type.");
        } else {
            System.out.printf("%nCreating a Test Type%n");
            createTestType();
        }
    }

    /**
     * Create an instance of test type.
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

                List<ParameterCategoryDTO> listOfParameterCategories = new ArrayList();
                boolean confirmation;
                int aux=0;
                do{
                    Object option = Utils.selectsObject(createTestTypectrl.getParameterCategories());
                    if (option == null){
                        throw new IllegalArgumentException("There must be at least one parameter category associated.");
                    }
                    ParameterCategoryDTO pcDto = (ParameterCategoryDTO) option;
                    if (!listOfParameterCategories.contains(pcDto)){
                        listOfParameterCategories.add(pcDto);
                    }
                    aux++;
                    confirmation = false;
                    if(createTestTypectrl.getParameterCategories().size()>aux) {
                        System.out.printf("%nDo you want to select any more categories?%n");
                        confirmation = Utils.confirm("S/N:");
                    }
                } while (confirmation);

                boolean result = createTestTypectrl.createTestType(code,description,collectingMethod,listOfParameterCategories);
                dadosInvalidos = false;

                if(result){

                    System.out.printf("%nDo you want to create a Test Type with the following data:%n%s",createTestTypectrl.toString());

                    boolean answer = Utils.confirm("S/N:");

                    if(answer){
                        if(createTestTypectrl.saveTestType()){
                            System.out.println("The Test Type was created successfully");
                            boolean confirm = Utils.confirm("Do you want to create another one? (S/N)");

                            if (confirm)
                                dadosInvalidos = true;
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
