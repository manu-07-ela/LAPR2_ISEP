package app.mappers.dto;

import org.junit.Assert;
import org.junit.Test;

public class TestDtoTest {

    @Test
    public void getInternalCode() {
        TestDTO tDto = new TestDTO("123456789123","Zaragatoa");
        String result = tDto.getInternalCode();
        Assert.assertEquals("123456789123",result);
    }

}