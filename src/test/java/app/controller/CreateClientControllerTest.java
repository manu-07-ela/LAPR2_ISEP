package app.controller;

import app.domain.model.users.Client;
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

    /*@Test
    public void CreateClient1(){
        company = new Company("Many Labs");
        controller = new CreateClientController();
        clDto = new ClientDTO("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        clStore = company.getClientStore();
        clStore.addClient(cl);
        boolean result = controller.CreateClient(clDto);
        Assert.assertTrue(result);
    }

    @Test
    public void createClient2() {
        company = new Company("Many Labs");
        controller = new CreateClientController();
        clDto = new ClientDTO("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        clStore = company.getClientStore();
        boolean result = controller.CreateClient(clDto);
        Assert.assertTrue(result);
    }*/

    /*
    @Test
    public void saveClient() throws IOException {
        company = new Company("Many Labs");
        controller = new CreateClientController();
        clDto = new ClientDTO("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        clStore = company.getClientStore();
        controller.CreateClient(clDto);
        clStore.addClient(cl);
        boolean result = controller.saveClient();
        Assert.assertTrue(result);
    }

    @Test
    public void saveClient2() throws IOException {
        company = new Company("Many Labs");
        controller = new CreateClientController();
        clDto = new ClientDTO("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");
        clStore = company.getClientStore();
        controller.CreateClient(clDto);
        boolean result = controller.saveClient();
        Assert.assertFalse(result);
    }*/

}