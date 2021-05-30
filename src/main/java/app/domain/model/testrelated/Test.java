package app.domain.model.testrelated;


import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.laboratories.Laboratory;
import app.domain.model.users.Client;

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
     * Represents the test type associated with the test
     */
    private TestType testType;

    /**
     * The samples associated with a test
     */
    private List<Sample> samples;
    /**
     * Indicates the state in which the test is
     */
    private StateOfTest stateOfTest;
    /**
     * Represents the client associated with the test
     */
    private Client client;

    /**
     * Represents the internal code of a test
     */
    private String internalCode;

    /**
     * Represents the description of a test
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
    /**
     * Represents an instance of Laboratory
     */
    private ClinicalAnalysisLaboratory lab;

    public Test(Client cl, NhsCode nhscode, TestType testType, List<TestParameter> testParameterList,ClinicalAnalysisLaboratory lab,String internalCode) {
        this.client = cl;
        this.nhscode = new NhsCode(nhscode);
        this.testType = testType;
        this.testParameterList = testParameterList;
        this.stateOfTest = StateOfTest.TestRegistered;
        this.internalCode = internalCode;
        this.testAddDate = Calendar.getInstance().getTime();
        this.description = testType.getCollectingMethod();
        this.lab = lab;
        this.md = null;
        this.samples = new ArrayList<>();
        this.lcv = null;
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

    /**
     * Get the client associated with a test
     * @return the client
     */
    public Client getCl() {
        return client;
    }

    /**
     * Get the NHS code associated with a test
     * @return the nhs code
     */
    public NhsCode getNhsCode() {
        return nhscode;
    }

    /**
     * Get the internal code associated with a test
     * @return the internal code
     */
    public String getInternalCode() {
        return internalCode;
    }

    /**
     * Get the test type associated with the test
     * @return the test type
     */
    public TestType getTestType() {
        return testType;
    }

    /**
     * Get the list of parameters associated with the test
     * @return the list of parameter associated with the test
     */
    public List<TestParameter> getTestParameterList() {
        return testParameterList;
    }

    /**
     * Get the description of a test
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public List<Date> getChemicalAnalysisDate() {
        List<Date> chemicalAnalysisDates = new ArrayList<>();
        for (TestParameter tp : testParameterList){
            chemicalAnalysisDates.add(tp.getParamResult().getChemicalAnalysisDate());
        }
        return chemicalAnalysisDates;
    }

    /**
     * Get the medical report associated with the test
     * @return the medical report
     */
    public MedicalReport getMedicalReport() { return this.md;}

    /**
     * Get the date of the creation of medical report
     * @return the date associated with te creation of medical report
     */
    public Date getCreatedAt() { return getMedicalReport().getCreatedAt();}


    /**
     * Get the list of samples associated with a test
     * @return the list of samples associated with a test
     */

    public Date getLabValidationDate() { return lcv.getLabCoordDate();}


    public List<Sample> getSamples() { return samples; }

    /**
     * Takes the test creation date
     * @return the date of creation of the test
     */
    public Date getTestAddDate() {
        return testAddDate;
    }

    /**
     * Compare the test with the other object provided.
     * @param other Object we want to compare with the employee.
     * @return true if the received object represents another test equivalent to the test. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Test test = (Test) other;
        return this.getCl().equals((test).getCl()) || this.getNhsCode().equals((test).getNhsCode());
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
            this.stateOfTest = StateOfTest.DiagnosisMade;
            return true;
        }
        return false;
    }

    /**
     * Creates a Lab Coordinator Validation.
     * @return true if the Lab Coordinator Validation was added. Otherwise, false.
     * @return
     */
    public boolean validateWork() {
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
     * Validates Date Validation
     * @return true if the Lab Coordinator Validation was added. Otherwise, false.
     *
     */
    public boolean validateDate(String date) {
        if (date.equals("Registration Date")) {
            lcv.checkDate("Registration Date");
            return true;
        } else if (date.equals("Chemical Analysis Date")) {
            lcv.checkDate("Chemical Analysis Date");
            return true;
        } else if (date.equals("Diagnosis Date")) {
            lcv.checkDate("Diagnosis Date");
            return true;
        }
        return false;
    }

    /**
     * Adds the samples to the test
     * @param sample the sample that will be added to the test
     * @return true, if the copy of the sample list passed by parameter is successful, false otherwise
     */
    public void addSamples(Sample sample){
        this.samples.add(sample);
        if (!this.samples.isEmpty()) {
            changeStateForSamplesCollected();
            generateDataAndTimeForSamplesCollected();
        }

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
    public boolean validateMedicalReport() {
        if (this.md != null) {
            return false;
        }
        return true;
    }

    /**
     * Generates the date and time when the Lab Coordinator Validation is made.
     */
    public boolean generateDataAndTimeLabCoordinatorValidation(){
        this.stateOfTest = Test.StateOfTest.Validated;
        return lcv.recordDate();
    }


    /**
     * Textual description of a test
     * @return Information that characterizes a test
     */

    @Override
    public String toString() {
        return "Test{" +
                "nhscode=" + nhscode +
                ", testParameterList=" + testParameterList +
                ", testType=" + testType +
                ", samples=" + samples +
                ", stateOfTest=" + stateOfTest +
                ", client=" + client +
                ", internalCode='" + internalCode + '\'' +
                ", description='" + description + '\'' +
                ", samplesAddDate=" + samplesAddDate +
                ", registerTestDate=" + testAddDate +
                ", chemicalAnalysisDate=" + chemicalAnalysisDate +
                ", tpr=" + tpr +
                ", md=" + md +
                ", lcv=" + lcv +
                '}';
    }
}
