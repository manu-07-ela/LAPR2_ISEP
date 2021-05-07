package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TestType;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;

import java.util.ArrayList;
import java.util.List;

public class ClinicalAnalysisLaboratoryStore {

    /**
     *
     */
    List<ClinicalAnalysisLaboratory> clinicalAnalysisLaboratoryList;

    /**
     *
     */
    public ClinicalAnalysisLaboratoryStore (){
        clinicalAnalysisLaboratoryList = new ArrayList<>();
    }

    /**
     *
     * @param calDTO
     * @return
     */
    public ClinicalAnalysisLaboratory createClinicalAnalysisLaboratory(ClinicalAnalysisLaboratoryDTO calDTO){
        return CreateClinicalAnalysisLaboratoryMapper.ToModel(calDTO);
    }

    /**
     *
     * @param clinicalAnalysisLaboratory
     * @return
     */
    public boolean validateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory) {
        if (clinicalAnalysisLaboratory == null)
            return false;
        return !this.clinicalAnalysisLaboratoryList.contains(clinicalAnalysisLaboratory);
    }

    /**
     *
     * @param clinicalAnalysisLaboratory
     */
    public void addClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory) {
        clinicalAnalysisLaboratoryList.add(clinicalAnalysisLaboratory);
    }

    /**
     *
     * @param clinicalAnalysisLaboratory
     * @return
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
