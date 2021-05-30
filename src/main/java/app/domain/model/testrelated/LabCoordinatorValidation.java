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
     * Register Date Validation
     */
    private boolean registerDateValidation = false;

    /**
     * Chemical Analysis Date Validation
     */
    private boolean chemicalAnalysisDateValidation = false;

    /**
     * Diagnosis Date Validation
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

    }


    /**
     * Confirm the Date according to the requested date to confirm.
     * @param date
     */
    public boolean checkDate(String date){
        if (date.equals("Registration Date")){
            return this.registerDateValidation = true;
        } else if ( date.equals("Chemical Analysis Date")){
            return this.chemicalAnalysisDateValidation = true;
        } else if ( date.equals("Diagnosis Date")){
            return this.diagnosisDateValidation= true;
        } else {
            System.out.println("Not available to check.");
        }
        return false;
    }

    /**
     * Compare the parameter with the other object provided.
     * @return true if the Lab Coordinator Validation Date was recorded. Otherwise, it returns false.
     */
    public boolean recordDate(){
        Boolean fl = false;
        if(registerDateValidation && chemicalAnalysisDateValidation && diagnosisDateValidation) {
            recordLabCoordinatorValidationDate();
            fl = true;
        }
        return fl;
    }

    /**
     * Records the Date of the Lab Coordinator Validation Date
     * @return true
     */
    public boolean recordLabCoordinatorValidationDate(){
        this.labCoordDate= Calendar.getInstance().getTime();
        return true;
    }

    /**
     * Get the date of the Lab Coordinator Validation.
     * @return Lab Coordinator Validation date
     */
    public Date getLabCoordDate(){ return this.labCoordDate; }



}
