package app.domain.model;

import app.domain.model.users.Client;
import org.junit.Test;


public class CSVFileReaderTest {

    @Test(expected = IllegalArgumentException.class)
    public void clientValidation(){
        Client cl= new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }
}