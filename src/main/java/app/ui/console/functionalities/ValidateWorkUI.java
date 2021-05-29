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
     * Represents a instance of validate work controller.
     */
    private TestStore ts;

    /**
     * Represents a instance of validate work controller.
     */
    private LabCoordinatorValidation lcv;

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
            System.out.println("/========== Work Validation ==========/");
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
     *
     */
    public void validateWork(TestDTO selectedTest){
        try {
            boolean fl;
            do {
                String resposta;
                validateWorkController.createTestValidation(ts.getTestByInternalCode(selectedTest.getInternalCode()));

                validateWorkController.showRegistrationDate(ts.getTestByInternalCode(selectedTest.getInternalCode()));
                resposta = Utils.readLineFromConsole("S/N:");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = lcv.checkRegisterDateValidation();
                    System.out.printf("%nRegistration Validation Date validated with sucess.%n");
                } else {
                    fl = false;
                }
                validateWorkController.showChemicalAnalysisDate(ts.getTestByInternalCode(selectedTest.getInternalCode()));
                resposta = Utils.readLineFromConsole("S/N:");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = lcv.checkChemicalAnalysisDateValidation();
                    System.out.printf("%nChemical Analysis Date validated with sucess.%n");
                } else {
                    fl = false;
                }
                validateWorkController.showDiagnosisDate(ts.getTestByInternalCode(selectedTest.getInternalCode()));
                resposta = Utils.readLineFromConsole("S/N:");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = lcv.checkDiagnosisDateValidation();
                    System.out.printf("%nDiagnosis Validation Date validated with sucess.%n");
                } else {
                    fl = false;
                }
                System.out.println("Do you check the three validated dates?");
                validateWorkController.showDates(ts.getTestByInternalCode(selectedTest.getInternalCode()));
                resposta = Utils.readLineFromConsole("S/N:");
                if (resposta.equalsIgnoreCase("S")) {
                    fl = validateWorkController.recordValidationDate(ts.getTestByInternalCode(selectedTest.getInternalCode()));
                    System.out.printf("%nDiagnosis Validation Date validated with sucess.%n");
                    validateWorkController.notifyTheClient(ts.getTestByInternalCode(selectedTest.getInternalCode()));
                    System.out.println("%n Client successfully informed.");
                } else {
                    fl = false;
                }
            } while(fl);
        } catch (IllegalArgumentException | IOException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }
    }



}
