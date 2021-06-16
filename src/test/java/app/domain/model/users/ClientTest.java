
package app.domain.model.users;

import app.domain.model.users.Client;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullIsNotAllowed(){
        new Client(null,null,null,null,null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameLengthValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void citizenCardNumberNumericValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567aaaaa","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void citizenCardNumberLengthValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567010101","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nhsNumericValidation(){
        new Client("José Pessoa","1234567891231111","12345678aa","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nhsLengthValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","12345678910000","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dateformatValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1965","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dateageLengthValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12-12-1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sexValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Transgender","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tinNumericValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tinLengthValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","12312312312132","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void phonenumberNumericValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","1234567890a","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void phonenumberLengthValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900111","pessoa@gmail.com","Avenida da República");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emailformatValidation(){
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoagmail.com","Avenida da República");
    }

    @Test
    public void citizencardnumberEquals(){
        Client c1 = new Client("José P","1234567891234567","1234567811","12/12/1991","1231231222","12345678911","pessoaasdasda@gmail.com","Rua da República");
        Client c2 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
        Assert.assertEquals(c1,c2);
    }

    @Test
    public void nhsEquals(){
        Client c1 = new Client("José David Pedrosa","1234567891234522","1234567891","12/12/1991","1231231238","42345678900","pedrosa@gmail.com","Rua da República");
        Client c2 = new Client("José David Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
        Assert.assertEquals(c1,c2);
    }

    @Test
    public void tinEquals(){
        Client c1 = new Client("José Pedrosa","1234567891234587","1234567791","12/10/1995","1231231231","12345608900","pedrosa@gmail.com","Rua da República");
        Client c2 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
        Assert.assertEquals(c1,c2);
    }

    @Test
    public void phonenumberEquals(){
        Client c1 = new Client("José Pedrosa","2234567891234567","2234567891","14/12/1995","3231231231","12345678900","pedrosa@gmail.com","Rua da República");
        Client c2 = new  Client("José Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
        Assert.assertEquals(c1,c2);
    }

    @Test
    public void emailEquals(){
        Client c1 = new Client("José Pedrosa","2234567891234567","2234567891","14/12/1995","3231231231","12345678900","pedrosa@gmail.com","Rua da República");
        Client c2 = new Client("José Pedrosa","2234567891234511","2234567881","14/12/1991","3231231221","12345678910","pedrosa@gmail.com","Travessa da República");
        Assert.assertEquals(c1,c2);
    }

    @Test
    public void nullReferenceEquals(){
        Client c1 = new Client("José Pedrosa","2234567891234567","2234567891","14/12/1995","3231231231","12345678900","pedrosa@gmail.com","Rua da República");
        Client cl2 = null;
        Assert.assertNotEquals(c1,cl2);
    }

}

