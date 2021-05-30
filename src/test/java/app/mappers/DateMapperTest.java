package app.mappers;

import app.mappers.dto.DateDTO;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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