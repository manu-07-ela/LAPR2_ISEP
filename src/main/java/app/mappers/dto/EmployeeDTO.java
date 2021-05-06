package app.mappers.dto;

import app.domain.model.OrganizationRole;
import auth.domain.model.Email;

public class EmployeeDTO {
    private String name;
    private Email email;
    private String address;
    private int phoneNumber;
    private int socCode;
    private OrganizationRole organizationRole;
    private int doctorIndexNumber;



    public EmployeeDTO(String name, Email email, String address, int phoneNumber, int socCode, OrganizationRole organizationRole, int doctorIndexNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.organizationRole = organizationRole;
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public EmployeeDTO(String name, Email email, String address, int phoneNumber,int socCode, OrganizationRole organizationRole) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.organizationRole = organizationRole;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public int getSocCode() {
        return socCode;
    }

    public OrganizationRole getOrganizationRole() {
        return organizationRole;
    }
    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }
}
