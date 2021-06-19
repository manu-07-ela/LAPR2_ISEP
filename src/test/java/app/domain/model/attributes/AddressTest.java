
package app.domain.model.attributes;

import app.domain.model.attributes.Address;
import org.junit.Assert;
import org.junit.Test;


public class AddressTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressNullIsNotAllowed(){new Address("");}

    @Test
    public void getAddress(){
        Address adr1 = new Address("Rua do fojo");
        String expectedResult = "Rua do fojo";
        Assert.assertEquals(expectedResult, adr1.getDesignation());

    }

    @Test
    public void addressEquals(){
        Address adr1 = new Address("Rua do fojo");
        Address adr2 = new Address("Rua do fojo");
        Assert.assertEquals(adr1, adr2);
    }
    @Test
    public void addressReferenceEquals(){
        Address adr1 = new Address("Rua do fojo");
        Address adr2 = adr1;
        Assert.assertEquals(adr1, adr2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressValidation(){
        Address adr1 = new Address("Rua do fojofrgthykuyjtgrfwxdtgikçpkiugtredrgnjmlçpº+çikhgtfdswdefghyjkloplkiyhgtfdertgjkilokuyhrthjgfdsfgthyjugfrdgthjuhg");
    }

    @Test
    public void AddressValidation2(){
        Address adr1 = new Address("tehtrrggrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgrgreggreggrgrgrgrgrgrggrgrrg");
    }

    @Test
    public void AddressEqualsReference(){
        Address adr1 = new Address("Rua das cavalas");
        Address adr2 = adr1;

        Assert.assertTrue(adr1.equals(adr2));
    }

    @Test
    public void AddressEqualsNull(){
        Address adr1 = new Address("Rua das cavalas");
        Address adr2 = null;

        Assert.assertFalse(adr1.equals(adr2));
    }

    @Test
    public void AddressEqualsClass(){
        Address adr1 = new Address("Rua das cavalas");
        Name adr2 = new Name("carlos");

        Assert.assertFalse(adr1.equals(adr2));
    }




}

