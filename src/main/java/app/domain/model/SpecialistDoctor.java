package app.domain.model;

import app.domain.model.attributes.*;
import auth.domain.model.Email;

import java.util.Objects;

/**
 * Represents a specialist doctor in organization
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class SpecialistDoctor extends Employee{
    /**
     * The doctor index number of a specialist doctor in the organization
     */
    DoctorIndexNumber doctorIndexNumber;

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
    public SpecialistDoctor(Name name, Email email, Address adress, PhoneNumber phoneNumber, SocCode socCode, OrganizationRole organizationRole, DoctorIndexNumber doctorIndexNumber) {
        super(name, email, adress, phoneNumber, socCode, organizationRole);
        this.doctorIndexNumber = new DoctorIndexNumber(doctorIndexNumber);
    }

    /**
     * Get the specialist doctor index number.
     * @return the doctor index number.
     */
    public DoctorIndexNumber getDoctorIndexNumber() {
        return new DoctorIndexNumber(doctorIndexNumber);
    }

    /**
     * Textual description of a specialist doctor.
     * @return Information that characterizes an employee.
     */
    @Override
    public String toString() {
        return String.format("%s-> Doctor Index Number= %s%n", super.toString(), doctorIndexNumber.getDoctorIndexNumber());
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
        return Objects.equals(doctorIndexNumber, that.doctorIndexNumber);
    }

}
