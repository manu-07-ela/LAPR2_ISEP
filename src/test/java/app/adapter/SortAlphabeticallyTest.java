package app.adapter;

import app.domain.model.users.Client;
import app.mappers.dto.ClientDTO;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SortAlphabeticallyTest {

    @Test
    public void orderClientList() {
        ClientDTO cl1 = new ClientDTO("Carlos","123456789012","02/05/2020","female","1234567890","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl2 = new ClientDTO("Ana","123456789012","02/05/2020","female","1234567890","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl3 = new ClientDTO("Daniel","123456789012","02/05/2020","female","1234567890","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl4 = new ClientDTO("Joana","123456789012","02/05/2020","female","1234567890","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl5 = new ClientDTO("Ricardo","123456789012","02/05/2020","female","1234567890","12345678901","lola@gmail.com","Rua das cavalas");

        List<ClientDTO> listResult = new ArrayList<>();
        listResult.add(cl1);
        listResult.add(cl2);
        listResult.add(cl3);
        listResult.add(cl4);
        listResult.add(cl5);

        List<ClientDTO> listExpected = new ArrayList<>();
        listExpected.add(cl2);
        listExpected.add(cl1);
        listExpected.add(cl3);
        listExpected.add(cl4);
        listExpected.add(cl5);

        SortAlphabetically sortAlphabetically = new SortAlphabetically();
        listResult = sortAlphabetically.orderClientList(listResult);

        Assert.assertEquals(listExpected,listResult);


    }
}