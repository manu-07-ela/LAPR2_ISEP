package app.controller;

import app.domain.model.Company;
import app.domain.model.testrelated.Test;
import app.domain.store.TestStore;
import app.mappers.TestParameterMapper;
import app.mappers.dto.TestParameterDTO;

import java.util.List;


public class RecordResultsController {

    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents an instance of Test Store
     */
    private TestStore store;
    /**
     * Represents an instance of TestParameter Mapper
     */
    private TestParameterMapper tpMapper;
    /**
     *
     */
    private Test test;


    /**
     * Creates an instance of RecordResultsController
     */
    public RecordResultsController() {
        this(App.getInstance().getCompany());
    }
    /**
     * Creates an instance of RecordResultsController receiving the company
     * @param company The company
     */
    public RecordResultsController(Company company) {
        this.company = company;
        this.store = company.getTestStore();
        this.tpMapper = new TestParameterMapper();
        this.test= null;
    }

    /**
     * Gets an list of TestParameterDTO
     * @param barcode the barcode of a Sample
     * @return A list Of TestParameterDTO
     */
    public List<TestParameterDTO> getTestParameterList(String barcode){
        test = store.getTestByBarcode(barcode);
        if (test==null){
            throw new IllegalArgumentException("There are no tests with samples associated with this barcode");
        }
        return tpMapper.toDTO(test.getTestParameterList());
    }

    /**
     * It adds the result of the test
     * @param parameterID The code of the parameter
     * @param result The result of the test
     * @param metric The metric of the result
     * @return True if the result was added successful. Otherwise return False
     */
    public boolean addTestResult(String parameterID,String result,String metric) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
            return test.addTestResult(parameterID, result, metric);

    }

    /**
     * It checks if the test List has tests with Samples Collected
     * @return True if the list has a test with Samples Collected
     */
    public boolean PossibilityOfRecordResult(){

        return !(store.getTestWithSamplesCollectedList().size() == 0);


    }




}
