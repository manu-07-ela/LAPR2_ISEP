package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.mappers.dto.EmployeeDTO;
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
     *
     * @param empDto
     * @return
     */
    public Employee createEmployee(EmployeeDTO empDto) {
        return new Employee(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(),empDto.getSocCode(), empDto.getOrganizationRole());
    }

    /**
     *
     * @param empDto
     * @return
     */
    public SpecialistDoctor createSpecialistDoctor(EmployeeDTO empDto){
        return new SpecialistDoctor(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(),empDto.getSocCode(), empDto.getOrganizationRole(), empDto.getDoctorIndexNumber());
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
