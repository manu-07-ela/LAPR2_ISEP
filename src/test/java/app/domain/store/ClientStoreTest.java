package app.domain.store;

import app.domain.model.users.Client;

import app.domain.store.ClientStore;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDTO;
import auth.AuthFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ClientStoreTest {

    Client cl;
    ClientStore clStore;
    ClientMapper clMapper;
    AuthFacade clauth;

    @Test
    public void createClient() {
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        ClientDTO clDTO = new ClientDTO("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        Client result = clStore.createClient(clDTO,clMapper);
        Assert.assertEquals(cl, result);
    }

    @Test
    public void validateClient1() {
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        boolean result = clStore.validateClient(cl);
        Assert.assertTrue(result);
    }

    @Test
    public void validateClient2() {
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        clStore.addClient(cl);
        boolean result = clStore.validateClient(cl);
        Assert.assertFalse(result);
    }

    @Test
    public void validateClient3(){
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        Client cl = null;
        boolean result = clStore.validateClient(cl);
        Assert.assertFalse(result);
    }

    /*@Test
    public void saveClient1() throws IOException {
        boolean result = clStore.saveClient(cl,clauth);
        Assert.assertTrue(result);
    }*/

    @Test
    public void saveClient2() throws IOException {
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        clStore.addClient(cl);
        boolean result = clStore.saveClient(cl,clauth);
        assertFalse(result);
    }

    @Test
    public void saveClient3() throws IOException {
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        Client cl = null;
        boolean result = clStore.saveClient(cl,clauth);
        Assert.assertFalse(result);
    }

    @Test
    public void getClientByEmail(){
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("Test","1234567892345678","1234567891","12/12/1995","Male","1234567890","12345678911","pessoa@gmail.com", "Rua da Paz");

        Client cl1 = clStore.getClientByEmail("pessoa@gmail.com");
        Assert.assertTrue(cl,cl1);

    }
}
