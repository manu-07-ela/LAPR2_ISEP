package app.domain.model;

import auth.domain.model.Email;

public class SpecialistDoctor extends Employee{
    int doctorIndexNumber;

    public SpecialistDoctor(String name, Email email, String adress, int phoneNumber, int socCode, OrganizationRole organizationRole, int doctorIndexNumber) {
        super(name, email, adress, phoneNumber, socCode, organizationRole);
        if (!isValidDoctorIndexNumber()) throw new IllegalArgumentException("Doctor index number should have 6 digits");
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }
    private boolean isValidDoctorIndexNumber(){
        return Integer.toString(doctorIndexNumber).length()==6;
    }
}
