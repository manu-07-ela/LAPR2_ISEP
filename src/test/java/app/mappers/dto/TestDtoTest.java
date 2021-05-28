package app.mappers.dto;

import org.junit.Assert;
import org.junit.Test;

public class TestDtoTest {

    @Test
    public void getInternalCode() {
        TestDto tDto = new TestDto("123456789123","Zaragatoa");
        String result = tDto.getInternalCode();
        Assert.assertEquals("123456789123",result);
    }

}