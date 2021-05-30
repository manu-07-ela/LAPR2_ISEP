package app.mappers;

import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
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
     public ClinicalAnalysisLaboratory toModel(ClinicalAnalysisLaboratoryDTO calDTO){
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
        return new TestType (testTypeDTO.getCode(), testTypeDTO.getDescription(),testTypeDTO.getCollectingMethod(),toDomainpclist(testTypeDTO.getListOfParameterCategories()), testTypeDTO.getReferenceAdapter());
    }

    /**
     * Transforms a list of objects of type ParameterCategoryDTO into a list of objects of type ParameterCategory.
     * @param parameterCategories A list of ParameterCategoryDTO.
     * @return A list of ParameterCategory
     */
    public List<ParameterCategory> toDomainpclist (List<ParameterCategoryDTO> parameterCategories){
        List<ParameterCategory> parameterCategory = new ArrayList<>();
        for(ParameterCategoryDTO lista : parameterCategories) {
            parameterCategory.add(this.toDomainpc(lista));
        }
        return parameterCategory;
    }

    /**
     * Transforms an object of type ParameterCategoryDto into an object of type ParameterCategory.
     * @param parameterCategory An ParameterCategoryDto object.
     * @return An instance of ParameterCategory.
     */
    public ParameterCategory toDomainpc(ParameterCategoryDTO parameterCategory) {
        return new ParameterCategory (parameterCategory.getCode(),parameterCategory.getName());
    }

    /**
     * Transforms the list of ClinicalAnalysisLaboratory into a list of ClinicalAnalysisLaboratoryDTO
     * @param labs A list of ClinicalAnalysisLaboratory
     * @return A list of ClinicalAnalysisLaboratoryDTO
     */
    public List<ClinicalAnalysisLaboratoryDTO> toDto (List<ClinicalAnalysisLaboratory> labs){
        List<ClinicalAnalysisLaboratoryDTO> clinicalAnalysisLaboratoryDTO = new ArrayList<>();
        for(ClinicalAnalysisLaboratory lab: labs) {
            clinicalAnalysisLaboratoryDTO.add(this.toDto(lab));
        }
        return clinicalAnalysisLaboratoryDTO;
    }

    /**
     * Transforms an Objects of the type ClinicalAnalysisLaboratory into an Objects of the type ClinicalAnalysisLaboratoryDTO
     * @param cal an Object of the type ClinicalAnalysisLaboratory
     * @return an Object of the type ClinicalAnalysisLaboratoryDTO
     */
    public ClinicalAnalysisLaboratoryDTO toDto(ClinicalAnalysisLaboratory cal){
        return new ClinicalAnalysisLaboratoryDTO(cal.getName(),cal.getAddress(), cal.getPhoneNumber(), cal.getTin(), cal.getLaboratoryId(),toDtoo(cal.getListOfTestTypes()));
    }

    /**
     * Transforms the list of TestType into a list of TestTypeDTO
     * @param testTypeList A list of TestTypeDTO
     * @return A list of TestTypeDTO
     */
    public List<TestTypeDTO> toDtoo(List<TestType> testTypeList) {
        List<TestTypeDTO> testTypeListDTO =new ArrayList();
        TestTypeDTO obj;
        for (TestType lista : testTypeList) {
            if (lista != null){
                obj = toDtoo(lista);
                testTypeListDTO.add(obj);
            }
        }
        return testTypeListDTO;
    }

    /**
     * Transforms a TestType into a TestTypeDTO
     * @param testType a TestType
     * @return a TestTypeDTO
     */
    public TestTypeDTO toDtoo (TestType testType){
        return new TestTypeDTO (testType.getCode(), testType.getDescription(),testType.getCollectingMethod(),toDtopclist(testType.getListOfParameterCategories()), testType.getReferenceAdapter());
    }

    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDTO.
     * @param parameterCategories A list of ParameterCategory.
     * @return A list of ParameterCategoryDTO
     */
    public List<ParameterCategoryDTO> toDtopclist (List<ParameterCategory> parameterCategories){
        List<ParameterCategoryDTO> parameterCategoryDTO = new ArrayList<>();
        for(ParameterCategory lista : parameterCategories) {
            parameterCategoryDTO.add(this.toDtopc(lista));
        }
        return parameterCategoryDTO;
    }

    /**
     * Transforms an object of type ParameterCategory into an object of type ParameterCategoryDto.
     * @param parameterCategory An ParameterCategory object.
     * @return An instance of ParameterCategoryDto.
     */
    public ParameterCategoryDTO toDtopc(ParameterCategory parameterCategory) {
        return new ParameterCategoryDTO (parameterCategory.getCode(),parameterCategory.getName());
    }
}
