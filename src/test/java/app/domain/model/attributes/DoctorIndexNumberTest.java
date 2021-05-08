package app.domain.model.attributes;

import org.junit.Assert;
import org.junit.Test;

public class DoctorIndexNumberTest {

    @Test(expected = NullPointerException.class)
    public void ensureDoctorIndexNumberNullIsNotAllowed(){DoctorIndexNumber docNum = new DoctorIndexNumber(null);}

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoctorIndexNumberMeetsAC6_1(){DoctorIndexNumber docNum = new DoctorIndexNumber(1234567);}

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoctorIndexNumberMeetsAC6_2(){DoctorIndexNumber docNum = new DoctorIndexNumber(123);}

    @Test
    public void doctorIndexNumberEquals(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber(123456);
        DoctorIndexNumber docNum2 = new DoctorIndexNumber(123456);
        Assert.assertEquals(docNum1, docNum2);
    }
    @Test
    public void doctorIndexNumberReferenceEquals(){
        DoctorIndexNumber docNum1 = new DoctorIndexNumber(123456);
        DoctorIndexNumber docNum2 = docNum1;
        Assert.assertEquals(docNum1, docNum2);
    }

}