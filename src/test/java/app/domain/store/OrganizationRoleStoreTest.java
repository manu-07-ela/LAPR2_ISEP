package app.domain.store;

import app.domain.model.attributes.OrganizationRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrganizationRoleStoreTest {

    OrganizationRole orgRole;
    List<OrganizationRole> orgRoleList;
    OrganizationRoleStore orgRoleStore;

    @Before
    public void setup(){
        orgRole = new OrganizationRole("ADMINISTRATOR");
        orgRoleStore = new OrganizationRoleStore();
        orgRoleList = new ArrayList<>();
        orgRoleList.add(new OrganizationRole("ADMINISTRATOR"));
        orgRoleList.add(new OrganizationRole("RECEPTIONIST"));
        orgRoleList.add(new OrganizationRole("MEDICAL LAB TECHNICIAN"));
        orgRoleList.add(new OrganizationRole("CLINICAL CHEMISTRY TECHNICIAN"));
        orgRoleList.add(new OrganizationRole("SPECIALIST DOCTOR"));
        orgRoleList.add(new OrganizationRole("LABORATORY COORDINATOR"));
    }

    @Test
    public void getListOrgRoles() {
        List<OrganizationRole> result = orgRoleStore.getListOrgRoles();
        Assert.assertEquals(orgRoleList,result);
    }

    @Test
    public void createValidOrganizationRole() {
        OrganizationRole result = orgRoleStore.createOrganizationRole(orgRole);
        Assert.assertEquals(orgRole, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidOrganizationRole(){
        orgRoleStore.createOrganizationRole(new OrganizationRole("MEDICAL LABORATORY COORDINATOR"));
    }

    @Test
    public void validateAValidOrganizationRole() {
        boolean result = orgRoleStore.saveOrganizationRole(orgRole);
        Assert.assertFalse(result);

    }

    @Test
    public void validateAInvalidOrganizationRole(){
        boolean result = orgRoleStore.validateOrganizationRole(new OrganizationRole("MEDICAL LABORATORY COORDINATOR"));
        Assert.assertTrue(result);
    }
}
