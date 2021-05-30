package app.mappers.dto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateDTOTest {

    @Test
    public void dateDtoEquals(){
        Date date = new Date(2020,12,9,11,30);
        DateDTO tDto1 = new DateDTO(date);
        DateDTO tDto2 = new DateDTO(date);
        Assert.assertEquals(tDto1,tDto2);
    }

    @Test
    public void testDtoNotEqualsNull(){
        Date date = new Date(2020,12,9,11,30);
        DateDTO d = null;
        DateDTO tDto1 = new DateDTO(date);
        Assert.assertNotEquals(d,tDto1);
    }

    @Test
    public void testDtoRefEquals(){
        Date date = new Date(2020,12,9,11,30);
        DateDTO tDto1 = new DateDTO(date);
        DateDTO d = tDto1;
        Assert.assertEquals(tDto1,d);
    }

}