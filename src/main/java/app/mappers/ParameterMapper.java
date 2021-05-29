package app.mappers;

import app.domain.model.testrelated.Parameter;
import app.mappers.dto.ParameterDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Transform objects of type Parameter into objects of type ParameterDTO and vice versa
 * @author José Pessoa <1201007@isep.ipp.pt>
 */
public class ParameterMapper {

    /**
     * Transforms a list of objects of type Parameter into a list of objects of type ParameterDTO.
     * @param parameters A list of Parameter.
     * @return A list of ParameterDTO.
     */
    public List<ParameterDTO> toDto (List<Parameter> parameters){
        List<ParameterDTO> parameterDTO = new ArrayList<>();
        for(Parameter parameter: parameters) {
            parameterDTO.add(this.toDto(parameter));
        }
        return parameterDTO;
    }

    /**
     * Transforms an object of type Parameter into an object of type ParameterDTO.
     * @param parameter An Parameter object.
     * @return An instance of ParameterDTO.
     */
    public ParameterDTO toDto(Parameter parameter) {
        return new ParameterDTO(parameter.getCode(),parameter.getShortName(),parameter.getDescription(), parameter.getCategory());
    }
}
