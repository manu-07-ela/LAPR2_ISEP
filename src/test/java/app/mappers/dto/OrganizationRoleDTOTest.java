package app.mappers.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizationRoleDTOTest {

    OrganizationRoleDTO orgRoleDto;
    @Before
    public void setup(){
        orgRoleDto = new OrganizationRoleDTO("Laboratory Coordinator");
    }

    @Test
    public void getDesignation() {
        String expectedResult = "Laboratory Coordinator";
        String result = orgRoleDto.getDesignation();
        Assert.assertEquals(expectedResult, result);
    }
}