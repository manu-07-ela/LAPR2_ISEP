package app.domain.model;
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
    private String name;
    /**
     *The email of an employee in the organization
     */
    private Email email;
    /**
     *The address of an employee in the organization
     */
    private String address;
    /**
     *The phone number of an employee in the organization
     */
    private int phoneNumber;
    /**
     *The employee ID of an employee in the organization
     */
    private String employeeId;
    /**
     *The Standard Occupational Classification of an employee in the organization
     */
    private int socCode;
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
    public Employee(String name, Email email, String address, int phoneNumber, int socCode, OrganizationRole organizationRole){
        if(!isValidName()) {
            throw new IllegalArgumentException("Name need to have maximum 15 characters");
        }
        if (!isValidSocNumber()){
            throw new IllegalArgumentException("Soc Number must have maximum 4 digits");
        }
        if (!isValidPhoneNumber()){
            throw new IllegalArgumentException("Phone number must have maximum (this rule)");
        }

        this.name = name.trim();
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.organizationRole = new OrganizationRole(organizationRole.designation);


    }

    /**
     * Get the name of an employee
     * @return the name of Employee
     */
    public String getName() {
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
    public String getAddress() {
        return address;
    }

    /**
     * Get the phone number of an employee
     * @return the phone number of Employee
     */
    public int getPhoneNumber() {
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
    public int getSocCode() {
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
     * Checks whether the name associated with the employee we intend to create complies with all business rules.
     * @return true if the name obeys the rules imposed by the business, false otherwise.
     */
    private boolean isValidName(){
        return name.length()<=15 || StringUtils.isBlank(name);
    }

    /**
     * Checks whether the SOC number associated with the employee we intend to create complies with all business rules.
     * @return true if the SOC number obeys the rules imposed by the business, false otherwise.
     */
    private  boolean isValidSocNumber(){
        return Integer.toString(socCode).length() == 4 || StringUtils.isBlank(Integer.toString(socCode));
    }

    /**
     * Checks whether the phone number associated with the employee we intend to create complies with all business rules.
     * @return true if the phone number obeys the rules imposed by the business, false otherwise.
     */
    private  boolean isValidPhoneNumber() {
        return Integer.toString(phoneNumber).length() == 11 || !ObjectUtils.allNotNull(phoneNumber) || StringUtils.isBlank(Integer.toString(phoneNumber));
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
