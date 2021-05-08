package app.controller;

import app.domain.model.*;
import app.domain.store.EmployeeStore;
import app.domain.store.OrganizationRoleStore;
import app.mappers.EmployeeMapper;
import app.mappers.OrganizationRoleMapper;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;
import auth.AuthFacade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Represents the controller used to register a new employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class RegisterEmployeeController {
    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     *Represents an instance of the employee store
     */
    private EmployeeStore employeeStore;
    /**
     *Represents an instance of the organization role store
     */
    private  OrganizationRoleStore organizationRoleStore;
    /**
     *Represents an instance of employee
     */
    private Employee emp;
    /**
     *Represents an instance Auth facade
     */
    private AuthFacade authFacade;
    /**
     *Represents an instance of the employee store
     */
    private OrganizationRoleMapper mapperOrgRole;
    /**
     *Represents an instance of the employee mapper
     */
    private EmployeeMapper mapperEmp;
    /**
     *Represents an instance of organization role
     */
    private OrganizationRole orgRole;
    /**
     *Represents an instance of specialist doctor
     */
    private SpecialistDoctor specialistDoctor;

    /**
     * Constructs an instance of {@code RegisterEmployeeController}
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
     * Constructs an instance of {@code RegisterEmployeeController} receiving a company
     * @param company The company
     */
    public RegisterEmployeeController(Company company){
        this.company = company;
        this.employeeStore = company.getEmployeeStore();
        this.organizationRoleStore = company.getOrganizationRoleStore();
    }

    /**
     * Returns a DTO-type list of organizational roles present in the company
     * @return A DTO-type list of Organization roles
     */
    public List<OrganizationRoleDTO> getLisOfOrgRoles(){
       return this.mapperOrgRole.listOrgRolesDto(this.organizationRoleStore.getListOrgRoles());
    }


    /**
     * Create an organizational role by receiving an organizational DTO role as a parameter
     * @param orgRoleDto The organization Role DTO
     * @return the Organization role
     */
    public OrganizationRole createOrganizationRole(OrganizationRoleDTO orgRoleDto) {
        return this.orgRole = organizationRoleStore.createOrganizationRole(this.mapperOrgRole.toOrganizationRole(orgRoleDto));
    }

    /**
     * Create an specialist doctor by receiving an specialist doctor DTO as a parameter
     * @param empDto The specialist doctor DTO
     * @return the Specialist Doctor
     */
    public SpecialistDoctor createSpecialistDoctor(EmployeeDTO empDto){
        this.specialistDoctor = employeeStore.createSpecialistDoctor(empDto);
        return specialistDoctor;
    }

    /**
     * Create a employee by receiving an employee DTO as a parameter
     * @param empDto The Employee DTO
     * @return the Employee
     */
    public Employee createEmployee(EmployeeDTO empDto){
        this.emp = employeeStore.createEmployee(empDto);
        return emp;
    }

    /**
     * Saves the employee sent as parameter
     * @return True if the employee is saved in the employee store, false otherwise
     */
    public boolean saveEmployee(Employee emp){
        return this.employeeStore.addEmployee(emp);
    }

    /**
     *Transforms a employee in a user of system
     * @param emp an employee
     * @return True if the employee has been transformed into a user of the system, false otherwise
     */
    public boolean transformEmployeeInUser(Employee emp) throws IOException {
        String password = generatePassword();
        File archive = new File("loginCredentials\\" + emp.getEmployeeId() + ".txt");
        FileWriter fw = new FileWriter(archive, true);
        fw.write("ID: " + emp.getEmail().getEmail() + "\n");
        fw.write("PASSWORD: " + password + "\n");
        fw.close();
        return this.authFacade.addUserWithRole(emp.getName().getName(), emp.getEmail().getEmail(),password,orgRole.getDesignation());

    }

    /**
     * Automatically generates a password for a user
     * @return the password
     */
    private String generatePassword(){
        final String[] characters = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String aux = "";
        for (int i=0; i<10; i++) aux += characters[(int) (Math.random()*characters.length)];
        return aux;
    }



}
