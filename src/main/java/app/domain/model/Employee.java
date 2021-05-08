package app.domain.model;
import app.domain.model.attributes.Address;
import app.domain.model.attributes.Name;
import app.domain.model.attributes.PhoneNumber;
import app.domain.model.attributes.SocCode;
import auth.domain.model.Email;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 *Represents a Employee in organization
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class Employee {
    /**
     *The name of an employee in the organization
     */
    private Name name;
    /**
     *The email of an employee in the organization
     */
    private Email email;
    /**
     *The address of an employee in the organization
     */
    private Address address;
    /**
     *The phone number of an employee in the organization
     */
    private PhoneNumber phoneNumber;
    /**
     *The employee ID of an employee in the organization
     */
    private String employeeId;
    /**
     *The Standard Occupational Classification of an employee in the organization
     */
    private SocCode socCode;
    /**
     *The organization role of an employee in the organization
     */
    private OrganizationRole organizationRole;

    /**
     * Constructs an instance of {@code Employee} receiving the name, email, address, phone number, soc code and organization role
     * @param name name of Employee
     * @param email email of Employee
     * @param address address of Employee
     * @param phoneNumber phone number of Employee
     * @param socCode SOC code of Employee
     * @param organizationRole organization Role of Employee
     */
    public Employee(Name name, Email email, Address address, PhoneNumber phoneNumber, SocCode socCode, OrganizationRole organizationRole){

        this.name = new Name(name.getName());
        this.email = new Email(email.getEmail());
        this.address = new Address(address.getAddress());
        this.phoneNumber = new PhoneNumber(phoneNumber.getPhoneNumber());
        this.socCode = new SocCode(socCode.getSocCode());
        this.organizationRole = new OrganizationRole(organizationRole.designation);
    }

    /**
     * Get the name of an employee
     * @return the name of Employee
     */
    public Name getName() {
        return name;
    }

    /**
     * Get the email of an employee
     * @return the email of Employee
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Get the address of an employee
     * @return the address of Employee
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Get the phone number of an employee
     * @return the phone number of Employee
     */
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the employee ID of an employee
     * @return the employee ID of Employee
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Get the SOC code of an employee
     * @return the SOC code of Employee
     */
    public SocCode getSocCode() {
        return socCode;
    }

    /**
     * Get the employee role of an employee
     * @return the employee role of Employee
     */
    public OrganizationRole getEmployeeRole() {
        return organizationRole;
    }


    /**
     * Textual description of an employee.
     * @return Information that characterizes an employee.
     */
    @Override
    public String toString() {
        return String.format("name= %s%n, email= %s%n, address= %s%n, phoneNumber= %d%n, employeeId= %s%n, socCode= %d%n, organizationRole= %s%n", name, email, address, phoneNumber, employeeId, socCode, organizationRole);
    }

    /**
     * Compare the employee with the other object provided.
     * @param other Object we want to compare with the employee.
     * @return true if the received object represents another employee equivalent to the employee. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return phoneNumber == employee.phoneNumber && name.equals(employee.name) && email.equals(employee.email);
    }

}
