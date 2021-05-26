package app.mappers.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientDTOTest {

    ClientDTO clDto;

    @Before
    public void setup(){
        clDto=new ClientDTO("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
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

}