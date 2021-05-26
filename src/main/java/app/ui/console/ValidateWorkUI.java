package app.ui.console;

import app.controller.ValidateWorkController;
import app.controller.WriteMedicalReportController;
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
     *
     */
    public ValidateWorkUI(){
       validateWorkController = new ValidateWorkController();

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
            int index = Utils.showAndSelectIndex(validateWorkController.getTestsToValidateList(),"Choose the test for which you want to validate.");
            Object option = Utils.selectsObject(validateWorkController.getTestsToValidateList());
            if (option == null){
                throw new IllegalArgumentException("There's no tests to validate.");
            }
            validateWorkController.createTestValidation(validateWorkController.getTestsToValidateList().get(index));
            validateWorkController.showRegistrationDate(validateWorkController.getTestsToValidateList().get(index));



        } catch (IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }
    }

}
