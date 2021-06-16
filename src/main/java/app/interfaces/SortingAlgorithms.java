package app.interfaces;

import app.mappers.dto.ClientDTO;

import java.util.List;

public interface SortingAlgorithms {

    public List<ClientDTO> orderClientList (List<ClientDTO> list);

}
