package app.mappers;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.ParameterCategoryDtoTest;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class TestTyperMapper {

    /**
     * Transforms the list of TestType into a list of TestTypeDTO
     * @param testTypeList A list of TestType
     * @return A list of TestTypeDTO
     */
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

    /**
     * Transforms a TestType into a TestTypeDTO
     * @param obj a TestType
     * @return a TestTypeDTO
     */
    public TestTypeDTO toDTO(TestType obj){
        return new TestTypeDTO(obj.getCode(), obj.getDescription(),obj.getCollectingMethod(),toDtopclist(obj.getListOfParameterCategories()));
    }

    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDTO.
     * @param parameterCategories A list of ParameterCategory.
     * @return A list of ParameterCategoryDTO
     */
    public List<ParameterCategoryDtoTest> toDtopclist (List<ParameterCategory> parameterCategories){
        List<ParameterCategoryDtoTest> parameterCategoryDtoTest = new ArrayList<>();
        for(ParameterCategory parameterCategory:parameterCategories) {
            parameterCategoryDtoTest.add(this.toDtopc(parameterCategory));
        }
        return parameterCategoryDtoTest;
    }

    /**
     * Transforms an object of type ParameterCategory into an object of type ParameterCategoryDTO.
     * @param parameterCategory An ParameterCategory object.
     * @return An instance of ParameterCategoryDTO.
     */
    public ParameterCategoryDtoTest toDtopc(ParameterCategory parameterCategory) {
        return new ParameterCategoryDtoTest(parameterCategory.getCode(),parameterCategory.getName());
    }
}
