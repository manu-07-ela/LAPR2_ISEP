package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.domain.model.attributes.*;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable{
    Scanner sc = new Scanner(System.in);
    private RegisterEmployeeController controller;


    public  RegisterEmployeeUI(){
        controller = new RegisterEmployeeController();
    }

    @Override
    public void run() {
        SpecialistDoctor specialistDoctor = null;
        Employee emp = null;
        showOrganizationRole();
        OrganizationRole orgRole = createOrganizationRole();
        if (orgRole.getDesignation().equalsIgnoreCase("SPECIALIST DOCTOR")){
            specialistDoctor = createSpecialistDoctor(orgRole);
            showSpecialistDoctor(specialistDoctor);
        }
        else{
            emp =  createEmployee(orgRole);
            showEmployee(emp);
        }





    }
    private void showOrganizationRole(){
        System.out.printf("What is the organizational role played by the employee you want to register? %n");
        for (OrganizationRoleDTO orgRoleDTO : controller.getLisOfOrgRoles()){
            System.out.printf("-> %s%n", orgRoleDTO.getDesignation());
        }
    }
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
    public PhoneNumber phoneNumber(){
        boolean invalidData = true;
        PhoneNumber phoneNumberAux = null;
        do{
            try {
                double phoneNumber = Utils.readDoubleFromConsole("Phone Number: ");
                phoneNumberAux = new PhoneNumber(phoneNumber);
                invalidData = false;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return phoneNumberAux;
    }
    public SocCode socCode(){
        boolean invalidData = true;
        SocCode socCodeAux = null;
        do{
            try {
                int socCode = Utils.readIntegerFromConsole("SOC code: ");
                socCodeAux = new SocCode(socCode);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return socCodeAux;
    }
    public DoctorIndexNumber doctorIndexNumber(){
        boolean invalidData = true;
        DoctorIndexNumber doctorIndexNumberAux = null;
        do{
            try {
                int doctorIndexNumber = Utils.readIntegerFromConsole("Doctor index Number: ");
                doctorIndexNumberAux = new DoctorIndexNumber(doctorIndexNumber);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return doctorIndexNumberAux;
    }

    public SpecialistDoctor createSpecialistDoctor(OrganizationRole organizationRole){
        return controller.createSpecialistDoctor(new EmployeeDTO(name(), email(),adress(), phoneNumber(), socCode(), organizationRole, doctorIndexNumber()));
    }
    public  Employee createEmployee(OrganizationRole organizationRole){
        return controller.createEmployee(new EmployeeDTO(name(), email(), adress(), phoneNumber(), socCode(), organizationRole));
    }



    public void showEmployee(Employee emp){
        System.out.println();
        System.out.println("-*-*-*-*-*- Employee data -*-*-*-*-*-");
        System.out.println(emp);
        System.out.println("Do you want to save this employee?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        int option = Utils.readIntegerFromConsole("Type your option: ");
        if (option == 1){
            if (controller.saveEmployee(emp) && controller.transformEmployeeInUser(emp))
                System.out.println("Operation completed successfully, your employee was saved.");
        }
    }
    public void showSpecialistDoctor(SpecialistDoctor emp){
        System.out.println();
        System.out.println("Do you want to save this employee?");
        System.out.println(emp);
        System.out.println("1. YES");
        System.out.println("2. NO");
        int option = Utils.readIntegerFromConsole("Type your option: ");
        if (option == 1){
            if (controller.saveEmployee(emp) && controller.transformEmployeeInUser(emp))
                System.out.println("Operation completed successfully, your employee was saved.");

        }

    }





}
