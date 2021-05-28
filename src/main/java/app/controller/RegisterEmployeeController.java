package app.controller;

import app.controller.App;
import app.domain.model.*;
import app.domain.model.attributes.OrganizationRole;
import app.domain.model.users.Employee;
import app.domain.model.users.SpecialistDoctor;
import app.domain.store.EmployeeStore;
import app.domain.store.OrganizationRoleStore;
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
    private final Company company;
    /**
     *Represents an instance of the employee store
     */
    private final EmployeeStore employeeStore;
    /**
     *Represents an instance of the organization role store
     */
    private final OrganizationRoleStore organizationRoleStore;

    /**
     *Represents an instance Auth facade
     */
    private final AuthFacade authFacade;
    /**
     *Represents an instance of the employee store
     */
    private final OrganizationRoleMapper mapperOrgRole;
     /**
     *Represents an instance of organization role
     */
    private OrganizationRole orgRole;


    /**
     * Constructs an instance of {@code RegisterEmployeeController}
     */
    public RegisterEmployeeController(){
        this.company = App.getInstance().getCompany();
        this.employeeStore = company.getEmployeeStore();
        this.organizationRoleStore = company.getOrganizationRoleStore();
        this.mapperOrgRole = new OrganizationRoleMapper();
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
        this.mapperOrgRole = new OrganizationRoleMapper();
        this.authFacade = company.getAuthFacade();
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
         return employeeStore.createSpecialistDoctor(empDto);
    }

    /**
     * Create a employee by receiving an employee DTO as a parameter
     * @param empDto The Employee DTO
     * @return the Employee
     */
    public Employee createEmployee(EmployeeDTO empDto){
        return employeeStore.createEmployee(empDto);
    }

    /**
     * Saves the employee sent as parameter
     * @return True if the employee is saved in the employee store, false otherwise
     */
    public boolean saveEmployee(Employee emp){
        return this.employeeStore.saveEmployee(emp);
    }

    /**
     *Transforms a employee in a user of system
     * @param emp an employee
     * @return True if the employee has been transformed into a user of the system, false otherwise
     */
    public boolean transformEmployeeInUser(Employee emp) throws IOException {
        String password = generatePassword();
        File archive = new File("./" + emp.getEmployeeId() + ".txt");
        FileWriter fw = new FileWriter(archive, true);

        try {
            if (archive.exists()) archive.delete();
            fw.write("ID: " + emp.getEmail().getEmail() + "\n");
            fw.write("PASSWORD: " + password + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fw.close();
        }

        return this.authFacade.addUserWithRole(emp.getName().getDesignation(), emp.getEmail().getEmail(),password,orgRole.getDesignation());

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
