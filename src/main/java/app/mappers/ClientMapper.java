package app.mappers;

import app.domain.model.Client;
import app.mappers.dto.ClientDto;
import app.mappers.dto.EmployeeDTO;

/**
 * Transform objects of type Client into objects of type ClientDto and vice versa
 * @author José Pessoa <1201007@isep.ipp.pt>
 */
public class ClientMapper {
    /**
     *Transforms an object of type Client into an object of type ClientDto
     * @param cl an Client object
     * @return an instance of ClientDto
     */
    public Client toModel(ClientDto cl){
        return new Client(cl.getName(),cl.getCitizencardnumber(),cl.getNhs(),cl.getDate(),cl.getSex(),cl.getTin(),cl.getPhonenumber(),cl.getEmail());
    }

}
