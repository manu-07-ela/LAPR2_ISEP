
package app.domain.model.attributes;

import app.domain.model.attributes.OrganizationRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OrganizationRoleTest {


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
        OrganizationRole orgRole = new OrganizationRole("Laboratory Coordinator");
        String expectedResult = "Laboratory Coordinator";

        String result = orgRole.getDesignation();
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void organizationRoleEquals(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");
        OrganizationRole orgRole = new OrganizationRole("Laboratory Coordinator");
        Assert.assertTrue(org1.equals(orgRole));
    }

    @Test
    public void organizationRoleReferenceEquals(){
        OrganizationRole orgRole = new OrganizationRole("Laboratory Coordinator");
        OrganizationRole org1 = orgRole;

        Assert.assertTrue(org1.equals(orgRole));
    }

    @Test
    public void organizationRoleEqualsNull(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");
        OrganizationRole orgRole = null;
        Assert.assertFalse(org1.equals(orgRole));
    }

    @Test
    public void organizationRoleEqualsOtherClass(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");
        Address name2 = new Address("Rua das cavalas");
        Assert.assertFalse(org1.equals(name2));
    }

    @Test(expected = NullPointerException.class)
    public void DescriptionValidationBlank(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");
        org1.checkRulesForDesignation("     ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void DescriptionValidationLenght(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");
        org1.checkRulesForDesignation("Maria Lucia Lima de Ferreira Carvalorfregregrger");
    }

    @Test
    public void DescriptionValidationLenght2(){
        OrganizationRole org1 = new OrganizationRole("Laboratory Coordinator");
        org1.checkRulesForDesignation("Maria Lucia Lima de Ferreira Carval");
    }



}

