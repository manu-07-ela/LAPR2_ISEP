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
        for (int i = 0;i<list.size();i++) {
            for (int j=0;j< list.size();j++){
                if (Double.parseDouble(list.get(i).getTin()) < Double.parseDouble(list.get(j).getTin()) ){
                        ClientDTO temp = list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,temp);
                }
            }
        }
        return list;
    }

}
