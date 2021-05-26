package app.mappers;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDtoTest;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryMapper {

    /**
     * Transforms an Objects of the type ClinicalAnalysisLaboratoryDTO into an Objects of the type ClinicalAnalysisLaboratory
     * @param calDTO an Object of the type ClinicalAnalysisLaboratoryDTO
     * @return an Object of the type ClinicalAnalysisLaboratory
     */
 public ClinicalAnalysisLaboratory ToModel(ClinicalAnalysisLaboratoryDTO calDTO){
     return new ClinicalAnalysisLaboratory(calDTO.getName(),calDTO.getAddress(), calDTO.getPhoneNumber(), calDTO.getTin(), calDTO.getLaboratoryId(),toModel(calDTO.getListOfTestTypes()));
 }

    /**
     * Transforms the list of TestTypeDTO into a list of TestType
     * @param testTypeListDTO A list of TestTypeDTO
     * @return A list of TestType
     */
    public List<TestType> toModel(List<TestTypeDTO> testTypeListDTO) {
        List<TestType> testTypeList =new ArrayList();
        TestType obj;
        for (TestTypeDTO lista : testTypeListDTO) {
            if (lista != null){
                obj = toDomain(lista);
                testTypeList.add(obj);
            }
        }
        return testTypeList;
    }

    /**
     * Transforms a TestTypeDTO into a TestType
     * @param testTypeDTO a TestTypeDTO
     * @return a TestType
     */
    public TestType toDomain (TestTypeDTO testTypeDTO){
        return new TestType (testTypeDTO.getCode(), testTypeDTO.getDescription(),testTypeDTO.getCollectingMethod(),toDomainpclist(testTypeDTO.getListOfParameterCategories()));
    }

    /**
     * Transforms a list of objects of type ParameterCategoryDTO into a list of objects of type ParameterCategory.
     * @param parameterCategories A list of ParameterCategoryDTO.
     * @return A list of ParameterCategory
     */
    public List<ParameterCategory> toDomainpclist (List<ParameterCategoryDtoTest> parameterCategories){
        List<ParameterCategory> parameterCategory = new ArrayList<>();
        for(ParameterCategoryDtoTest lista : parameterCategories) {
            parameterCategory.add(this.toDomainpc(lista));
        }
        return parameterCategory;
    }

    /**
     * Transforms an object of type ParameterCategoryDto into an object of type ParameterCategory.
     * @param parameterCategory An ParameterCategoryDto object.
     * @return An instance of ParameterCategory.
     */
    public ParameterCategory toDomainpc(ParameterCategoryDtoTest parameterCategory) {
        return new ParameterCategory (parameterCategory.getCode(),parameterCategory.getName());
    }


}
