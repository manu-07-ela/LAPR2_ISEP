package app.controller;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.domain.store.OrganizationRoleStore;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;

import java.util.ArrayList;
import java.util.List;

public class RegisterEmployeeController {
    /**
     *
     * @return
     */
   //public List<OrganizationRole> getLisOfOrgRoles(){
    // see how to ask for methods in other classes
   // }

    /**
     *
     * @param orgRoleDto
     * @return
     */
    public OrganizationRole createOrganizationRole(OrganizationRoleDTO orgRoleDto){
        return new OrganizationRole(orgRoleDto.getDesignation());
    }

    /**
     *
     * @param empDto
     * @return
     */
    public SpecialistDoctor createSpecialistDoctor(EmployeeDTO empDto){
        return new SpecialistDoctor(empDto.getName(),empDto.getEmail(), empDto.getAddress(), empDto.getPhoneNumber(), empDto.getSocCode(), empDto.getOrganizationRole(), empDto.getDoctorIndexNumber());
    }

    /**
     *
     * @param empDto
     * @return
     */
    public Employee createEmployee(EmployeeDTO empDto){
        return new Employee(empDto.getName(), empDto.getEmail(),empDto.getAddress(),empDto.getPhoneNumber(), empDto.getSocCode(), empDto.getOrganizationRole());
    }

    public boolean saveEmployee(){
        return true; //see how to save the Employee
    }



}
