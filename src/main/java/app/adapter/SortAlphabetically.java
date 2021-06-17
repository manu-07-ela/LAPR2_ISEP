package app.adapter;

import app.interfaces.SortingAlgorithms;
import app.mappers.dto.ClientDTO;

import java.util.Comparator;
import java.util.List;

public class SortAlphabetically implements SortingAlgorithms{


    @Override
    public List<ClientDTO> orderClientList (List<ClientDTO> list) {

        for (int i = 0;i<list.size();i++) {
            for (int j=0;j< list.size();j++){
                if (list.get(i).getName().compareTo(list.get(j).getName()) < 0 ){
                        ClientDTO temp = list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,temp);

                }
            }
        }
        return list;

    }

    /*@Override
    public int compare(Object o1, Object o2) {
        return ((ClientDTO) o1).getName().compareTo(((ClientDTO) o2).getName());
    }*/
}
