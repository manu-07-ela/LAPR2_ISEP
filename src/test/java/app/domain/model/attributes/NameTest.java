
package app.domain.model.attributes;

import app.domain.model.attributes.Name;
import org.junit.Assert;
import org.junit.Test;

public class NameTest {

    @Test(expected = NullPointerException.class)
    public void ensureNameNullIsNotAllowed(){new Name("");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameMeetsAC9(){new Name("Maria Lucia Lima de Ferreira Carvalho");}

    @Test
    public void getName(){
        Name name1 = new Name("Manuela de Araujo Leite");
        String expectedResult = "Manuela de Araujo Leite";
        Assert.assertEquals(expectedResult, name1.getDesignation());
    }

    @Test
    public void NameEquals(){
        Name name1 = new Name("Manuela de Araujo Leite");
        Name name2 = new Name("Manuela de Araujo Leite");
        Assert.assertTrue(name1.equals(name2));
    }

    @Test
    public void nameReferenceEquals(){
        Name name1 = new Name("Manuela de Araujo Leite");
        Name name2 = name1;
        Assert.assertTrue(name1.equals(name2));
    }

    @Test
    public void NameEqualsNull(){
        Name name1 = new Name("Manuela de Araujo Leite");
        Name name2 = null;
        Assert.assertFalse(name1.equals(name2));
    }

    @Test
    public void NameEqualsOtherClass(){
        Name name1 = new Name("Manuela de Araujo Leite");
        Address name2 = new Address("Rua das cavalas");
        Assert.assertFalse(name1.equals(name2));
    }

    @Test
    public void NameValidation(){
        Name name = new Name("Maria Lucia Lima de Ferreira Carval");
    }



}

