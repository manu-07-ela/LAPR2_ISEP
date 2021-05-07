package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.OrganizationRole;
import app.mappers.dto.OrganizationRoleDTO;
import app.ui.console.utils.Utils;

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
        String option = Utils.readLineFromConsole("Type your option: ");
        createOrganizationRole(option);
    }
    private void showOrganizationRole(){
        System.out.printf("What is the organizational role played by the employee you want to register? %n");

        for (OrganizationRoleDTO orgRoleDTO : controller.getLisOfOrgRoles()){
            System.out.printf("-> %s%n", orgRoleDTO.getDesignation());
        }
    }
    private void createOrganizationRole(String designation){
        OrganizationRoleDTO orgRoleDto = new OrganizationRoleDTO(designation);
        if (controller.validateOrganizationRole(orgRoleDto)){
            try {
                this.controller.createOrganizationRole(new OrganizationRoleDTO(designation));
            }catch (IllegalArgumentException e){
                System.out.printf("ERROR: %s%n", e.getMessage());
            }
        }
    }



}
