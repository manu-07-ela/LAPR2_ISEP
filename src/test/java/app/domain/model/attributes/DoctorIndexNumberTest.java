
package app.domain.model.attributes;

import app.domain.model.attributes.DoctorIndexNumber;
import org.junit.Assert;
import org.junit.Test;

public class DoctorIndexNumberTest {

    @Test(expected = NullPointerException.class)
    public void ensureDoctorIndexNumberNullIsNotAllowed(){new DoctorIndexNumber("");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoctorIndexNumberMeetsAC6_1(){new DoctorIndexNumber("1234567");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoctorIndexNumberMeetsAC6_2(){new DoctorIndexNumber("123");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoctorIndexNumberMeetsAC6_3(){new DoctorIndexNumber("1adt57");}

    @Test
    public void getDoctorIndexNumber(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber("123456");
        String expectedResult = "123456";
        Assert.assertEquals(expectedResult, docNum1.getNumber());

    }
    @Test
    public void doctorIndexNumberEquals(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber("123456");
        DoctorIndexNumber docNum2 = new DoctorIndexNumber("123456");
        Assert.assertEquals(docNum1, docNum2);
    }
    @Test
    public void doctorIndexNumberReferenceEquals(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber("123456");
        DoctorIndexNumber docNum2 = docNum1;
        Assert.assertEquals(docNum1, docNum2);
    }

    @Test
    public void doctorIndexNumberNull(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber("123456");
        DoctorIndexNumber docNum2 = null;
        Assert.assertFalse(docNum1.equals(docNum2));
    }

    @Test
    public void doctorIndexNumberOtherClass(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber("123456");
        Address adrs1 = new Address("Rua da cavala");
        Assert.assertFalse(docNum1.equals(adrs1));
    }





}

