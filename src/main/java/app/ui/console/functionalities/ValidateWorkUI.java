package app.ui.console.functionalities;

import app.controller.ValidateWorkController;
import app.domain.model.testrelated.LabCoordinatorValidation;
import app.domain.store.TestStore;
import app.mappers.dto.TestDTO;
import app.ui.console.utils.Utils;

import java.io.IOException;

/**
 * Represents an interface with the user to be able to validate the work done by the clinical chemistry technologist and specialist doctor .
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ValidateWorkUI implements Runnable{

    /**
     * Represents a instance of validate work controller.
     */
    private ValidateWorkController validateWorkController;

    /**
     * Constructs an instance of {@code ValidateWorkUI}.
     */
    public ValidateWorkUI(){
       validateWorkController = new ValidateWorkController();

    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
        try {
            boolean flag;
            System.out.println("\n/========== Work Validation ==========/");
            do {
                TestDTO selectedTest = (TestDTO) Utils.showAndSelectOne(validateWorkController.getTestsToValidateList(), "Select test to Validate.");
                validateWork(selectedTest);
                if (validateWorkController.getTestsToValidateList().size() > 0) {
                    flag = Utils.confirm("Do you want to Validate another Test? (S/N)");
                } else {
                    flag = false;
                }
            }while(flag);
        }catch (IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }
    }


    /**
     * Validates the work associated with the selected test.
     */
    public void validateWork(TestDTO selectedTest){
        try {
            boolean fl=true;
            do {
                String resposta;
                validateWorkController.getSelectedTest(selectedTest);
                validateWorkController.createTestValidation();

                System.out.println("\nRegistration Date:");
                System.out.printf("%s",validateWorkController.showRegistrationDate());
                resposta = Utils.readLineFromConsole("Do you want to validate the Registration Date? (S/N):");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = validateWorkController.validateDate("Registration Date");
                    System.out.println("Registration Validation Date validated with sucess.");
                }

                System.out.println("\nChemical Analysis Date: ");
                System.out.printf("%s",validateWorkController.showChemicalAnalysisDate());

                resposta = Utils.readLineFromConsole("Do you want to validate the Chemical Analysis Date? (S/N):");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = validateWorkController.validateDate("Chemical Analysis Date");
                    System.out.println("Chemical Analysis Date validated with sucess.");
                }

                System.out.println("\nDiagnosis Date: ");
                System.out.printf("%s",validateWorkController.showDiagnosisDate());

                resposta = Utils.readLineFromConsole("Do you want to validate the Diagnosis Date? (S/N):");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = validateWorkController.validateDate("Diagnosis Date");
                    System.out.printf("Diagnosis Validation Date validated with success.\n");
                }

                System.out.printf("\n%s", validateWorkController.showDates());
                boolean flag = Utils.confirm("Do you validate the three validated dates? (S/N)");

                if (flag) {
                    fl = validateWorkController.recordValidationDate(validateWorkController.getSelectedTest(selectedTest));
                    System.out.printf("Diagnosis Validation Date validated with sucess - %s\n", validateWorkController.showLabCoordValidationDate(validateWorkController.getSelectedTest(selectedTest)));
                    validateWorkController.notifyTheClient(validateWorkController.getSelectedTest(selectedTest));
                    System.out.println("\nClient successfully informed.");
                    fl = false;
                }

            } while(fl);
        } catch (IllegalArgumentException | IOException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }
    }



}
