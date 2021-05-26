package app.domain.model;

import app.controller.ValidateWorkController;
import app.domain.store.TestStore;
import app.mappers.dto.TestDTO;
import org.apache.commons.lang3.StringUtils;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.List;

public class Test {
    /**
     * Represents the states of a test
     */
    public static enum StateOfTest {
        TestRegistered, SamplesCollected, SamplesAnalyzed,
        DiagnosisMade, Validated
    }

    /**
     * Client's National Healthcare Service code
     */
    private String nhscode;
    /**
     * A list of TestParameters
     */
    private List<TestParameter> testParameterList;
    /**
     *
     */
    private TestType testType;

    /**
     * The samples associated with a test
     */
    private List<Sample> samples;
    /**
     * indicates the state in which the test is
     */
    private StateOfTest state;
    /**
     *
     */
    private Client client;

    /**
     *
     */
    private String internalCode;

    /**
     *
     */
    private String description;
    /**
     * Represents the date when the samples were added to the test
     */
    private Data samplesAddDate;
    /**
     * Represents the time when th samples were added to the test
     */
    private Time samplesAddTime;
    /**
     * Represents the date when the chemical analysis were added to the test
     */
    private Data chemicalAnalysisDate;
    /**
     * Represents the date when the test was registered in the system
     */
    private Data registerTestDate;
    /**
     * The medical report of the test.
     */
    private MedicalReport md;
    /**
     * The lab coordinator validation of the test.
     */
    private LabCoordinatorValidation lcv;

    public Test(Client cl, String nhscode, TestType testType, List<TestParameter> testParameterList) {
        nhscodeValidation(nhscode);
        this.client = cl;
        this.nhscode = nhscode;
        this.testType = testType;
        this.testParameterList = testParameterList;
        this.state = StateOfTest.TestRegistered;
        this.description = testType.getCollectingMethod();
        this.md = null;
    }


    /**
     * Change the status of a test for Samples collected
     */
    public void changeStateForSamplesCollected() {
        this.state = StateOfTest.SamplesCollected;
    }

    /**
     * Get the state of a test
     *
     * @return the state of the test
     */
    public StateOfTest getState() {
        return state;
    }

    public Client getCl() {
        return client;
    }

    public String getNhscode() {
        return nhscode;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public TestType getTestType() {
        return testType;
    }

    public List<TestParameter> getTestParameterList() {
        return testParameterList;
    }

    public String getDescription() {
        return description;
    }

    private void nhscodeValidation(String nhscode) {
        if (!StringUtils.isNumeric(nhscode))
            throw new IllegalArgumentException("National Healthcare Service code is numeric only.");
        if (nhscode.length() != 12) {
            throw new IllegalArgumentException("The National Healthcare Service code must have 12 digits");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Test test = (Test) other;
        return this.getCl().equals((test).getCl()) || this.getNhscode().equals((test).getNhscode());
    }

    /**
     * It adds the result of a TestParameter
     * @param parameterID The code of the parameter
     * @param result the result of the TestParameter
     * @param metric the metric of the result
     */
    public void addTestResult(String  parameterID, String result, String metric) {
       /* for (TestParameter testParameter: testParameterList) {
            if (testParameter.getParameterId().equals(parameterID)){
                testType.getExternalModule();
                getReferenceValue(testParameter.getParameterId());


                testParameter.AddResult(refValue,result,metric);
            }
        }
        */
    }

    /**
     * Adds the medical report to the test.
     * @param diagnosis The diagnosis made by the specialist doctor.
     * @return true if the medical report was added. Otherwise, false.
     */
    public boolean addMedicalReport(String diagnosis) {
        if (validateMedicalReport()) {
            this.md = new MedicalReport(diagnosis);
            this.state = StateOfTest.SamplesAnalyzed;
            return true;
        }
        return false;
    }

    public boolean validateWork(TestDTO selectedTestDto) {
        if (validateLabCoordinatorValidation()) {
            this.lcv = new LabCoordinatorValidation();
            return true;
        }
        return false;
    }
    /**
     * Global validation of a lab coordinator validation.
     * @return false if the lab coordinator validation already exists. Otherwise, it returns true.
     */
    private boolean validateLabCoordinatorValidation() {
        if (this.lcv != null) {
            return false;
        }
        return true;
    }

    /**
     * Adds the samples to the test
     * @param sample the sample that will be added to the test
     * @return true, if the copy of the sample list passed by parameter is successful, false otherwise
     */
    public boolean addSamples(Sample sample){
      return this.samples.add(sample);
    }
    /**
     * Global validation of a medical report.
     * @return false if the medical report already exists. Otherwise, it returns true.
     */
    private boolean validateMedicalReport() {
        if (this.md != null) {
            return false;
        }
        return true;
    }



}
