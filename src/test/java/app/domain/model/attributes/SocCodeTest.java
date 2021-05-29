
package app.domain.model.attributes;

import app.domain.model.attributes.SocCode;
import org.junit.Assert;
import org.junit.Test;

public class SocCodeTest {
    @Test(expected = NullPointerException.class)
    public void ensureSocCodeNullIsNotAllowed(){new SocCode("");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureSocCodeMeetsAC7_1(){new SocCode("1111111");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureSocCodeMeetsAC7_2(){new SocCode("1");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureSocCodeMeetsAC7_3(){new SocCode("1ah7");}

    @Test
    public void getSocCode(){
        SocCode sc1 = new SocCode("1234");
        String expectedResult = "1234";
        Assert.assertEquals(expectedResult, sc1.getCode());
    }


    @Test
    public void socCodeEquals(){
        SocCode sc1 = new SocCode("1234");
        SocCode sc2 = new SocCode("1234");
        Assert.assertEquals(sc1, sc2);
    }
    @Test
    public void socCodeReferenceEquals(){
        SocCode sc1 = new SocCode("1234");
        SocCode sc2 = sc1;
        Assert.assertEquals(sc1, sc2);
    }






}

