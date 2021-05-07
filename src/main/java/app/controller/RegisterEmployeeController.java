package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.domain.store.EmployeeStore;
import app.domain.store.OrganizationRoleStore;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;

import java.util.ArrayList;
import java.util.List;

public class RegisterEmployeeController {
    /**
     *
     */
    private Company company;
    /**
     *
     */
    private EmployeeStore employeeStore;
    /**
     *
     */
    private  OrganizationRoleStore organizationRoleStore;
    /**
     *
     */
    private Employee emp;
    private OrganizationRole orgRole;

    /**
     *
     */
    public RegisterEmployeeController(){
        this.company = App.getInstance().getCompany();
        this.employeeStore = company.getEmployeeStore();
        this.organizationRoleStore = company.getOrganizationRoleStore();

    }

    /**
     *
     * @param company
     */
    public RegisterEmployeeController(Company company){
        this.company = company;
        this.employeeStore = company.getEmployeeStore();
        this.organizationRoleStore = company.getOrganizationRoleStore();
    }

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
    public boolean createOrganizationRole(OrganizationRoleDTO orgRoleDto){
        this.orgRole = organizationRoleStore.createOrganizationRole(orgRoleDto);
        return this.organizationRoleStore.validateOrganizationRole(orgRole);
    }

    /**
     *
     * @param empDto
     * @return
     */
    public SpecialistDoctor createSpecialistDoctor(EmployeeDTO empDto){
        this.emp = employeeStore.createSpecialistDoctor(empDto);
        return (SpecialistDoctor) emp;
    }

    /**
     *
     * @param empDto
     * @return
     */
    public Employee createEmployee(EmployeeDTO empDto){
        this.emp = employeeStore.createEmployee(empDto);
        return (SpecialistDoctor) emp;
    }

    public boolean saveEmployee(){
        return true; //see how to save the Employee
    }



}
