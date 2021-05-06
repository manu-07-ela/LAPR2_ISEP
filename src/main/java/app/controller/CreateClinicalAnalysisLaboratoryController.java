package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.TestType;
import app.domain.store.ClinicalAnalysisLaboratoryStore;

import java.util.List;

public class CreateClinicalAnalysisLaboratoryController {

    private Company company;
    private ClinicalAnalysisLaboratory cal;
    private ClinicalAnalysisLaboratoryStore store;

    public CreateClinicalAnalysisLaboratoryController() {
        this(App.getInstance().getCompany());
    }
    public CreateClinicalAnalysisLaboratoryController(Company company) {
        this.company = company;
        this.store = company.getClinicalAnalysisLaboratoryStore();
        this.cal = null;
    }

    public boolean CreateClinicalAnalysisLaboratory(String name, String address, int phoneNumber , int tin, String laboratoryId, List<TestType> listOfTestTypes) {
        this.cal = this.store.createClinicalAnalysisLaboratory(name,address,phoneNumber,tin,laboratoryId,listOfTestTypes);
        return this.store.validateClinicalAnalysisLaboratory(cal);
    }
    public boolean saveClinicalAnalysisLaboratory() {
        return this.store.saveClinicalAnalysisLaboratory(cal);
    }

}
