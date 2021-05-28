package app.domain.model.users;

import app.domain.model.attributes.*;
import app.domain.model.users.Employee;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
    Employee emp;
    Employee empAux;

    @Before
    public void setup(){
        emp = new Employee(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        empAux = new Employee(new Name("Julia Ferreira Marcia"), new Email("julia@gmail.com"), new Address("Rua da boavista"), new PhoneNumber("12345267182"), new SocCode("3425"), new OrganizationRole("Receptionist"));
    }

    /*@Test
    public void getEmployeeId() {
        String expectedResult1 = "MDAL00000";
        String expectedResult2 = "JFM00001";
        String result1 = emp.getEmployeeId();
        String result2 = empAux.getEmployeeId();
        Assert.assertEquals(expectedResult1, result1);
        Assert.assertEquals(expectedResult2, result2);
    }*/

    @Test(expected = NullPointerException.class)
    public void ensureNullIsNotAllowed(){new Employee(null, null, null, null, null, null);}

    @Test
    public void ensureEmployeeObeysAllAc(){
        Assert.assertNotNull(emp);
    }

    @Test
    public void getName() {
        Name result = emp.getName();
        Name expectedResult = new Name("Manuela de Araujo Leite");
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getEmail() {
        Email result = emp.getEmail();
        Email expectedResult = new Email("1200720@isep.ipp.pt");
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getAddress() {
        Address result = emp.getAddress();
        Address expectedResult = new Address("Rua 15");
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getPhoneNumber() {
        PhoneNumber result = emp.getPhoneNumber();
        PhoneNumber expectedResult = new PhoneNumber("12338725367");
        Assert.assertEquals(expectedResult, result);
    }



    @Test
    public void getSocCode() {
        SocCode result = emp.getSocCode();
        SocCode expectedResult = new SocCode("1234");
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getEmployeeRole() {
        OrganizationRole result = emp.getEmployeeRole();
        OrganizationRole expectedResult = new OrganizationRole("Administrator");
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void EmployeeEquals() {
        Employee emp1 = new Employee(new Name("Manuela Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        Employee emp2 = new Employee(new Name("Manuela de Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12334565367"),new SocCode("1234"), new OrganizationRole("Specialist doctor"));
        Assert.assertEquals(emp1, emp2);
    }

    @Test
    public void EmployeeNotEquals() {
        Employee emp1 = new Employee(new Name("Manuela Leite"), new Email("1200320@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        Employee emp2 = new Employee(new Name("Manuela de Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 30"),new PhoneNumber("12338345367"),new SocCode("1234"), new OrganizationRole("Administrator"));

        Assert.assertFalse(emp1.getEmail().equals(emp2.getEmail()));
    }

    @Test
    public void referenceEquals() {
        Employee emp1 = new Employee(new Name("Manuela Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        Employee emp2 = emp1;

        Assert.assertEquals(emp1, emp2);
    }


}