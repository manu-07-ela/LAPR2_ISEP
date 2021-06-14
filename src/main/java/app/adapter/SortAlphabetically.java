package app.adapter;

import app.adapter.interfaces.SortingAlgorithms;
import app.mappers.dto.ClientDTO;

import java.util.List;

public class SortAlphabetically implements SortingAlgorithms {


    @Override
    public List<ClientDTO> orderClientList (List<ClientDTO> list) {
        for (int i = 0;i<list.size();i++) {
            for (int j=1;j< list.size();j++){
                if (list.get(i).getName().compareTo(list.get(j).getName()) < 0 ){
                    if (j < i){
                        ClientDTO temp = list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,temp);
                    }
                }
            }
        }
        return list;

    }
}