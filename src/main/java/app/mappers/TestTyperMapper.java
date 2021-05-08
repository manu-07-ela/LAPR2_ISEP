package app.mappers;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class TestTyperMapper {


    public List<TestTypeDTO> toDTO(List<TestType> testTypeList) {
        List<TestTypeDTO> testTypeListDTO =new ArrayList();
        TestTypeDTO objDTO;
        for (TestType lista : testTypeList) {
            if (lista != null){
                objDTO = ToDTO(lista);
                testTypeListDTO.add(objDTO);
            }
        }
        return testTypeListDTO;
    }

    public TestTypeDTO ToDTO(TestType obj){
        return new TestTypeDTO(obj.getCode(), obj.getDescription(),obj.getCollectingMethod(),toDto(obj.getListOfParameterCategories()));
    }


    public List<ParameterCategoryDto> toDto (List<ParameterCategory> parameterCategories){
        List<ParameterCategoryDto> parameterCategoryDTO = new ArrayList<>();
        for(ParameterCategory parameterCategory:parameterCategories) {
            parameterCategoryDTO.add(this.toDto(parameterCategory));
        }
        return parameterCategoryDTO;
    }
    public ParameterCategoryDto toDto(ParameterCategory parameterCategory) {
        return new ParameterCategoryDto(parameterCategory.getCode(),parameterCategory.getName());
    }
}
