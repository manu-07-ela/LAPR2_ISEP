package app.mappers;

import app.mappers.dto.DateDTO;
import app.mappers.dto.ParameterCategoryDTO;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class DateMapperTest {

    @Test
    public void toDto() {
        DateMapper mapper = new DateMapper();
        Date date = new Date(2020,12,9,11,30);
        DateDTO expected = new DateDTO(new Date(2020,12,9,11,30));
        Assert.assertEquals(expected,mapper.toDto(date));


    }

    @Test
    public void testToDto() {
        DateMapper mapper = new DateMapper();
        List<Date> list = new ArrayList();
        Date date = new Date(2020,12,9,11,30);
        list.add(date);
        List<DateDTO> result = mapper.toDto(list);
        List<DateDTO> lista = new ArrayList();
        DateDTO expected = new DateDTO(new Date(2020,12,9,11,30));
        lista.add(expected);
        Assert.assertEquals(lista,result);
    }
}