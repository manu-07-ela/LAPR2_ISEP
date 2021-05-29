
package app;

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
        new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void citizenCardNumberNumericValidation(){
        new Client("José Pessoa","123456789123aaaa","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void citizenCardNumberLengthValidation(){
        new Client("José Pessoa","123456789123111111","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nhsNumericValidation(){
        new Client("José Pessoa","1234567891231111","12345678aa","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nhsLengthValidation(){
        new Client("José Pessoa","1234567891231111","123456789111","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dateformatValidation(){
        new Client("José Pessoa","1234567891231111","123456789111","12/12/1869","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dateageLengthValidation(){
        new Client("José Pessoa","1234567891231111","123456789111","12-12-1995","Male","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sexValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Transgender","1234567891","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tinNumericValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","12345678aa","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tinLengthValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","123456789111","12345678910","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void phonenumberNumericValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","123456789aa","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void phonenumberLengthValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","1234567891011","pessoa@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emailformatValidation(){
        new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoagmail.com");
    }
    @Test
    public void nameEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Pessoa","1234567891234777","1234567777","12/12/2000","Female","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void citizencardnumberEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234567","1234567777","12/12/2000","Female","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void nhsEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567891","12/12/2000","Female","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void dateEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567777","12/12/1995","Female","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void sexEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567777","12/12/2000","Male","1234567777","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void tinEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567777","12/12/2000","Female","1234567891","12345678777","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void phonenumberEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567777","12/12/2000","Female","1234567777","12345678910","teixeira@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void emailEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = new Client("José Teixeira","1234567891234777","1234567777","12/12/2000","Female","1234567777","12345678777","pessoa@gmail.com");
        Assert.assertEquals(cl1,cl2);
    }

    @Test
    public void nullReferenceEquals(){
        Client cl1 = new Client("José Pessoa","1234567891234567","1234567891","12/12/1995","Male","1234567891","12345678910","pessoa@gmail.com");
        Client cl2 = null;
        Assert.assertNotEquals(cl1,cl2);
    }

}

