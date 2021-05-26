package app.controller;

import app.domain.model.Company;
import app.domain.store.SampleStore;
import app.domain.store.TestStore;
import app.mappers.TestMapper;
import app.mappers.dto.TestDTO;
import java.util.List;

/**
 * Represents the controller used to record samples in a test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class RecordSampleController {
    /**
     * Represents a instance of test store
     */
    private TestStore testStore;
    /**
     * Represents a instance of sample store
     */
    private SampleStore sampleStore;
    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents a instance of test mapper
     */
    private TestMapper testMapper;

    /**
     * Constructs an instance of {@code RecordSampleController}
     */
    public RecordSampleController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.sampleStore = company.getSampleStore();
        this.testMapper = new TestMapper();
    }

    /**
     * Returns a DTO-type list of test waiting for samples in the system
     * @return A DTO-type list of tests waiting for samples
     */
    public List<TestDTO> getListOfTestswaitingForSample(){
        return testMapper.toDto(testStore.getListOfTestWaitingForSample());
    }

}
