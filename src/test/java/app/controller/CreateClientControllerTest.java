/*package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.store.ClientStore;
import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class CreateClientControllerTest {

    CreateClientController controller;
    ClientDTO clDto;
    Client cl;
    ClientStore clStore;
    Company company;

    @Before
    public void setup(){
        company = new Company("Many Labs");
        controller = new CreateClientController();
        clDto = new ClientDTO("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        cl = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        clStore = company.getClientStore();
    }

    @Test
    public void CreateClient1(){
        clStore.addClient(cl);
        boolean result = controller.CreateClient(clDto);
        Assert.assertTrue(result);
    }

    @Test
    public void createClient2() {
        boolean result = controller.CreateClient(clDto);
        Assert.assertTrue(result);
    }

    @Test
    public void saveClient() throws IOException {
        controller.CreateClient(clDto);
        clStore.addClient(cl);
        boolean result = controller.saveClient();
        Assert.assertTrue(result);
    }

    @Test
    public void saveClient2() throws IOException {
        controller.CreateClient(clDto);
        boolean result = controller.saveClient();
        Assert.assertFalse(result);
    }

}*/