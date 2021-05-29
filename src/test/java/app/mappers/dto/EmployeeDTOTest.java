package app.mappers.dto;

import app.domain.model.attributes.*;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeDTOTest {

    EmployeeDTO employeeDto;
    @Before
    public void setup(){
        employeeDto = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
    }

    @Test
    public void getName() {
        Name expectedResult = new Name("Manuela de Araujo Leite");
        Name result = employeeDto.getName();
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void getEmail() {
        Email expectedResult = new Email("1200720@isep.ipp.pt");
        Email result = employeeDto.getEmail();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getAddress() {
        Address expectedResult = new Address("Rua 15");
        Address result = employeeDto.getAddress();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getPhoneNumber() {
        PhoneNumber expectedResult = new PhoneNumber("12338725367");
        PhoneNumber result = employeeDto.getPhoneNumber();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getSocCode() {
        SocCode expectedResult = new SocCode("1234");
        SocCode result = employeeDto.getSocCode();
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void getOrganizationRole() {
        OrganizationRole expectedResult = new OrganizationRole("Specialist Doctor");
        OrganizationRole result = employeeDto.getOrganizationRole();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void getDoctorIndexNumber() {
        DoctorIndexNumber expectedResult = new DoctorIndexNumber("123456");
        DoctorIndexNumber result = employeeDto.getDoctorIndexNumber();
        Assert.assertEquals(expectedResult, result);
    }
}