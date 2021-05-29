package app.mappers;

import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.mappers.dto.ParameterCategoryDTO;
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
        return new TestTypeDTO(obj.getCode(), obj.getDescription(),obj.getCollectingMethod(),toDtopclist(obj.getListOfParameterCategories()), obj.getReferenceAdapter());
    }

    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDTO.
     * @param parameterCategories A list of ParameterCategory.
     * @return A list of ParameterCategoryDTO
     */
    public List<ParameterCategoryDTO> toDtopclist (List<ParameterCategory> parameterCategories){
        List<ParameterCategoryDTO> parameterCategoryDTO = new ArrayList<>();
        for(ParameterCategory parameterCategory:parameterCategories) {
            parameterCategoryDTO.add(this.toDtopc(parameterCategory));
        }
        return parameterCategoryDTO;
    }

    /**
     * Transforms an object of type ParameterCategory into an object of type ParameterCategoryDTO.
     * @param parameterCategory An ParameterCategory object.
     * @return An instance of ParameterCategoryDTO.
     */
    public ParameterCategoryDTO toDtopc(ParameterCategory parameterCategory) {
        return new ParameterCategoryDTO(parameterCategory.getCode(),parameterCategory.getName());
    }
}
