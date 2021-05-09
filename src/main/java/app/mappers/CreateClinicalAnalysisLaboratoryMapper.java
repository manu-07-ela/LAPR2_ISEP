package app.mappers;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryMapper {

 public ClinicalAnalysisLaboratory ToModel(ClinicalAnalysisLaboratoryDTO calDTO){
     return new ClinicalAnalysisLaboratory(calDTO.getName(),calDTO.getAddress(), calDTO.getPhoneNumber(), calDTO.getTin(), calDTO.getLaboratoryId(),toModel(calDTO.getListOfTestTypes()));
 }

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

    public TestType toDomain (TestTypeDTO obj){
        return new TestType (obj.getCode(), obj.getDescription(),obj.getCollectingMethod(),toDomainpclist(obj.getListOfParameterCategories()));
    }

    public List<ParameterCategory> toDomainpclist (List<ParameterCategoryDto> parameterCategories){
        List<ParameterCategory> parameterCategory = new ArrayList<>();
        for(ParameterCategoryDto lista : parameterCategories) {
            parameterCategory.add(this.toDomainpc(lista));
        }
        return parameterCategory;
    }
    public ParameterCategory toDomainpc(ParameterCategoryDto parameterCategory) {
        return new ParameterCategory (parameterCategory.getCode(),parameterCategory.getName());
    }


}
