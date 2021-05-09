package app.mappers.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDtoTest {

    ClientDto clDto;

    @Before
    public void setup(){
        clDto=new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test
    public void getName() {
        String result = clDto.getName();
        Assert.assertEquals("José Pessoa",result);
    }

    @Test
    public void getCitizencardnumber() {
    }

    @Test
    public void getNhs() {
    }

    @Test
    public void getDate() {
    }

    @Test
    public void getSex() {
    }

    @Test
    public void getTin() {
    }

    @Test
    public void getPhonenumber() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void testEquals() {
    }
}