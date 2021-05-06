package app.mappers.dto;

import app.domain.model.OrganizationRole;
import auth.domain.model.Email;

/**
 * Represents a data transfer object of employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class EmployeeDTO {
    /**
     * The name of the data transfer object of the type employed
     */
    private String name;
    /**
     *The email of the data transfer object of the type employed
     */
    private Email email;
    /**
     *The address of the data transfer object of the type employed
     */
    private String address;
    /**
     *The phone number of the data transfer object of the type employed
     */
    private int phoneNumber;
    /**
     *The SOC code of the data transfer object of the type employed
     */
    private int socCode;
    /**
     *The organization role of the data transfer object of the type employed
     */
    private OrganizationRole organizationRole;
    /**
     *The doctor index number of the data transfer object of the type specialist doctor
     */
    private int doctorIndexNumber;


    /**
     * Creates a new instance of EmployeeDto with the following attributes: name, email, address, phone number, soc code, organizational role and doctor index number
     * @param name employer's name
     * @param email employer's email
     * @param address employer's address
     * @param phoneNumber employer's phone number
     * @param socCode employer's socCode
     * @param organizationRole employer's organization role
     * @param doctorIndexNumber employer's doctor index number
     */
    public EmployeeDTO(String name, Email email, String address, int phoneNumber, int socCode, OrganizationRole organizationRole, int doctorIndexNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.organizationRole = organizationRole;
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Creates a new instance of EmployeeDto with the following attributes: name, email, address, phone number, soc code and organizational role
     * @param name employer's name
     * @param email employer's email
     * @param address employer's address
     * @param phoneNumber employer's phone number
     * @param socCode employer's SOC code
     * @param organizationRole employer's organization role
     */
    public EmployeeDTO(String name, Email email, String address, int phoneNumber,int socCode, OrganizationRole organizationRole) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.organizationRole = organizationRole;
    }

    /**
     * Get the name of the employee
     * @return the name of EmployeeDto
     */
    public String getName() {
        return name;
    }

    /**
     *Get the email of the employee
     * @return the email of EmployeeDto
     */
    public Email getEmail() {
        return email;
    }

    /**
     *Get the address of the employee
     * @return the address of EmployeeDto
     */
    public String getAddress() {
        return address;
    }

    /**
     *Get the phone number of the employee
     * @return the phone number of EmployeeDto
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *Get the SOC code of the employee
     * @return the SOC code of EmployeeDto
     */
    public int getSocCode() {
        return socCode;
    }

    /**
     *Get the organization role of the employee
     * @return the organization role of EmployeeDto
     */
    public OrganizationRole getOrganizationRole() {
        return organizationRole;
    }

    /**
     *Get the doctor index number of the employee
     * @return the doctor index number of EmployeeDto
     */
    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }
}
