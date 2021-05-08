package app.mappers.dto;

import app.domain.model.OrganizationRole;
import app.domain.model.attributes.*;
import auth.domain.model.Email;

/**
 * Represents a data transfer object of employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class EmployeeDTO {
    /**
     * The name of the data transfer object of the type employed
     */
    private Name name;
    /**
     *The email of the data transfer object of the type employed
     */
    private Email email;
    /**
     *The address of the data transfer object of the type employed
     */
    private Address address;
    /**
     *The phone number of the data transfer object of the type employed
     */
    private PhoneNumber phoneNumber;
    /**
     *The SOC code of the data transfer object of the type employed
     */
    private SocCode socCode;
    /**
     *The organization role of the data transfer object of the type employed
     */
    private OrganizationRole organizationRole;
    /**
     *The doctor index number of the data transfer object of the type specialist doctor
     */
    private DoctorIndexNumber doctorIndexNumber;


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
    public EmployeeDTO(Name name, Email email, Address address, PhoneNumber phoneNumber, SocCode socCode, OrganizationRole organizationRole, DoctorIndexNumber doctorIndexNumber) {
        this.name = new Name(name.getName());
        this.email = new Email(email.getEmail());
        this.address = new Address(address.getAddress());
        this.phoneNumber = new PhoneNumber(phoneNumber.getPhoneNumber());
        this.socCode = new SocCode(socCode.getSocCode());
        this.organizationRole = new OrganizationRole(organizationRole.getDesignation());
        this.doctorIndexNumber = new DoctorIndexNumber(doctorIndexNumber.getDoctorIndexNumber());
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
    public EmployeeDTO(Name name, Email email, Address address, PhoneNumber phoneNumber,SocCode socCode, OrganizationRole organizationRole) {
        this.name = new Name(name.getName());
        this.email = new Email(email.getEmail());
        this.address = new Address(address.getAddress());
        this.phoneNumber = new PhoneNumber(phoneNumber.getPhoneNumber());
        this.socCode = new SocCode(socCode.getSocCode());
        this.organizationRole = new OrganizationRole(organizationRole.getDesignation());
    }

    /**
     * Get the name of the employee
     * @return the name of EmployeeDto
     */
    public Name getName() {
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
    public Address getAddress() {
        return address;
    }

    /**
     *Get the phone number of the employee
     * @return the phone number of EmployeeDto
     */
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *Get the SOC code of the employee
     * @return the SOC code of EmployeeDto
     */
    public SocCode getSocCode() {
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
    public DoctorIndexNumber getDoctorIndexNumber() {
        return doctorIndexNumber;
    }
}
