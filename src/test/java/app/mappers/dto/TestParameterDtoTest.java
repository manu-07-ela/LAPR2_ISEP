package app.mappers.dto;

import app.domain.model.testrelated.TestParameter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestParameterDtoTest {

    @Test
    public void testParameterDtoRefEquals(){
        TestParameterDTO tDto1 = new TestParameterDTO("test", "1f5ac");
        TestParameterDTO tDto2 = tDto1;
        Assert.assertEquals(tDto1,tDto2);
    }

    @Test
    public void testParameterDtoNull(){
        TestParameterDTO tDto1 = new TestParameterDTO("test", "1f5ac");
        TestParameterDTO tDto2 = null;
        Assert.assertNotEquals(tDto1,tDto2);
    }

}