package app.mappers;

import app.domain.model.Client;
import app.mappers.dto.ClientDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClientMapperTest {

    ClientDto clDto;
    Client cl;
    ClientMapper clMapper;


    @Before
    public void setup(){

        clMapper = new ClientMapper();
        clDto=new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        cl=new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");

    }

    @Test
    public void toModel() {
        Client result = clMapper.toModel(clDto);
        Assert.assertEquals(cl,result);
    }


    /*@Test
    public void toModel() {
        Client result = clMapper.toModel(clDto);
        Assert.assertEquals(cl,result);
    }*/

}