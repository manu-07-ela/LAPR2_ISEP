package app.domain.store;

import app.domain.model.Client;

import app.mappers.ClientMapper;
import app.mappers.dto.ClientDto;
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

    @Before
    public void setup() {
        clStore = new ClientStore();
        clMapper = new ClientMapper();
        clauth = new AuthFacade();
        cl = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test
    public void createClient() {
        ClientDto clDTO = new ClientDto("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client result = clStore.createClient(clDTO,clMapper);
        Assert.assertEquals(cl, result);
    }

    @Test
    public void validateClient1() {
        boolean result = clStore.validateClient(cl);
        Assert.assertTrue(result);
    }

//    @Test
//    public void validateClient2() {
//        clStore.addClient(cl);
//        boolean result = clStore.validateClient(cl);
//        Assert.assertFalse(result);
//    }

    @Test
    public void validateLaboratory3(){
        Client cl = null;
        boolean result = clStore.validateClient(cl);
        Assert.assertFalse(result);
    }

    @Test
    public void saveLaboratory1() throws IOException {
        boolean result = clStore.saveClient(cl,clauth);
        Assert.assertTrue(result);
    }

//    @Test
//    public void saveLaboratory2() throws IOException {
//        clStore.addClient(cl);
//        boolean result = clStore.saveClient(cl,clauth);
//        assertFalse(result);
//    }

    @Test
    public void saveLaboratory3() throws IOException {
        Client cl = null;
        boolean result = clStore.saveClient(cl,clauth);
        Assert.assertFalse(result);
    }
}