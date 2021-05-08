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

    private Company company;
    private ClinicalAnalysisLaboratory cal;
    private ClinicalAnalysisLaboratoryStore store;
    private TestTyperMapper ttmapper;
    private CreateClinicalAnalysisLaboratoryMapper calMapper;

    public CreateClinicalAnalysisLaboratoryController() {
        this(App.getInstance().getCompany());
    }
    public CreateClinicalAnalysisLaboratoryController(Company company) {
        this.company = company;
        this.store = company.getClinicalAnalysisLaboratoryStore();
        this.cal = null;
        ttmapper = new TestTyperMapper();
        calMapper = new CreateClinicalAnalysisLaboratoryMapper();
    }

    /**
     *
     * @return
     */
    public List<TestTypeDTO> getTestTypeList(){
       TestTypeStore store = company.getTestTypeStore();
       return ttmapper.toDTO(store.getTestTypeList());
    }

    /**
     *
     * @param calDTO
     * @return
     */
   public boolean CreateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratoryDTO calDTO) {
        this.cal = store.createClinicalAnalysisLaboratory(calDTO,calMapper);
        return store.validateClinicalAnalysisLaboratory(cal);
    }

    /**
     *
     * @return
     */
    public boolean saveClinicalAnalysisLaboratory() {
        return store.saveClinicalAnalysisLaboratory(cal);
    }

}
