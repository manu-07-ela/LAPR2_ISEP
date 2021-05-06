package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ParameterCategoryMapper {

    /**
     *
     * @param parameterCategories
     * @return
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
     *
     * @param parameterCategory
     * @return
     */
    public ParameterCategoryDto toDto(ParameterCategory parameterCategory) {
        return new ParameterCategoryDto(parameterCategory.getCode(),parameterCategory.getName());
    }

}
