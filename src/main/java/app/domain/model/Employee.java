package app.domain.model;
import auth.domain.model.Email;
import auth.domain.model.Password;
public class Employee {

    String name;
    Email email;
    Password id;
    String address;
    float phoneNumber;
    String employeeId;
    String socCode;
    EmployeeRole employeeRole;

    public Employee(String name, Email email, String adress, float phoneNumber, String socCode, EmployeeRole employeeRole){
        if(!isValidName()) {
            throw new IllegalArgumentException("Name need to have maximum 15 characters");
        }
        if (!isValidAdress()){
            throw new IllegalArgumentException("Adress musta have maximum * characters");
        }
        if (!isValidPhoneNumber()){
            throw new IllegalArgumentException("Phone number must have maximum (this rule)");
        }
        if (!isValidSocNumber()){
            throw  new IllegalArgumentException("Soc number must have 4 characters");
        }

        this.name = name;
        this.email = email;
        this.id = id;
        this.address = adress;
        this.phoneNumber = phoneNumber;
        //how to get the inicials of employee
        this.socCode = socCode;
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

    public Password getId() {
        return id;
    }

    public void setId(Password id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(float phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSocCode() {
        return socCode;
    }

    public void setSocCode(String socCode) {
        this.socCode = socCode;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    private boolean isValidName(){
        return name.length()<=15;
    }
    private  boolean isValidSocNumber(){
        return socCode.length()<=4;
    }
    private  boolean isValidPhoneNumber(){
        return  true;//(String) phoneNumber see method that converts float in String
    }
    private boolean isValidAdress(){
        return true; //see the rules for this
    }







}
