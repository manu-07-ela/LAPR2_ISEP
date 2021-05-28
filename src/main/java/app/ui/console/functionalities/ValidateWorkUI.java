package app.ui.console.functionalities;

import app.controller.funcionalites.ValidateWorkController;
import app.domain.store.TestStore;
import app.mappers.dto.TestDTO;
import app.ui.console.utils.Utils;

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
     * Constructs an instance of {@code ValidateWorkUI}.
     */
    public ValidateWorkUI(){
       validateWorkController = new ValidateWorkController();
       ts = new TestStore();

    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
        validateWork();
    }

    /**
     *
     */
    public void validateWork(){
        try {
            Object option = Utils.selectsObject(validateWorkController.getTestsToValidateList());
            if (option == null){
                throw new IllegalArgumentException("There's no tests to validate.");
            }
            TestDTO index = (TestDTO) Utils.showAndSelectOne(validateWorkController.getTestsToValidateList(),"Choose the test for which you want to validate.");
            validateWorkController.createTestValidation(ts.getTestByInternalCode(index.getInternalCode()));
            //validateWorkController.showRegistrationDate();
            //validateWorkController.showChamicalAnalysisDate();
            validateWorkController.showDiagnosisDate(ts.getTestByInternalCode(index.getInternalCode()));
            //validateWorkController.showDates()
            //validateWorkController.recordValidationDate()
            //validateWorkController.notifyTheClient();




        } catch (IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }
    }



}
