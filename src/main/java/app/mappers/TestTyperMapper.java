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
                objDTO = toDTO(lista);
                testTypeListDTO.add(objDTO);
            }
        }
        return testTypeListDTO;
    }

    public TestTypeDTO toDTO(TestType obj){
        return new TestTypeDTO(obj.getCode(), obj.getDescription(),obj.getCollectingMethod(),toDtopclist(obj.getListOfParameterCategories()));
    }


    public List<ParameterCategoryDto> toDtopclist (List<ParameterCategory> parameterCategories){
        List<ParameterCategoryDto> parameterCategoryDTO = new ArrayList<>();
        for(ParameterCategory parameterCategory:parameterCategories) {
            parameterCategoryDTO.add(this.toDtopc(parameterCategory));
        }
        return parameterCategoryDTO;
    }
    public ParameterCategoryDto toDtopc(ParameterCategory parameterCategory) {
        return new ParameterCategoryDto(parameterCategory.getCode(),parameterCategory.getName());
    }
}
