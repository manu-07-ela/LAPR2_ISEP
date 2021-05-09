package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.model.attributes.*;
import app.mappers.dto.EmployeeDTO;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class EmployeeStoreTest {

    Employee emp;
    SpecialistDoctor spcDoc;
    EmployeeDTO empDto1;
    EmployeeDTO empDto2;
    List<Employee> employess;
    EmployeeStore empStore;

    @Before
    public void setup(){
        emp = new Employee(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        spcDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        empDto1 = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        empDto2 = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        empStore = new EmployeeStore();
        employess = new ArrayList<>();
        employess.add(emp);

    }
    @Test
    public void createEmployee() {
        Employee emp1 = empStore.createEmployee(empDto1);
        Assert.assertEquals(emp, emp1);
    }

    @Test
    public void createSpecialistDoctor() {
        SpecialistDoctor spcDoc1 = empStore.createSpecialistDoctor(empDto2);
        Assert.assertEquals(spcDoc, spcDoc1);
    }


   @Test
    public void validateValidEmployee() {
        boolean result1 = empStore.validateEmployee(emp);
        boolean result2 = empStore.validateEmployee(spcDoc);

        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
    }

    @Test public void validateInvalidEmployee(){
        empStore.addEmployee(emp);
        boolean result = empStore.validateEmployee(emp);
        Assert.assertTrue(result);
    }

    @Test public void validateNullEmployee(){
        Employee emp1 = null;
        boolean result = empStore.validateEmployee(emp1);
        Assert.assertFalse(result);

    }
    @Test
    public void saveValidEmployee() {
        boolean result = empStore.saveEmployee(emp);
        Assert.assertTrue(result);
    }

    @Test
    public void saveInvalidEmployee() {
        empStore.saveEmployee(emp);
        boolean result = empStore.saveEmployee(emp);
        Assert.assertFalse(result);
    }

    @Test
    public void saveNullParameterCategory(){
        Employee emp1 = null;
        boolean result = empStore.saveEmployee(emp1);
        Assert.assertFalse(result);
    }

    @Test
    public void getEmployeesList() {
        empStore.addEmployee(emp);
        List<Employee> result = empStore.getEmployeesList();
        Assert.assertEquals(employess,result);

    }
}