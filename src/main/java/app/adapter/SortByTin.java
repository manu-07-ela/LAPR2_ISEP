package app.adapter;

import app.adapter.interfaces.Algorithm;
import app.mappers.dto.ClientDTO;

import java.util.List;

public class SortByTin implements Algorithm {

    @Override
    public List<ClientDTO> compare(List<ClientDTO> lista) {
        for (int i = 0;i<lista.size();i++) {
            for (int j=1;j< lista.size();j++){
                if (Integer.parseInt(lista.get(i).getTin()) < Integer.parseInt(lista.get(j).getTin()) ){
                    if (j < i){
                        ClientDTO temp = lista.get(j);
                        lista.set(j,lista.get(i));
                        lista.set(i,temp);
                    }
                }
            }
        }
        return lista;
    }
}
