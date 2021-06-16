package app.mappers;

import app.domain.model.users.Client;
import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClientMapperTest {

    ClientDTO clDto;
    Client cl;
    ClientMapper clMapper;


    @Test
    public void toModel() {
        clMapper = new ClientMapper();
        clDto=new ClientDTO("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        cl=new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        Client result = clMapper.toModel(clDto);
        Assert.assertEquals(cl,result);
    }


    /*@Test
    public void toModel() {
        Client result = clMapper.toModel(clDto);
        Assert.assertEquals(cl,result);
    }*/

}