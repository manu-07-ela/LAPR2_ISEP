package app.domain.model.attributes;

import org.junit.Assert;
import org.junit.Test;


public class AddressTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressNullIsNotAllowed(){Address adr = new Address(null);}

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

}