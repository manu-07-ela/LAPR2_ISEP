package app.adapter;

import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SortByTinTest {

    @Test
    public void orderClientList() {
        ClientDTO cl1 = new ClientDTO("Carlos","123456789012","02/05/2020","female","8421345003","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl2 = new ClientDTO("Carlos","123456789012","02/05/2020","female","4382710056","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl3 = new ClientDTO("Carlos","123456789012","02/05/2020","female","1999999999","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl4 = new ClientDTO("Carlos","123456789012","02/05/2020","female","1300000000","12345678901","lola@gmail.com","Rua das cavalas");
        ClientDTO cl5 = new ClientDTO("Carlos","123456789012","02/05/2020","female","2045689605","12345678901","lola@gmail.com","Rua das cavalas");

        List<ClientDTO> listExpected = new ArrayList<>();
        listExpected.add(cl4);
        listExpected.add(cl3);
        listExpected.add(cl5);
        listExpected.add(cl2);
        listExpected.add(cl1);

        List<ClientDTO> listResult = new ArrayList<>();
        listResult.add(cl1);
        listResult.add(cl2);
        listResult.add(cl3);
        listResult.add(cl4);
        listResult.add(cl5);

        SortByTin sort = new SortByTin();
        listResult = sort.orderClientList(listResult);

        Assert.assertEquals(listExpected,listResult);
    }
}