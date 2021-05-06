package app.domain.model;
import auth.domain.model.Email;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 *
 */
public class Employee {

    private String name;
    private Email email;
    private String address;
    private int phoneNumber;
    private String employeeId;
    private int socCode;
    private OrganizationRole organizationRole;

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

        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        //how to get the initials of employee
        this.socCode = socCode;
        this.organizationRole = organizationRole;
        //this.employeeId see how to get the initial od employees


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getSocCode() {
        return socCode;
    }

    public void setSocCode(int socCode) {
        this.socCode = socCode;
    }

    public OrganizationRole getEmployeeRole() {
        return organizationRole;
    }

    public void setEmployeeRole(OrganizationRole organizationRole) {
        this.organizationRole = organizationRole;
    }

    private boolean isValidName(){
        return name.length()<=15 || !ObjectUtils.allNotNull(name) || StringUtils.isBlank(name);
    }
    private  boolean isValidSocNumber(){
        return Integer.toString(socCode).length() == 4 || !ObjectUtils.allNotNull(socCode) || StringUtils.isBlank(Integer.toString(socCode));
    }
    private  boolean isValidPhoneNumber() {
        return Integer.toString(phoneNumber).length() == 11 || !ObjectUtils.allNotNull(phoneNumber) || StringUtils.isBlank(Integer.toString(phoneNumber));
    }








}
