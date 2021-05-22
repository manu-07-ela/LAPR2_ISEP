package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestParameter;
import app.domain.store.TestStore;
import app.mappers.TestParameterMapper;
import app.mappers.TestTyperMapper;
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
     *
     * @param barcode
     * @return
     */
    /*public List<TestParameterDTO>  getTestParameterList(String barcode){
        test = store.getTestByBarcode(barcode);
        return tpMapper.ToDTO(test.getTestParameterList);
    }
*/
    /**
     *
     * @param testparameterSelected
     * @param result
     * @param metric
     */
    /*public boolean addTestResult(TestParameter testparameterSelected,String result,String metric){
        test.addTestResult(testparameterSelected,result,metric);
    }
*/

}