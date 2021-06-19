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

    /**
     * Transforms the list of TestTypeDTO into a list of TestType
     * @param testTypeListDTO A list of TestType
     * @return A list of TestType
     */
    public List<TestType> toModel(List<TestTypeDTO> testTypeListDTO) {
        List<TestType> testTypeList =new ArrayList();
        TestType obj;
        for (TestTypeDTO lista : testTypeListDTO) {
            if (lista != null){
                obj = toModel(lista);
                testTypeList.add(obj);
            }
        }
        return testTypeList;
    }

    /**
     * Transforms a TestTypeDTO into a TestType
     * @param obj a TestTypeDTO
     * @return a TestType
     */
    public TestType toModel(TestTypeDTO obj){
        return new TestType(obj.getCode(), obj.getDescription(),obj.getCollectingMethod(),toModelpclist(obj.getListOfParameterCategories()), obj.getReferenceAdapter());
    }

    /**
     * Transforms a list of objects of type ParameterCategoryDTO into a list of objects of type ParameterCategory.
     * @param parameterCategoriesDTO A list of ParameterCategoryDTO.
     * @return A list of ParameterCategory
     */
    public List<ParameterCategory> toModelpclist (List<ParameterCategoryDTO> parameterCategoriesDTO){
        List<ParameterCategory> parameterCategory = new ArrayList<>();
        for(ParameterCategoryDTO parameterCategoryDTO:parameterCategoriesDTO) {
            parameterCategory.add(this.toModelPc(parameterCategoryDTO));
        }
        return parameterCategory;
    }

    /**
     * Transforms an object of type ParameterCategoryDTO into an object of type ParameterCategory.
     * @param parameterCategory An ParameterCategoryDTO object.
     * @return An instance of ParameterCategory.
     */
    public ParameterCategory toModelPc(ParameterCategoryDTO parameterCategory) {
        return new ParameterCategory(parameterCategory.getCode(),parameterCategory.getName());
    }
}
