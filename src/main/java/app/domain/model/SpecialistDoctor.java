package app.domain.model;

import auth.domain.model.Email;

public class SpecialistDoctor extends Employee{
    float doctorIndexNumber;

    public SpecialistDoctor(String name, Email email, String adress, float phoneNumber, String socCode, EmployeeRole employeeRole, float doctorIndexNumber) {
        super(name, email, adress, phoneNumber, socCode, employeeRole);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public float getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    public void setDoctorIndexNumber(float doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }

}
