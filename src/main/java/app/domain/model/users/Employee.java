package app.domain.model.users;
import app.domain.model.attributes.*;
import auth.domain.model.Email;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Locale;


/**
 *Represents a Employee in organization
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class Employee implements Serializable {
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
     * Count the instances of employees created in the system
     */
    private static int instancesOfEmployee;

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

        this.name = new Name(name);
        this.email = new Email(email);
        this.address = new Address(address);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.socCode = new SocCode(socCode);
        this.organizationRole = new OrganizationRole(organizationRole);
        this.employeeId = nameId(this.name)+numberId(instancesOfEmployee);
        instancesOfEmployee++;
    }

    /**
     * Takes the initials of a name and puts them in capital letters to be used in the employee ID later
     * @param name The name of an employee
     * @return The initials of an employee's name
     */
    private String nameId(Name name){
        String n = "";
        String[] nameAux = name.getDesignation().split(" ");
        for (int i=0; i<nameAux.length; i++){
            n += nameAux[i].charAt(0);
        }
        return n.toUpperCase(Locale.ROOT);
    }

    /**
     * Receives the instance counter from the employees and puts this number with 5 digits to later be concatenated with the initials of the employee's name
     * @param id The employee instance counter
     * @return The number with 5 digits
     */
    private String numberId(int id){
        DecimalFormat df = new DecimalFormat("00000");
        return df.format(id);
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
        return String.format("-> Name= %s%n-> Email= %s%n-> Address= %s%n-> PhoneNumber= %s%n-> Employee ID= %s%n-> SOC code= %s%n-> Organization Role= %s%n", name.getDesignation(), email.getEmail(), address.getDesignation(), phoneNumber.getNumber(), employeeId, socCode.getCode(), organizationRole.getDesignation());
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
        return email.equals(employee.getEmail());
    }

}
