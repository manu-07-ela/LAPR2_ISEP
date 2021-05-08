package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Represents a doctor index number of a specialist doctor
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class DoctorIndexNumber {
    /**
     * The doctor index number of a specialist doctor
     */
    private String  doctorIndexNumber;

    /**
     * Create a doctor index number instance receiving a doctor index number by parameter
     * @param doctorIndexNumber the doctor index number
     */
    public DoctorIndexNumber(String  doctorIndexNumber) {
        checkRulesForDoctorIndexNumber(doctorIndexNumber);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Copy builder of doctor index number
     * @param doctorIndexNumber the doctor index number
     */
    public DoctorIndexNumber(DoctorIndexNumber doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber.getDoctorIndexNumber();
    }

    /**
     * Get the doctor index number
     * @return the doctor index number
     */
    public String getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    /**
     * Checks if the business rules applied to the doctor index number are respected
     * @param doctorIndexNumber the doctor index number
     */
    private void checkRulesForDoctorIndexNumber(String doctorIndexNumber){
        if (StringUtils.isBlank(doctorIndexNumber)) throw new NullPointerException("ERROR: Doctor index number can't be blank.");
        if (!StringUtils.isNumeric(doctorIndexNumber)) throw new IllegalArgumentException("ERROR: Doctor index number consists only of numbers");
        if (doctorIndexNumber.length()!=6) throw new IllegalArgumentException("ERROR: Doctor index number must have 6 digits");
    }

    /**
     * Compare the doctor index number  with other object received
     * @param other Object we want to compare with the doctor index number
     * @return true if the received object represents another doctor index number equivalent to the doctor index number. Otherwise, it returns false.
     */

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DoctorIndexNumber that = (DoctorIndexNumber) other;
        return Objects.equals(doctorIndexNumber, that.doctorIndexNumber);
    }


}
