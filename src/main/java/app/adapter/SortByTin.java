package app.adapter;

import app.interfaces.SortingAlgorithms;
import app.mappers.dto.ClientDTO;

import java.util.List;

public class SortByTin implements SortingAlgorithms {

    /**
     * Method responsible for sorting the customer list by tin
     * @param list the list of clients
     * @return the ordered customer list
     */
    @Override
    public List<ClientDTO> orderClientList (List<ClientDTO> list) {
        int j;
        double key;
        int i;

        for (j = 1; j < list.size(); j++)
        {
            key = Double.parseDouble(list.get(j).getTin());
            for (i = j - 1; (i >= 0) && ( Double.parseDouble(list.get(i).getTin()) > key); i--)
            {
                list.set(i+1,list.get(i));
            }
            list.set(i+1,getClientByTin(list,key)) ;
        }
        return list;




    }

    private ClientDTO getClientByTin(List<ClientDTO> list, double key) {
        for (ClientDTO cl: list) {
            if (Double.parseDouble(cl.getTin()) == key ){
                return cl;
            }
        }
        return null;
    }

}
