package app.mappers;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TestType;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;

import java.util.List;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryMapper {

 public static ClinicalAnalysisLaboratory ToModel(ClinicalAnalysisLaboratoryDTO calDTO){
     return new ClinicalAnalysisLaboratory(calDTO);
 }

}
