package app.domain.model;


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
    private Boolean registerDateValidation;

    /**
     *
     */
    private Boolean chemicalAnalysisDateValidation;

    /**
     *
     */
    private Boolean diagnosisDateValidation;
    /**
     * The date and time the Lab Coordinator Validation was created.
     */
    private Date labCoordDate;

    /**
     * Build an instance of {@code LabCoordinatorValidation}
     */
    public LabCoordinatorValidation(){
        System.out.println("Lab Coordinator Validation created with sucess.");
        if(chemicalAnalysisDateValidation == true && chemicalAnalysisDateValidation == true && diagnosisDateValidation == true) {
            recordLabCoordinatorValidationDate();
            System.out.println("Date Validation recorded with sucess");
        }

    }

    public void checkRegisterDateValidation(){
        this.registerDateValidation = true;
    }

    public void checkChemicalAnalysisDateValidation(){
        this.chemicalAnalysisDateValidation = true;
    }

    public void checkDiagnosisDateValidation(){
        this.diagnosisDateValidation= true;
    }

    public Date recordLabCoordinatorValidationDate(){
        this.labCoordDate=Calendar.getInstance().getTime();
        return labCoordDate;
    }


}
