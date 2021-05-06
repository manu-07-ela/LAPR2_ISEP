package app.domain.model;

import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Represents a specialist doctor in organization
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class SpecialistDoctor extends Employee{
    /**
     * The doctor index number of a specialist doctor in the organization
     */
    int doctorIndexNumber;

    /**
     *Constructs an instance of {@code SpecialistDoctor} receiving the name, email, address, phone number, soc code, organization role and doctor index number.
     * @param name specialist doctor name
     * @param email specialist doctor email
     * @param adress specialist doctor address
     * @param phoneNumber specialist doctor phone number
     * @param socCode specialist doctor SOC code
     * @param organizationRole specialist doctor organization role
     * @param doctorIndexNumber specialist doctor doctor index number
     */
    public SpecialistDoctor(String name, Email email, String adress, int phoneNumber, int socCode, OrganizationRole organizationRole, int doctorIndexNumber) {
        super(name, email, adress, phoneNumber, socCode, organizationRole);
        if (!isValidDoctorIndexNumber()) throw new IllegalArgumentException("Doctor index number should have 6 digits");
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Get the specialist doctor index number.
     * @return the doctor index number.
     */
    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    /**
     * Textual description of a specialist doctor.
     * @return Information that characterizes an employee.
     */
    @Override
    public String toString() {
        return String.format("%s doctorIndexNumber= %d%n", super.toString(), doctorIndexNumber);
    }

    /**
     *Checks whether the doctor index number associated with the specialist doctor we intend to create complies with all business rules.
     * @return true if the doctor index number obeys the rules imposed by the business, false otherwise.
     */
    private boolean isValidDoctorIndexNumber(){
        return Integer.toString(doctorIndexNumber).length()==6 || StringUtils.isBlank(Integer.toString(doctorIndexNumber));
    }

    /**
     * Compare the specialist doctor with the other object provided.
     * @param other Object we want to compare with the specialist doctor.
     * @return true if the received object represents another specialist doctor equivalent to the specialist doctor. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        SpecialistDoctor that = (SpecialistDoctor) other;
        return doctorIndexNumber == that.doctorIndexNumber;
    }


}
