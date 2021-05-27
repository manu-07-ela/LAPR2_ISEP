//package app.mappers;
//
//import app.domain.model.attributes.OrganizationRole;
//import app.mappers.dto.OrganizationRoleDTO;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//public class OrganizationRoleMapperTest {
//
//    OrganizationRoleDTO orgRoleDto;
//    OrganizationRole orgRole;
//    List<OrganizationRole> organizationRoleList;
//    List<OrganizationRoleDTO> organizationRoleDTOList;
//    OrganizationRoleMapper organizationRoleMapper;
//
//    @Before
//    public void setup(){
//        orgRoleDto = new OrganizationRoleDTO("Administrator");
//        orgRole = new OrganizationRole("Administrator");
//        organizationRoleList = new ArrayList<>();
//        organizationRoleDTOList = new ArrayList<>();
//        organizationRoleDTOList.add(orgRoleDto);
//        organizationRoleList.add(orgRole);
//        organizationRoleMapper = new OrganizationRoleMapper();
//
//    }
//
//    @Test
//    public void toDTO() {
//        OrganizationRoleDTO result = organizationRoleMapper.toDTO(orgRole);
//        Assert.assertTrue(orgRoleDto.getDesignation().equals(result.getDesignation()));
//    }
//
//    @Test
//    public void toOrganizationRole() {
//        OrganizationRole result = organizationRoleMapper.toOrganizationRole(orgRoleDto);
//        Assert.assertEquals(result, orgRole);
//    }
//
//    /*@Test
//    public void listOrgRolesDto() {
//        List<OrganizationRoleDTO> result = organizationRoleMapper.listOrgRolesDto(organizationRoleList);
//        Assert.assertEquals(organizationRoleDTOList, result);
//
//    }*/
//}