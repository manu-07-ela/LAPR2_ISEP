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


    public boolean recordDate(){
        Boolean fl = false;
        if(registerDateValidation && chemicalAnalysisDateValidation && diagnosisDateValidation) {
            recordLabCoordinatorValidationDate();
            fl = true;
        }
        return fl;
    }

    public boolean recordLabCoordinatorValidationDate(){
        this.labCoordDate= Calendar.getInstance().getTime();
        return true;
    }

    public Date getLabCoordDate(){ return this.labCoordDate; }



}
