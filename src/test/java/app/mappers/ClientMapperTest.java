package app.mappers;

import app.domain.model.Client;
import app.domain.model.ParameterCategory;
import app.mappers.dto.ClientDto;
import app.mappers.dto.ParameterCategoryDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientMapperTest {

    ClientDto clDto;
    Client cl;
    ClientMapper clMapper;

    public void setup(){
        clDto=new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        cl=new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        clMapper = new ClientMapper();
    }

//    @Test
//    public void toModel() {
//        Client result = clMapper.toModel(clDto);
//        Assert.assertEquals(cl,result);
//    }
}