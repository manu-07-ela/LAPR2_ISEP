package app.domain.model.attributes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {
    @Test(expected = NullPointerException.class)
    public void ensurePhoneNumberNullIsNotAllowed(){new PhoneNumber(null);}

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMeetsAC5_1(){new PhoneNumber("11111");}

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMeetsAC5_2(){new PhoneNumber("11111111111111111");}

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMeetsAC5_3(){new PhoneNumber("11111abgss");}

    @Test
    public void phoneNumberEquals(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        PhoneNumber pn2 = new PhoneNumber("12345678901");
        Assert.assertEquals(pn1, pn2);
    }
    @Test
    public void nameReferenceEquals(){
        PhoneNumber pn1 = new PhoneNumber("12345678901");
        PhoneNumber pn2 = pn1;
        Assert.assertEquals(pn1, pn2);
    }



}