package app.domain.model.testRelated;


import app.domain.model.attributes.NhsCode;
import app.domain.model.users.Client;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private NhsCode nhscode;
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
    private StateOfTest stateOfTest;
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
    private Date samplesAddDate;

    /**
     * Represents the date when the test was registered
     */
    private Date testAddDate;

    /**
     * Represents the date when the chemical analysis were added to the test
     */
    private Date chemicalAnalysisDate;

    /**
     * The Test Parameter Result of the test.
     */
    private TestParameterResult tpr;

    /**
     * Represents the date when the test was registered in the system
     */
    private Date registerTestDate;
    /**
     * The medical report of the test.
     */
    private MedicalReport md;
    /**
     * The lab coordinator validation of the test.
     */
    private LabCoordinatorValidation lcv;
    /**
     * It counts how many times it was added a result in a test
     */
    private static int countAddResult;

    public Test(Client cl, NhsCode nhscode, TestType testType, List<TestParameter> testParameterList,String internalCode) {
        this.client = cl;
        this.nhscode = new NhsCode(nhscode);
        this.testType = testType;
        this.testParameterList = testParameterList;
        this.stateOfTest = StateOfTest.TestRegistered;
        this.internalCode = internalCode;
        this.testAddDate = Calendar.getInstance().getTime();
        this.description = testType.getCollectingMethod();
        this.md = null;
        this.samples = new ArrayList<>();
    }


    /**
     * Change the status of a test for Samples collected
     */
    private void changeStateForSamplesCollected() {
        this.stateOfTest = StateOfTest.SamplesCollected;
    }

    /**
     * Get the state of a test
     *
     * @return the state of the test
     */
    public StateOfTest getStateOfTest() {
        return stateOfTest;
    }

    public Client getCl() {
        return client;
    }

    public NhsCode getNhscode() {
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

    public Date getChemicalAnalysisDate() { return tpr.getChemicalAnalysisDate();}

    public MedicalReport getMedicalReport() { return this.md;}

    public Date getCreatedAt() { return getMedicalReport().getCreatedAt();}

    public Date getRegisterTestDate() { return this.registerTestDate; }

    public List<Sample> getSamples() { return samples; }


    public Date getTestAddDate() {
        return testAddDate;
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
    public boolean addTestResult(String  parameterID, String result, String metric) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        boolean verificacao=false;
        for (TestParameter testParameter: testParameterList) {
            if (testParameter.getParameterId().equals(parameterID)){
                    verificacao =  testParameter.AddResult(testType.getExternalModule().getRefValue(testParameter.getParameterId()) ,result,metric);
                if (!verificacao){
                    return false;
                }
                countAddResult++;
            }
        }
        if (countAddResult==testParameterList.size()){
            stateOfTest = StateOfTest.SamplesAnalyzed;
        }
        return verificacao;

    }

    /**
     * Adds the medical report to the test.
     * @param diagnosis The diagnosis made by the specialist doctor.
     * @return true if the medical report was added. Otherwise, false.
     */
    public boolean addMedicalReport(String diagnosis) {
        if (validateMedicalReport()) {
            this.md = new MedicalReport(diagnosis);
            this.stateOfTest = StateOfTest.SamplesAnalyzed;
            return true;
        }
        return false;
    }

    public boolean validateWork(Test selectedTest) {
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
    public boolean addSamples(Sample sample, int flag){
        if (this.samples.size()==flag) {
            changeStateForSamplesCollected();
            generateDataAndTimeForSamplesCollected();
        }
        return this.samples.add(sample);
    }

    /**
     * Generates the date and time when the samples were associated with a test
     */
    private void generateDataAndTimeForSamplesCollected(){
        this.samplesAddDate = Calendar.getInstance().getTime();
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

    /**
     * Generates the date and time when the samples were associated with a test
     */
    public void generateDataAndTimeLabCoordinatorValidation(){
        lcv.recordLabCoordinatorValidationDate();
    }

    @Override
    public String toString() {
        for (TestParameter la: testParameterList) {
            return String.format("%s",la.getTparamresult().toString());
        }
        return "la";
    }
}
