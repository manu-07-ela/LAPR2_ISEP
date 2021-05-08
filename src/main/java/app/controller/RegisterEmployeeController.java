package app.controller;

import app.domain.model.*;
import app.domain.store.EmployeeStore;
import app.domain.store.OrganizationRoleStore;
import app.mappers.EmployeeMapper;
import app.mappers.OrganizationRoleMapper;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;
import auth.AuthFacade;

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
    private AuthFacade authFacade;
    /**
     *
     */
    private OrganizationRoleMapper mapperOrgRole;
    /**
     *
     */
    private EmployeeMapper mapperEmp;
    private OrganizationRole orgRole;
    private SpecialistDoctor specialistDoctor;
    /**
     *
     */
    public RegisterEmployeeController(){
        this.company = App.getInstance().getCompany();
        this.employeeStore = company.getEmployeeStore();
        this.organizationRoleStore = company.getOrganizationRoleStore();
        this.mapperOrgRole = new OrganizationRoleMapper();
        this.mapperEmp = new EmployeeMapper();
        this.authFacade = company.getAuthFacade();

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
        this.specialistDoctor = employeeStore.createSpecialistDoctor(empDto);
        return specialistDoctor;
    }

    /**
     *
     * @param empDto
     * @return
     */
    public Employee createEmployee(EmployeeDTO empDto){
        this.emp = employeeStore.createEmployee(empDto);
        return emp;
    }

    /**
     *
     * @return
     */
    public boolean saveEmployee(Employee emp){
        return this.employeeStore.addEmployee(emp);
    }

    /**
     *
     * @param emp
     * @return
     */
    public boolean transformEmployeeInUser(Employee emp){
        final String[] characters = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String aux = "";
        for (int i=0; i<10; i++) aux += characters[(int) (Math.random()*characters.length)];
        return this.authFacade.addUserWithRole(emp.getName().getName(), emp.getEmail().getEmail(), aux,orgRole.getDesignation());
    }


}
