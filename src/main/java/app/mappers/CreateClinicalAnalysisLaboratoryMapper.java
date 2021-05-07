package app.mappers;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TestType;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;

import java.util.List;

public class CreateClinicalAnalysisLaboratoryMapper {

 public ClinicalAnalysisLaboratory ToModel(ClinicalAnalysisLaboratoryDTO calDTO){
     String name = calDTO.getName();
     String address = calDTO.getAddress();
     float phoneNumber = (int) calDTO.getPhoneNumber();
     float tin = calDTO.getTin();
     String laboratoryId = calDTO.getLaboratoryId();
     List< TestType > listOfTestTypes = calDTO.getListOfTestTypes();
     return new ClinicalAnalysisLaboratory(name,address,phoneNumber,tin, laboratoryId,listOfTestTypes);
 }
}
