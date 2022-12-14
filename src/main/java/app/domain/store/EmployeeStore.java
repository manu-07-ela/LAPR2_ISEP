package app.domain.store;

import app.domain.model.users.Employee;
import app.domain.model.users.SpecialistDoctor;
import app.mappers.dto.EmployeeDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The different employees that the company has.
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class EmployeeStore implements Serializable {
    private static final long serialVersionUID = 1070425777620790996L;
    /**
     * List of all existing employees in the company.
     */
    private List<Employee> employees;

    /**
     * Instantiates a new EmployeeStore.
     */
    public EmployeeStore(){
        employees = new ArrayList<>();
    }

    /**
     * Creates an instance of Employee receiving an Employee DTO by parameter
     * @param empDto an employee DTO
     * @return an instance of employee
     */
    public Employee createEmployee(EmployeeDTO empDto) {
        return new Employee(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(),empDto.getSocCode(), empDto.getOrganizationRole());
    }

    /**
     * Creates an instance of specialist doctor receiving an Employee DTO by parameter
     * @param empDto an employee DTO
     * @return an instance of specialist doctor
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
     * Save the employee case it is in a valid state.
     * @param employee The employee we intend to save
     * @return true if the employee was saved. Otherwise, false.
     */
    public boolean saveEmployee(Employee employee){
        if (validateEmployee(employee) || employee == null) return false;
        return this.addEmployee(employee);
    }
    /**
     * Global validation of a Employee
     * @param employee Employee that we intend to validate
     * @return false if the employee already exists or is null. Otherwise, it returns true.
     */
    public boolean validateEmployee(Employee employee){
        if (employee == null) return false;
        return this.employees.contains(employee);
    }

    /**
     * Get the existing employees
     * @return The list of employees
     */
    public List<Employee> getEmployeesList(){
        return employees;
    }

    /**
     * Compare the employee with the other object provided.
     * @param o Object we want to compare with the employee.
     * @return true if the received object represents another employee equivalent to the employee. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeStore that = (EmployeeStore) o;
        return Objects.equals(employees, that.employees);
    }

}
