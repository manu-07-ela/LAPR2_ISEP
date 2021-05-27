//package app.mappers;
//
//import app.domain.model.Employee;
//import app.domain.model.SpecialistDoctor;
//import app.domain.model.attributes.*;
//import app.mappers.dto.EmployeeDTO;
//import auth.domain.model.Email;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class EmployeeMapperTest {
//    EmployeeDTO empDto1;
//    Employee emp1;
//    EmployeeDTO empDto2;
//    List<Employee> listEmp;
//    EmployeeMapper employeeMapper;
//    List<EmployeeDTO> employeeDTOList;
//
//    @Before
//    public void setup(){
//        empDto1 = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
//        emp1 = new Employee(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
//        empDto2 = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
//        listEmp = new ArrayList<>();
//        listEmp.add(emp1);
//        employeeDTOList = new ArrayList<>();
//        employeeDTOList.add(empDto2);
//        employeeMapper = new EmployeeMapper();
//    }
//
//    @Test
//    public void toDTO() {
//        EmployeeDTO result = employeeMapper.toDTO(emp1);
//        Assert.assertTrue(empDto2.getName().equals(result.getName()) && empDto2.getEmail().equals(result.getEmail()) && empDto2.getPhoneNumber().equals(result.getPhoneNumber()));
//    }
//
//    /*@Test
//    public void listEmployeeDto() {
//        List<EmployeeDTO> result = employeeMapper.listEmployeeDto(listEmp);
//        Assert.assertEquals(employeeDTOList, result);
//    }*/
//
//    @Test
//    public void toEmployee() {
//        Employee result = employeeMapper.toEmployee(empDto2);
//        Assert.assertTrue(empDto2.getEmail().equals(result.getEmail()));
//    }
//
//    @Test
//    public void toSpecialistDoctor() {
//        SpecialistDoctor result = employeeMapper.toSpecialistDoctor(empDto1);
//        Assert.assertTrue(empDto1.getName().equals(result.getName()) && empDto1.getEmail().equals(result.getEmail()) && empDto1.getPhoneNumber().equals(result.getPhoneNumber()) && empDto1.getDoctorIndexNumber().equals(result.getDoctorIndexNumber()));
//    }
//}