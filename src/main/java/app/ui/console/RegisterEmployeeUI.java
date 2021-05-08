package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.Employee;
import app.domain.model.attributes.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.domain.model.attributes.*;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

import java.io.IOException;


/**
 * Represents an interface with the user to be able to register a new employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class RegisterEmployeeUI implements Runnable{
    /**
     * Represents a instance of register employee controller
     */
    private RegisterEmployeeController controller;

    /**
     * Initializes the controller
     */
    public  RegisterEmployeeUI(){
        controller = new RegisterEmployeeController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {
        SpecialistDoctor specialistDoctor = null;
        Employee emp = null;
        showOrganizationRole();
        OrganizationRole orgRole = createOrganizationRole();
        if (orgRole.getDesignation().equalsIgnoreCase("SPECIALIST DOCTOR")){
            specialistDoctor = createSpecialistDoctor(orgRole);
            try {
                showSpecialistDoctor(specialistDoctor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            emp =  createEmployee(orgRole);
            try {
                showEmployee(emp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shows the organizational roles present in the company
     */
    private void showOrganizationRole(){
        System.out.printf("What is the organizational role played by the employee you want to register? %n");
        for (OrganizationRoleDTO orgRoleDTO : controller.getLisOfOrgRoles()){
            System.out.printf("-> %s%n", orgRoleDTO.getDesignation());
        }
    }

    /**
     * Create an instance of organizational role
     * @return the organization role
     */
    private OrganizationRole createOrganizationRole(){
        OrganizationRole orgRole = null;
        boolean invalidData = true;
        do {
            String option = Utils.readLineFromConsole("Type your option: ");
            try {
                orgRole = this.controller.createOrganizationRole(new OrganizationRoleDTO(option));
                invalidData = false;

            }catch (IllegalArgumentException e){
                System.out.printf("ERROR: %s%n", e.getMessage());

            }
        }while (invalidData);

        return orgRole;
    }

    /**
     * Create an instance of name
     * @return The name
     */
    public Name name(){
        boolean invalidData = true;
        Name nameAux = null;
        do{
            try {
                String name = Utils.readLineFromConsole("Name: ");
                nameAux = new Name(name);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return nameAux;
    }

    /**
     * Create an instance of email
     * @return the email
     */
    public Email email(){
        boolean invalidData = true;
        Email emailAux = null;
        do{
            try {
                String email = Utils.readLineFromConsole("Email: ");
                emailAux = new Email(email);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return emailAux;
    }

    /**
     * Create an instance of address
     * @return the address
     */
    public Address adress(){
        boolean invalidData = true;
        Address addressAux = null;
        do{
            try {
                String address = Utils.readLineFromConsole("Address: ");
                addressAux = new Address(address);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return addressAux;
    }

    /**
     * Create an instance of phone number
     * @return the phone number
     */
    public PhoneNumber phoneNumber(){
        boolean invalidData = true;
        PhoneNumber phoneNumberAux = null;
        do{
            try {
                String phoneNumber = Utils.readLineFromConsole("Phone Number: ");
                phoneNumberAux = new PhoneNumber(phoneNumber);
                invalidData = false;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return phoneNumberAux;
    }

    /**
     * Create an instance of SOC code
     * @return the SOC code
     */
    public SocCode socCode(){
        boolean invalidData = true;
        SocCode socCodeAux = null;
        do{
            try {
                String socCode = Utils.readLineFromConsole("SOC code: ");
                socCodeAux = new SocCode(socCode);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return socCodeAux;
    }

    /**
     * Create an instance of doctor index number
     * @return the doctor index number
     */
    public DoctorIndexNumber doctorIndexNumber(){
        boolean invalidData = true;
        DoctorIndexNumber doctorIndexNumberAux = null;
        do{
            try {
                String doctorIndexNumber = Utils.readLineFromConsole("Doctor index Number: ");
                doctorIndexNumberAux = new DoctorIndexNumber(doctorIndexNumber);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return doctorIndexNumberAux;
    }

    /**
     * Create an instance of specialist doctor
     * @param organizationRole the organization role played by the employee
     * @return the specialist doctor
     */
    public SpecialistDoctor createSpecialistDoctor(OrganizationRole organizationRole){
        return controller.createSpecialistDoctor(new EmployeeDTO(name(), email(),adress(), phoneNumber(), socCode(), organizationRole, doctorIndexNumber()));
    }

    /**
     * Create an instance of employee
     * @param organizationRole the organization role played by the employee
     * @return the employee
     */
    public  Employee createEmployee(OrganizationRole organizationRole){
        return controller.createEmployee(new EmployeeDTO(name(), email(), adress(), phoneNumber(), socCode(), organizationRole));
    }

    /**
     * Shows the employee and asks if the user wants to save him
     * @param emp the employee
     */
    public void showEmployee(Employee emp) throws IOException {
        System.out.println();
        System.out.println("-*-*-*-*-*- Employee data -*-*-*-*-*-");
        System.out.println(emp);
        System.out.println("Do you want to save this employee?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        int option = Utils.readIntegerFromConsole("Type your option: ");
        if (option == 1){
            if ( controller.saveEmployee(emp)){
                controller.transformEmployeeInUser(emp);
                System.out.println("Operation completed successfully, your employee was saved.");
                System.out.println("Your credentials are in the file named:" + emp.getEmployeeId());
            }

        }
    }

    /**
     * Shows the specialist doctor and asks if the user wants to save him
     * @param emp the specialist doctor
     */
    public void showSpecialistDoctor(SpecialistDoctor emp) throws IOException {
        System.out.println();
        System.out.println("Do you want to save this employee?");
        System.out.println(emp);
        System.out.println("1. YES");
        System.out.println("2. NO");
        int option = Utils.readIntegerFromConsole("Type your option: ");
        if (option == 1){
            if (controller.saveEmployee(emp)){
                controller.transformEmployeeInUser(emp);
                System.out.println("Operation completed successfully, your employee was saved.");
                System.out.println("Your credentials are in the file named:" + emp.getEmployeeId());
            }




        }
    }





}
