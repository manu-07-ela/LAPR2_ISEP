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
    private final RegisterEmployeeController controller;

    /**
     * Initializes the controller
     */
    public RegisterEmployeeUI(){
        controller = new RegisterEmployeeController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {
        showOrganizationRole();
        OrganizationRole orgRole = createOrganizationRole();
        EmployeeDTO employeeDTO = createEmployeeDTO(orgRole);
        try {
            showEmployee(employeeDTO, orgRole);
        }catch (IOException e){
            e.printStackTrace();
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
    private Name name(){
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
    private Email email(){
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
    private Address address(){
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
    private PhoneNumber phoneNumber(){
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
    private SocCode socCode(){
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
    private DoctorIndexNumber doctorIndexNumber(){
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
     * Create an instance of employee
     * @param organizationRole the organization role played by the employee
     * @return the employee
     */
    private EmployeeDTO createEmployeeDTO(OrganizationRole organizationRole){
        if (organizationRole.getDesignation().equalsIgnoreCase("specialist doctor"))
            return new EmployeeDTO(name(), email(), address(), phoneNumber(), socCode(), organizationRole, doctorIndexNumber());
        else
            return new EmployeeDTO(name(), email(), address(), phoneNumber(), socCode(), organizationRole);
    }


    /**
     * Shows the specialist doctor and asks if the user wants to save him
     * @param emp the specialist doctor
     */
    private void showEmployee(EmployeeDTO emp, OrganizationRole orgRole) throws IOException {
        System.out.println();
        System.out.println("-*-*-*-*-*- Employee data -*-*-*-*-*-");
        System.out.println("Organization Role: " + emp.getOrganizationRole().getDesignation());
        System.out.println("Name:" + emp.getName().getDesignation());
        System.out.println("Email: " + emp.getEmail().getEmail());
        System.out.println("Address: " + emp.getAddress().getDesignation());
        System.out.println("Phone number: " + emp.getPhoneNumber().getNumber());
        System.out.println("SOC code: " + emp.getSocCode().getCode());
        if (orgRole.getDesignation().equalsIgnoreCase("specialist doctor")){
            System.out.println("Doctor index number: " + emp.getDoctorIndexNumber().getNumber());
        }
        System.out.println("Do you want to save this employee?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        int option = Utils.readIntegerFromConsole("Type your option: ");
        if (option == 1){
            if (orgRole.getDesignation().equalsIgnoreCase("specialist doctor")) {
                SpecialistDoctor specialistDoctor = controller.createSpecialistDoctor(emp);
                if (controller.saveEmployee(specialistDoctor)) {
                    controller.transformEmployeeInUser(specialistDoctor);
                    System.out.println("Operation completed successfully, your employee was saved.");
                    System.out.println("Your credentials are in the file named:" + specialistDoctor.getEmployeeId());
                }
            } else{
                Employee employee = controller.createEmployee(emp);
                if (controller.saveEmployee(employee)){
                    controller.transformEmployeeInUser(employee);
                    System.out.println("Operation completed successfully, your employee was saved.");
                    System.out.println("Your credentials are in the file named:" + employee.getEmployeeId());
                }

            }
        }else System.out.println("You didn't save this employee");
    }





}
