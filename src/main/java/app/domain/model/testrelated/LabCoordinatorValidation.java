package app.domain.model.testrelated;


import java.util.Calendar;
import java.util.Date;

/**
 * Represents a Lab Coordinator Validation.
 *
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class LabCoordinatorValidation {

    /**
     *
     */
    private boolean registerDateValidation = false;

    /**
     *
     */
    private boolean chemicalAnalysisDateValidation = false;

    /**
     *
     */
    private boolean diagnosisDateValidation = false;
    /**
     * The date and time the Lab Coordinator Validation was created.
     */
    private Date labCoordDate;

    /**
     * Build an instance of {@code LabCoordinatorValidation}
     */
    public LabCoordinatorValidation(){
        System.out.println("Lab Coordinator Validation created with sucess.");

    }

    public boolean checkRegisterDateValidation(){
        System.out.println("REGISTER DATE CHECKED");
        return this.registerDateValidation = true;
    }

    public boolean checkChemicalAnalysisDateValidation(){
        System.out.println("CHEMICAL ANALYSIS DATE CHECKED");
        return this.chemicalAnalysisDateValidation = true;
    }

    public boolean checkDiagnosisDateValidation(){
        System.out.println("DIAGNOSIS DATE CHECKED");
        return this.diagnosisDateValidation= true;
    }

    public boolean recordLabCoordinatorValidationDate(){
        this.labCoordDate= Calendar.getInstance().getTime();
        return true;
    }

    public boolean recordDate(){
        Boolean fl = false;
        if(registerDateValidation && chemicalAnalysisDateValidation && diagnosisDateValidation) {
            recordLabCoordinatorValidationDate();
            System.out.println("Date Validation recorded with sucess");
            fl = true;
        }
        return fl;
    }



}
