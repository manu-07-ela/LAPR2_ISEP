package app.mappers;

import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.mappers.dto.ParameterCategoryDTO;
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
        return new ParameterDTO(parameter.getCode(),parameter.getShortName(),parameter.getDescription(), toDtoParameterCategoryDTo(parameter.getCategory()));
    }

    /**
     * Transforms an object of type ParameterCategory into an object of type ParameterCategoryDTO.
     * @param pc An ParameterCategory object.
     * @return An instance of ParameterCategoryDTO.
     */
    public ParameterCategoryDTO toDtoParameterCategoryDTo(ParameterCategory pc){
        return new ParameterCategoryDTO(pc.getCode(), pc.getName());
    }

    /**
     * Transforms a list of objects of type ParameterDTO into a list of objects of type Parameter.
     * @param parametersDTO A list of ParameterDTO.
     * @return A list of Parameter.
     */
    public List<Parameter> toModel (List<ParameterDTO> parametersDTO){
        List<Parameter> parameter = new ArrayList<>();
        for(ParameterDTO parameterDTO: parametersDTO) {
            parameter.add(this.toModel(parameterDTO));
        }
        return parameter;
    }

    /**
     * Transforms an object of type ParameterDTO into an object of type Parameter.
     * @param parameter An ParameterDTO object.
     * @return An instance of Parameter.
     */
    public Parameter toModel(ParameterDTO parameter) {
        return new Parameter(parameter.getCode(),parameter.getShortName(),parameter.getDescription(), toModelParameterCategoryDTo(parameter.getCategory()));
    }

    /**
     * Transforms an object of type ParameterCategoryDTO into an object of type ParameterCategory.
     * @param pc An ParameterCategoryDTO object.
     * @return An instance of ParameterCategory.
     */
    public ParameterCategory toModelParameterCategoryDTo(ParameterCategoryDTO pc){
        return new ParameterCategory(pc.getCode(), pc.getName());
    }
}
