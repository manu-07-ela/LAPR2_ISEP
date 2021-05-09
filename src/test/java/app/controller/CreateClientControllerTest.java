package app.controller;

import app.domain.model.Client;
import app.mappers.dto.ClientDto;
import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.*;

public class CreateClientControllerTest {

    CreateClientController controller;
    ClientDto clientDto1;
    Client cl;

    @Before
    public void setup(){
        controller = new CreateClientController();
        clientDto1 = new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        cl = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");

    }

//    @Test
//    public void createClient() {
//        Client result = controller.CreateClient(clientDto1);
//        Assert.assertEquals(employee1, result);
//    }

//    @Test
//    public void saveClient() throws IOException {
//        boolean result = controller.saveClient();
//        Assert.assertTrue(result);
//    }

}