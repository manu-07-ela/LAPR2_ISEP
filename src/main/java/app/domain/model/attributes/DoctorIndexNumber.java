package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a doctor index number of a specialist doctor
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class DoctorIndexNumber {
    /**
     * The doctor index number of a specialist doctor
     */
    private int doctorIndexNumber;

    /**
     * Create a doctor index number instance receiving a doctor index number by parameter
     * @param doctorIndexNumber the doctor index number
     */
    public DoctorIndexNumber(int doctorIndexNumber) {
        checkRulesForDoctorIndexNumber(doctorIndexNumber);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Get the doctor index number
     * @return the doctor index number
     */
    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    /**
     * Checks if the business rules applied to the doctor index number are respected
     * @param doctorIndexNumber the doctor index number
     */
    private void checkRulesForDoctorIndexNumber(int doctorIndexNumber){
        if (StringUtils.isBlank(Integer.toString(doctorIndexNumber))) throw new IllegalArgumentException("ERROR: Doctor index number can't be blank.");
        if (Integer.toString(doctorIndexNumber).length()!=6) throw new IllegalArgumentException("ERROR: Doctor index number must have 6 digits");
    }
}
