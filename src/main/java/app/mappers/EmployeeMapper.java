package app.mappers;

import app.domain.model.users.Employee;
import app.domain.model.users.SpecialistDoctor;
import app.mappers.dto.EmployeeDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Transform objects of type Employee into objects of type EmployeeDTO and vice versa
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class EmployeeMapper {
    /**
     *Transforms an object of type Employee into an object of type EmployeeDTO
     * @param emp an Employee object
     * @return an instance of EmployeeDTO
     */
    public EmployeeDTO toDTO(Employee emp){
        return new EmployeeDTO(emp.getName(), emp.getEmail(), emp.getAddress(),emp.getPhoneNumber(), emp.getSocCode(), emp.getEmployeeRole());
    }

    /**
     * Transforms a list of objects of type Employee into a list of objects of type EmployeeDTO
     * @param employee a list of employees
     * @return a list of employees DTO
     */
    public List<EmployeeDTO> listEmployeeDto(List<Employee> employee){
        List<EmployeeDTO> employeeDto = new ArrayList<>();

        for (Employee emp : employee){
            employeeDto.add(this.toDTO(emp));
        }
        return employeeDto;
    }

    /**
     *Transforms an object of type EmployeeDTO into an object of type Employee
     * @param empDto an EmployeeDTO object
     * @return an instance of Employee
     */
    public Employee toEmployee(EmployeeDTO empDto){
        return new Employee(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(), empDto.getSocCode(), empDto.getOrganizationRole());
    }

    /**
     *Transforms an object of type EmployeeDTO into an object of type SpecialistDoctor
     * @param empDto an EmployeeDTO object
     * @return an instance of SpecialistDoctor
     */
    public SpecialistDoctor toSpecialistDoctor(EmployeeDTO empDto){
        return new SpecialistDoctor(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(), empDto.getSocCode(), empDto.getOrganizationRole(), empDto.getDoctorIndexNumber());
    }




}
