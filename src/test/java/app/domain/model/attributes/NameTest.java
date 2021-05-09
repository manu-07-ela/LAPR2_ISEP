package app.domain.model.attributes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

    @Test(expected = NullPointerException.class)
    public void ensureNameNullIsNotAllowed(){new Name("");}

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameMeetsAC9(){new Name("Maria Lucia Lima de Ferreira Carvalho");}

    @Test
    public void getName(){
        Name name1 = new Name("Manuela de Araujo Leite");
        String expectedResult = "Manuela de Araujo Leite";
        Assert.assertEquals(expectedResult, name1.getName());

    }

    @Test
    public void NameEquals(){
        Name name1 = new Name("Manuela de Araujo Leite");
        Name name2 = new Name("Manuela de Araujo Leite");
        Assert.assertEquals(name1, name2);
    }
    @Test
    public void nameReferenceEquals(){
        Name name1 = new Name("Manuela de Araujo Leite");
        Name name2 = name1;
        Assert.assertEquals(name1, name2);
    }



}