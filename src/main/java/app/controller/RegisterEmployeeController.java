package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.domain.store.EmployeeStore;
import app.domain.store.OrganizationRoleStore;
import app.mappers.EmployeeMapper;
import app.mappers.OrganizationRoleMapper;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;

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
    /**
     *
     */
    private OrganizationRole orgRole;
    /**
     *
     */
    private OrganizationRoleMapper mapperOrgRole;
    /**
     *
     */
    private EmployeeMapper mapperEmp;

    /**
     *
     */
    public RegisterEmployeeController(){
        this.company = App.getInstance().getCompany();
        this.employeeStore = company.getEmployeeStore();
        this.organizationRoleStore = company.getOrganizationRoleStore();
        this.mapperOrgRole = new OrganizationRoleMapper();
        this.mapperEmp = new EmployeeMapper();

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
    public List<OrganizationRoleDTO> getLisOfOrgRoles(){
       return this.mapperOrgRole.listOrgRolesDto(this.organizationRoleStore.getListOrgRoles());
    }


    /**
     *
     * @param orgRoleDto
     * @return
     */
    public OrganizationRole createOrganizationRole(OrganizationRoleDTO orgRoleDto) {
        return this.orgRole = organizationRoleStore.createOrganizationRole(this.mapperOrgRole.toOrganizationRole(orgRoleDto));
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

    /**
     *
     * @return
     */
    public boolean saveEmployee(){
        return this.employeeStore.addEmployee(emp);
    }



}
