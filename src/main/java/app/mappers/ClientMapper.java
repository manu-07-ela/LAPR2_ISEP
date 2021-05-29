package app.mappers;

import app.domain.model.users.Client;
import app.mappers.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Transform objects of type Client into objects of type ClientDto and vice versa
 * @author José Pessoa <1201007@isep.ipp.pt>
 */
public class ClientMapper {
    /**
     *Transforms an object of type ClientDto into an object of type Client
     * @param cl an ClientDto object
     * @return an instance of Client
     */
    public Client toModel(ClientDTO cl){
        return new Client(cl.getName(),cl.getCitizencardnumber(),cl.getNhs(),cl.getDate(),cl.getSex(),cl.getTin(),cl.getPhonenumber(),cl.getEmail());
    }

    /**
     * Transforms a list of objects of type Client into a list of objects of type ClientDTO.
     * @param clients A list of Client.
     * @return A list of ClientDTO.
     */
    public List<ClientDTO> toDto(List<Client> clients){
        List<ClientDTO> clientDto = new ArrayList<>();
        for(Client client: clients) {
            clientDto.add(this.toDto(client));
        }
        return clientDto;
    }
    /**
     * Transforms an object of type Client into an object of type ParameterDTO.
     * @param cl An client object.
     * @return An instance of ClientDTO.
     */
    public ClientDTO toDto(Client cl){
        return new ClientDTO(cl.getName(),cl.getCitizencardnumber(),cl.getNhs(),cl.getDate(),cl.getSex(),cl.getTin(),cl.getPhonenumber(),cl.getEmail());
    }

}
