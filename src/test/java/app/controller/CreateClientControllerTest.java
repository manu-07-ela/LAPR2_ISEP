package app.controller;

import app.domain.model.Client;
import app.mappers.dto.ClientDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CreateClientControllerTest {

    CreateClientController controller;
    ClientDto clientDto;
    Client cl;

    @Before
    public void setup(){
        controller = new CreateClientController();
        clientDto = new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        cl = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");

    }

    @Test
    public void createClient() {
        boolean result = controller.CreateClient(clientDto);
        Assert.assertTrue(result);
    }

//    @Test
//    public void saveClient() throws IOException {
//        boolean result = controller.saveClient();
//        Assert.assertTrue(result);
//    }

}