package app.mappers.dto;

import app.domain.model.TestType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryDtoTest {

    ParameterCategoryDto pcDto;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDto("12345","test");
    }

    @Test
    public void getCode() {
        String result = pcDto.getCode();
        Assert.assertEquals("12345",result);
    }

    @Test
    public void getName() {
        String result = pcDto.getName();
        Assert.assertEquals("test",result);
    }
}