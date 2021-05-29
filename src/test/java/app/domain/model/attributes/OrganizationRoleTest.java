
package app.domain.model.attributes;

import app.domain.model.attributes.OrganizationRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OrganizationRoleTest {

    OrganizationRole orgRole;

    @Before
    public void setUp(){
        orgRole = new OrganizationRole("Laboratory Coordinator");
    }

    @Test(expected = NullPointerException.class)
    public void ensureOrganizationRoleNullIsNotAllow(){
        new OrganizationRole("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureOrganizationRoleObeyAC7(){
        new OrganizationRole("MEDICAL LABORATORY COORDINATOR OF MANYLABS");
    }
    @Test
    public void getDesignation() {
        String expectedResult = "Laboratory Coordinator";
        String result = orgRole.getDesignation();
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void organizationRoleEquals(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");

        Assert.assertEquals(org1, orgRole);
    }

    @Test
    public void organizationRoleReferenceEquals(){
        OrganizationRole org1 = orgRole;

        Assert.assertEquals(org1, orgRole);
    }


}

