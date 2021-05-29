package app.controller;

import app.controller.RegisterEmployeeController;
import app.domain.model.Company;
import app.domain.model.users.Employee;
import app.domain.model.users.SpecialistDoctor;
import app.domain.model.attributes.*;
import app.domain.store.EmployeeStore;
import app.domain.store.OrganizationRoleStore;
import app.mappers.EmployeeDTO;
import app.mappers.OrganizationRoleDTO;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class RegisterEmployeeControllerTest {
    RegisterEmployeeController controller;
    List<OrganizationRoleDTO> organizationRoleDTOList;
    List<OrganizationRole> organizationRoleList;
    OrganizationRoleStore organizationRoleStore;
    EmployeeStore employeeStore;
    SpecialistDoctor employee1;
    Employee employee2;
    OrganizationRole organizationRole;
    OrganizationRoleDTO organizationRoleDTO1;
    OrganizationRoleDTO organizationRoleDTO2;
    EmployeeDTO employeeDTO1;
    EmployeeDTO employeeDTO2;
    Company company;


    @Before
    public void setup(){
        controller = new RegisterEmployeeController();
        employeeDTO1 = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        employeeDTO2 = new EmployeeDTO(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        employee1 = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        employee2 = new Employee(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Administrator"));
        company = new Company("Many Labs");
        organizationRoleDTO1 = new OrganizationRoleDTO("Administrator");
        organizationRoleDTO2 = new OrganizationRoleDTO("Specialist Doctor");
        organizationRole = new OrganizationRole("Administrator");
        organizationRoleDTOList = new ArrayList<>();
        organizationRoleList = new ArrayList<>();
        employeeStore = company.getEmployeeStore();
        organizationRoleStore = company.getOrganizationRoleStore();
        organizationRoleDTOList.add(new OrganizationRoleDTO("ADMINISTRATOR"));
        organizationRoleDTOList.add(new OrganizationRoleDTO("RECEPTIONIST"));
        organizationRoleDTOList.add(new OrganizationRoleDTO("MEDICAL LAB TECHNICIAN"));
        organizationRoleDTOList.add(new OrganizationRoleDTO("CLINICAL CHEMISTRY TECHNICIAN"));
        organizationRoleDTOList.add(new OrganizationRoleDTO("SPECIALIST DOCTOR"));
        organizationRoleDTOList.add(new OrganizationRoleDTO("LABORATORY COORDINATOR"));

    }

    @Test
    public void getLisOfOrgRoles() {
        List<OrganizationRoleDTO> result = controller.getLisOfOrgRoles();
        for (int i=0; i<organizationRoleDTOList.size(); i++){
            Assert.assertEquals(result.get(i).getDesignation(), organizationRoleDTOList.get(i).getDesignation());
        }

    }

    @Test
    public void createOrganizationRole() {
        OrganizationRole result = controller.createOrganizationRole(organizationRoleDTO1);
        Assert.assertEquals(organizationRole, result);
    }

    @Test
    public void createSpecialistDoctor() {
        SpecialistDoctor result = controller.createSpecialistDoctor(employeeDTO2);
        Assert.assertEquals(employee1, result);

    }

    @Test
    public void createEmployee() {
        Employee result = controller.createEmployee(employeeDTO1);
        Assert.assertEquals(employee2, result);
    }

    @Test
    public void saveEmployee() {
        boolean result = controller.saveEmployee(employee1);
        Assert.assertTrue(result);
    }


    /*@Test
    public void transformEmployeeInUser() throws IOException {
        boolean result = controller.transformEmployeeInUser(controller.createEmployee(employeeDTO1));
        Assert.assertTrue(result);
    }*/
}