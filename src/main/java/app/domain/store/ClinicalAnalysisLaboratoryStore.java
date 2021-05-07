package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TestType;

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
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     * @param laboratoryId            Clinical Analysis Laboratory's ID
     * @param listOfTestTypes         List of Test Type that the Clinical Analysis Laboratory does
     * @return
     */
    public ClinicalAnalysisLaboratory createClinicalAnalysisLaboratory(String name, String address, int phoneNumber , int tin, String laboratoryId, List<TestType> listOfTestTypes){
        return new ClinicalAnalysisLaboratory(name,address,phoneNumber,tin,laboratoryId,listOfTestTypes);
    }

    /**
     *
     * @param obj
     * @return
     */
    public ClinicalAnalysisLaboratory createClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory obj){
        return new ClinicalAnalysisLaboratory(obj);
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
