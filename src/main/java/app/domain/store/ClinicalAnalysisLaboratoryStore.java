package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TestType;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryStore {

    /**
     * List of all ClinicalAnalysisLaboratory that exist in a comapny
     */
    List<ClinicalAnalysisLaboratory> clinicalAnalysisLaboratoryList;

    /**
     * Creates a new instance of TestTypeStore
     */
    public ClinicalAnalysisLaboratoryStore (){
        clinicalAnalysisLaboratoryList = new ArrayList<>();
    }

    /**
     * Creates a new ClinicalAnalysisLaboratory
     * @param calDTO An Object of the Type ClinicalAnalysisLaboratoryDTO with all information to create the ClinicalAnalysisLaboratory
     * @param calMapper The ClinicalAnalysisLaboratory Mapper that will transform the information in Object of the Type ClinicalAnalysisLaboratoryDTO
     * @return The ClinicalAnalysisLaboratory
     */
    public ClinicalAnalysisLaboratory createClinicalAnalysisLaboratory(ClinicalAnalysisLaboratoryDTO calDTO, CreateClinicalAnalysisLaboratoryMapper calMapper){
        return calMapper.ToModel(calDTO);
    }

    /**
     * Checks if the ClinicalAnalysisLaboratory already exist
     * @param clinicalAnalysisLaboratory the ClinicalAnalysisLaboratory we want to validate
     * @return false if the ClinicalAnalysisLaboratory already exist or it is null. Otherwise return true
     */
    public boolean validateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory) {
        if (clinicalAnalysisLaboratory == null)
            return false;
        return !this.clinicalAnalysisLaboratoryList.contains(clinicalAnalysisLaboratory);
    }

    /**
     * Checks if the ClinicalAnalysisLaboratory has an attribute with the same information as an already created
     * @param clinicalAnalysisLaboratory  the ClinicalAnalysisLaboratory we want to validate
     * @return false the ClinicalAnalysisLaboratory has an attribute with the same information as an already created . Otherwise it return true
     */
    public boolean validateClinicalAnalysisLaboratoryglobal (ClinicalAnalysisLaboratory clinicalAnalysisLaboratory){
        for (ClinicalAnalysisLaboratory cal: clinicalAnalysisLaboratoryList) {
            if (clinicalAnalysisLaboratory.equals(cal)){
                return false;
            }
        }
        return true;

    }

    /**
     * Get the list of all ClinicalAnalysisLaboratory that exist in the company
     * @return list of all ClinicalAnalysisLaboratory that exist in the company
     */
    public List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList() {
        return clinicalAnalysisLaboratoryList;
    }

    /**
     * Adds a ClinicalAnalysisLaboratory in the list of all ClinicalAnalysisLaboratory that exist in the company
     * @param cal a ClinicalAnalysisLaboratory that we want to add
     * @return true if the ClinicalAnalysisLaboratory was added. Otherwise it returns false
     */
    public boolean addClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal) {
        return clinicalAnalysisLaboratoryList.add(cal);
    }

    /**
     * Save the ClinicalAnalysisLaboratory if it is valid
     * @param clinicalAnalysisLaboratory a ClinicalAnalysisLaboratory we want to save
     * @return true if the ClinicalAnalysisLaboratory was saved. Otherwise it returns false
     */
    public boolean saveClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory) {
        if (!validateClinicalAnalysisLaboratory(clinicalAnalysisLaboratory)) {
            return false;
        }else {
            this.clinicalAnalysisLaboratoryList.add(clinicalAnalysisLaboratory);
            return true;
        }
    }




}
