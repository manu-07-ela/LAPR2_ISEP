package app.adapter.interfaces;

import app.mappers.dto.ClientDTO;

import java.util.List;

public interface Algorithm {

    public List<ClientDTO> compare (List<ClientDTO> list);

}
