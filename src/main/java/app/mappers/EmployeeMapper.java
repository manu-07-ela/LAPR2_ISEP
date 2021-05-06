package app.mappers;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public EmployeeDTO toDTO(Employee emp){
        return new EmployeeDTO(emp.getName(), emp.getEmail(), emp.getAddress(),emp.getPhoneNumber(), emp.getSocCode(), emp.getEmployeeRole());
    }

    public List<EmployeeDTO> listEmployeeDto(List<Employee> employee){
        List<EmployeeDTO> employeeDto = new ArrayList<>();

        for (Employee emp : employee){
            employeeDto.add(this.toDTO(emp));
        }
        return employeeDto;
    }

    public Employee toEmployee(EmployeeDTO empDto){
        return new Employee(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(), empDto.getSocCode(), empDto.getOrganizationRole());
    }
    public SpecialistDoctor toSpecialistDoctor(EmployeeDTO empDto){
        return new SpecialistDoctor(empDto.getName(), empDto.getEmail(), empDto.getAddress(),empDto.getPhoneNumber(), empDto.getSocCode(), empDto.getOrganizationRole(), empDto.getDoctorIndexNumber());
    }




}
