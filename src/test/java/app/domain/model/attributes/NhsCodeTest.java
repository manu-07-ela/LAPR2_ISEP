package app.domain.model.attributes;

import app.domain.model.users.Client;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class NhsCodeTest extends TestCase {


    @Test
    public void testGetCode() {
        NhsCode nhs1 = new NhsCode("123123123123");
        String expectedResult = "123123123123";
        Assert.assertEquals(expectedResult, nhs1.getCode());
    }

    @Test
    public void testTestEquals() {
        NhsCode nhs1 = new NhsCode("123123123123");
        NhsCode nhs2 = new NhsCode("123123123123");
        Assert.assertEquals(nhs1, nhs2);
    }

    @Test
    public void testTestReferenceEquals() {
        NhsCode nhs1 = new NhsCode("123123123123");
        NhsCode nhs2 = nhs1;
        Assert.assertTrue(nhs1.equals(nhs2));
    }

    @Test
    public void testTestEqualsNull() {
        NhsCode nhs1 = new NhsCode("123123123123");
        NhsCode nhs2 = null;
        Assert.assertFalse(nhs1.equals(nhs2));
    }

    @Test
    public void testTestEqualsOtherCLass() {
        NhsCode nhs1 = new NhsCode("123123123123");
        Address name2 = new Address("Rua das cavalas");
        Assert.assertFalse(nhs1.equals(name2));
    }


}