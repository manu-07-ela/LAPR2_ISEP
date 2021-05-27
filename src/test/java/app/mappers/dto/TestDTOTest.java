package app.mappers.dto;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDTOTest {

    @Test
    public void getInternalCode() {
        TestDTO tDto = new TestDTO("123456789123","Zaragatoa");
        String result = tDto.getInternalCode();
        Assert.assertEquals("123456789123",result);
    }

}