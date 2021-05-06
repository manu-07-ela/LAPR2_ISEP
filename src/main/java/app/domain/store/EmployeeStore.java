package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.domain.model.SpecialistDoctor;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    List<Employee>  employees;

    public EmployeeStore(){
        employees = new ArrayList<>();
    }

    public Employee createEmployee(String name, Email email, String adress, int phoneNumber, int socCode, OrganizationRole organizationRole) {
        return new Employee(name, email, adress, phoneNumber, socCode, organizationRole);
    }
    public SpecialistDoctor createSpecialistDoctor(String name, Email email, String adress, int phoneNumber, int socCode, OrganizationRole organizationRole, int doctorIndexNumber){
        return new SpecialistDoctor(name, email, adress, phoneNumber, socCode, organizationRole, doctorIndexNumber);
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
