package app.mappers.dto;

import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientDTOTest {

    ClientDTO clDto;

    @Test
    public void getName() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getName();
        Assert.assertEquals("José Pessoa",result);
    }

    @Test
    public void getCitizencardnumber() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getCitizenCardNumber();
        Assert.assertEquals("1234567892345678",result);
    }

    @Test
    public void getNhs() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getNhs();
        Assert.assertEquals("1234567891",result);
    }

    @Test
    public void getDate() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getDate();
        Assert.assertEquals("12/12/1995",result);
    }

    @Test
    public void getSex() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getSex();
        Assert.assertEquals("Male",result);
    }

    @Test
    public void getTin() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getTin();
        Assert.assertEquals("1234567890",result);
    }

    @Test
    public void getPhonenumber() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getPhoneNumber();
        Assert.assertEquals("12345678911",result);
    }

    @Test
    public void getEmail() {
        clDto=new ClientDTO("José Pessoa","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        String result = clDto.getEmail();
        Assert.assertEquals("pessoa@gmail.com",result);
    }

}