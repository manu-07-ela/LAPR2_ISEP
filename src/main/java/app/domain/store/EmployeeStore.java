package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import auth.domain.model.Email;
import java.util.ArrayList;
import java.util.List;

/**
 * The different employees that the company has.
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class EmployeeStore {
    /**
     * List of all existing employees in the company.
     */
    List<Employee>  employees;

    /**
     * Instantiates a new EmployeeStore.
     */
    public EmployeeStore(){
        employees = new ArrayList<>();
    }

    /**
     * Create a new employee instance
     * @param name employee name
     * @param email employee email
     * @param address employee address
     * @param phoneNumber employee phone number
     * @param socCode employee SOC code
     * @param organizationRole employee organization role
     * @return an Employee
     */
    public Employee createEmployee(String name, Email email, String address, int phoneNumber, int socCode, OrganizationRole organizationRole) {
        return new Employee(name, email, address, phoneNumber, socCode, organizationRole);
    }

    /**
     * Create a new specialist doctor instance
     * @param name specialist doctor name
     * @param email specialist doctor email
     * @param address specialist doctor address
     * @param phoneNumber specialist doctor phone number
     * @param socCode specialist doctor SOC code
     * @param organizationRole specialist doctor organization role
     * @param doctorIndexNumber specialist doctor index number
     * @return a Specialist Doctor
     */
    public SpecialistDoctor createSpecialistDoctor(String name, Email email, String address, int phoneNumber, int socCode, OrganizationRole organizationRole, int doctorIndexNumber){
        return new SpecialistDoctor(name, email, address, phoneNumber, socCode, organizationRole, doctorIndexNumber);
    }

    /**
     * Adds a new employee to the List
     * @param employee Employee we want to add to the List.
     * @return true if the employee is added to the List, false otherwise.
     */
    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }

    /**
     * Global validation of a Employee
     * @param employee Employee that we intend to validate
     * @return false if the employee already exists or is null. Otherwise, it returns true.
     */
    public boolean validateEmployee(Employee employee){
        return employee == null ? false : !this.employees.contains(employee);
    }

    /**
     * Get the existing employees
     * @return The list of employees
     */
    public List<Employee> getEmployeesList(){
        return employees;
    }




}
