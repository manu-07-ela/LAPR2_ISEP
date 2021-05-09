package app.mappers.dto;

import app.domain.model.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String result = clDto.getCitizencardnumber();
        Assert.assertEquals("1234567891234567",result);
    }

    @Test
    public void getNhs() {
        String result = clDto.getNhs();
        Assert.assertEquals("1234567891",result);
    }

    @Test
    public void getDate() {
        String result = clDto.getDate();
        Assert.assertEquals("12/12/1995",result);
    }

    @Test
    public void getSex() {
        String result = clDto.getSex();
        Assert.assertEquals("Male",result);
    }

    @Test
    public void getTin() {
        String result = clDto.getTin();
        Assert.assertEquals("1234567891",result);
    }

    @Test
    public void getPhonenumber() {
        String result = clDto.getPhonenumber();
        Assert.assertEquals("12345678910",result);
    }

    @Test
    public void getEmail() {
        String result = clDto.getEmail();
        Assert.assertEquals("pessoa@gmail.com",result);
    }

    @Test
    public void ClientDtoEquals() {
        ClientDto cl1 = new ClientDto("José Teixeira","1234567891234777","1234567777","12/12/2000","Female","1234567777","12345678777","teixeira@gmail.com");
        ClientDto cl2 = new ClientDto("José Teixeira","1234567891234777","1234567777","12/12/2000","Female","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void ClientDtoRefEquals(){
        ClientDto cl1 = new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        ClientDto cl2 = cl1;
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void ClientDtoNotEqualsNull(){
        ClientDto cl1 = new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        ClientDto cl2 = null;
        Assert.assertNotEquals(cl1,cl2);
    }

    @Test
    public void ClientDtoNotEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567777","12/12/2000","Female","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertNotEquals(cl1,cl2);
    }
}