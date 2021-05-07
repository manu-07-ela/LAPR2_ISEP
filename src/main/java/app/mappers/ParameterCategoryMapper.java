package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Transform objects of type ParameterCategory into objects of type ParameterCategoryDTO
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ParameterCategoryMapper {

    private ParameterCategoryDto pcDto;

    /**
     *
     */
    public ParameterCategoryMapper(){

    }

    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDTO.
     * @param parameterCategories A list of ParameterCategory.
     * @return A list of ParameterCategoryDTO
     */
    public List<ParameterCategoryDto> toDto (List<ParameterCategory> parameterCategories){
        List<ParameterCategoryDto> parameterCategoryDTO = new ArrayList<>();
        for(ParameterCategory parameterCategory:parameterCategories)
        {
            parameterCategoryDTO.add(this.toDto(parameterCategory));
        }
        return parameterCategoryDTO;
    }

    /**
     * Transforms an object of type ParameterCategory into an object of type ParameterCategoryDTO.
     * @param parameterCategory An ParameterCategory object.
     * @return An instance of ParameterCategoryDTO.
     */
    public ParameterCategoryDto toDto(ParameterCategory parameterCategory) {
        return new ParameterCategoryDto(parameterCategory.getCode(),parameterCategory.getName());
    }

}
