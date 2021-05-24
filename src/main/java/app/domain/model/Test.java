package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Test {
    /**
     * Represents the states of a test
     */
    public static enum StateOfTest{
        TestRegistered, SamplesCollected, SamplesAnalyzed,
        DiagnosisMade, Validated
    }

    /**
     * Client's National Healthcare Service code
     */
    private String nhscode;
    /**
     *
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

    private Client cl;

    /**
     *
     */
    private String internalCode;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private MedicalReport md;

    public Test(Client cl, String nhscode ,TestType testType ,List<TestParameter> testParameterList) {
        nhscodeValidation(nhscode);
        this.cl = cl;
        this.nhscode = nhscode;
        this.testType =testType;
        this.testParameterList= testParameterList;
        this.state = StateOfTest.TestRegistered;
    }

    /**
     *  Change the status of a test for Samples collected
     */
    public void changeStateForSamplesCollected() {
        this.state = StateOfTest.SamplesCollected;
    }

    /**
     * Get the state of a test
     * @return the state of the test
     */
    public StateOfTest getState() {
        return state;
    }

    public Client getCl() {
        return cl;
    }

    public String getNhscode() {
        return nhscode;
    }

    public String getInternalCode(){
        return internalCode;
    }

    public TestType getTestType () {
        return testType;
    }

    public List<TestParameter> getTestParameterList () {
        return testParameterList;
    }


    private void nhscodeValidation (String nhscode){
           if (!StringUtils.isNumeric(nhscode))
               throw new IllegalArgumentException("National Healthcare Service code is numeric only.");
           if (nhscode.length() != 12) {
               throw new IllegalArgumentException("The National Healthcare Service code must have 12 digits");
           }
    }

    @Override
    public boolean equals (Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Test test = (Test) other;
        return this.getCl().equals((test).getCl()) || this.getNhscode().equals((test).getNhscode());
    }

    /**
     *
     * @param testparameterSelected
     * @param result
     * @param metric
     */
    public void addTestResult (TestParameter testparameterSelected, String result, String metric){
       /* for (TestParameter testParameter: testParameterList) {
            if (testParameter.equals(testparameterSelected)){
                testType.getExternalModule();
                getReferenceValue(testParameter.getParam());


                testParameter.AddResult(refValue,result,metric);
            }
        }
        */
    }

    /**
     *
     * @param diagnosis
     */
    public void addMedicalReport(String diagnosis){
        this.md= new MedicalReport(diagnosis);

    }


    }
