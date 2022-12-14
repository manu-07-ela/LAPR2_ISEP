
package app.domain.model.attributes;

import app.domain.model.attributes.PhoneNumber;
import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {
    @Test(expected = NullPointerException.class)
    public void ensurePhoneNumberNullIsNotAllowed(){new PhoneNumber("");}

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMeetsAC5_1(){new PhoneNumber("11111");}

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMeetsAC5_2(){new PhoneNumber("11111111111111111");}

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMeetsAC5_3(){new PhoneNumber("11111abgss");}

    @Test
    public void getPhoneNumber(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        String expectedResult = "12345678901";
        Assert.assertEquals(expectedResult, pn1.getNumber());
    }

    @Test
    public void phoneNumberEquals(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        PhoneNumber pn2 = new PhoneNumber("12345678901");
        Assert.assertTrue(pn1.equals(pn2));
    }

    @Test
    public void phoneNumberReferenceEquals(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        PhoneNumber pn2 = pn1;
        Assert.assertTrue(pn1.equals(pn2));
    }

    @Test
    public void phoneNumberEqualsNull(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        PhoneNumber pn2 = null;
        Assert.assertFalse(pn1.equals(pn2));
    }

    @Test
    public void phoneNumberEqualsOtherClass(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        Address name2 = new Address("Rua das cavalas");
        Assert.assertFalse(pn1.equals(name2));
    }



}

