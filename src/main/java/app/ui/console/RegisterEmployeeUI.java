package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.OrganizationRole;
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
        showOrganizationRole();
        OrganizationRole orgRole = createOrganizationRole();
        createEmployee(orgRole);


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
    public void createEmployee(OrganizationRole orgRole){
        boolean invalidData = true;
        do {
            try {
                String name = Utils.readLineFromConsole("Name: ");
                String email = Utils.readLineFromConsole("Email: ");
                String address = Utils.readLineFromConsole("Address: ");
                double phoneNumber = Utils.readDoubleFromConsole("Phone Number: ");
                int socCode = Utils.readIntegerFromConsole("SOC code: ");
                if (orgRole.getDesignation().equalsIgnoreCase("ADMINISTRATOR")){
                    int doctorIndexNumber = Utils.readIntegerFromConsole("Doctor index Number: ");
                    controller.createSpecialistDoctor(new EmployeeDTO(new Name(name), new Email(email), new Address(address), new PhoneNumber(phoneNumber), new SocCode(socCode), new OrganizationRole(orgRole.getDesignation()), new DoctorIndexNumber(doctorIndexNumber)));
                }
                else{
                    controller.createEmployee(new EmployeeDTO(new Name(name), new Email(email), new Address(address), new PhoneNumber(phoneNumber), new SocCode(socCode), new OrganizationRole(orgRole.getDesignation())));
                }
                invalidData = false;

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }while (invalidData);
    }



}
