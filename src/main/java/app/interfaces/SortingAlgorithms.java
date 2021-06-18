package app.interfaces;

import app.mappers.dto.ClientDTO;

import java.util.List;

public interface SortingAlgorithms {
    /**
     * The method that will ordered the list of clients
     * @param list the list of clients
     * @return the ordered list
     */
     List<ClientDTO> orderClientList (List<ClientDTO> list);

}
