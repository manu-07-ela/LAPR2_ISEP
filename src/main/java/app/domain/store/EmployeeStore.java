package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.EmployeeRole;
import app.domain.model.ParameterCategory;
import app.domain.model.SpecialistDoctor;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    List<Employee>  employees;

    public EmployeeStore(){
        employees = new ArrayList<>();
    }
    public Employee createEmployee(String name, Email email, String adress, float phoneNumber, String socCode, EmployeeRole employeeRole) {
        return new Employee(name, email, adress, phoneNumber, socCode, employeeRole);
    }
    public SpecialistDoctor createSpecialistDoctor(String name, Email email, String adress, float phoneNumber, String socCode, EmployeeRole employeeRole, float doctorIndexNumber){
        return new SpecialistDoctor(name, email, adress, phoneNumber, socCode, employeeRole, doctorIndexNumber);
    }
    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }
    public boolean removeEmployee(Employee employee){
        return employees.remove(employee);
    }
    public boolean validateEmployee(Employee employee){
        return true; //see how to validate a Employee
    }
    public boolean validateParameterCategory(Employee employee){
        return employee!=null ? false : !this.employees.contains(employee);
    }
    public List<Employee> getEmployeesList(){
        return employees;
    }




}
