package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.TestTypeStore;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.TestTyperMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.TestTypeDTO;

import java.util.List;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryController {

    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of ClinicalAnalysisLaboratory
     */
    private ClinicalAnalysisLaboratory cal;
    /**
     * Represents an instance of ClinicalAnalysisLaboratory Store
     */
    private ClinicalAnalysisLaboratoryStore store;
    /**
     * Represents an instance of TestType Mapper
     */
    private TestTyperMapper ttmapper;
    /**
     * Represents an instance of ClinicalAnalysisLaboratory Mapper
     */
    private CreateClinicalAnalysisLaboratoryMapper calMapper;

    /**
     * Creates an instance of CreateClinicalAnalysisLaboratoryController
     */
    public CreateClinicalAnalysisLaboratoryController() {
        this(App.getInstance().getCompany());
    }
    /**
     * Creates an instance of CreateClinicalAnalysisLaboratoryController receiving the company
     * @param company The comany
     */
    public CreateClinicalAnalysisLaboratoryController(Company company) {
        this.company = company;
        this.store = company.getClinicalAnalysisLaboratoryStore();
        this.cal = null;
        ttmapper = new TestTyperMapper();
        calMapper = new CreateClinicalAnalysisLaboratoryMapper();
    }

    /**
     * Get a list of objects of TestTYpeDTO
     * @return list of TestTypeDTO
     */
    public List<TestTypeDTO> getTestTypeList(){
       TestTypeStore store = company.getTestTypeStore();
       return ttmapper.toDTO(store.getTestTypeList());
    }

    /**
     * Creates a  new Clinical Analysis Laboratory
     * @param calDTO An object of the type ClinicalAnalysisLaboratoryDTO with the information to create a ClinicalAnalysisLaboratory
     * @return false if the ClinicalAnalysisLaboratory created has an attribute with the same information as an already created. Otherwise return true.
     */
   public boolean CreateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratoryDTO calDTO) {
        this.cal = store.createClinicalAnalysisLaboratory(calDTO,calMapper);
        return store.validateClinicalAnalysisLaboratoryglobal(cal);
    }


    /**
     * Save the ClinicalAnalysisLaboratory if it is valid
     * @return true if the ClinicalAnalysisLaboratory was saved. Otherwise, false
     */
    public boolean saveClinicalAnalysisLaboratory() {
        return store.saveClinicalAnalysisLaboratory(cal);
    }

}
