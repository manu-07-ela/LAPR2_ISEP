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
     * Client's citizen card number
     */
    private String citizencardnumber;

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

    /**
     * Constructs an instance of {@code Test} receiving the Client's citizen card number and National Healthcare Service code
     * @param citizencardnumber
     * @param nhscode
     */
    public Test(String citizencardnumber, String nhscode ,TestType testType ,List<TestParameter> testParameterList) {
        citizencardnumberValidation(citizencardnumber);
        nhscodeValidation(nhscode);
        this.citizencardnumber = citizencardnumber;
        this.nhscode = nhscode;
        this.testType =testType;
        this.testParameterList= testParameterList;
        this.state = StateOfTest.TestRegistered;
    }

    /**
     * Change the state of a test
     * @param state the new state of a test
     */
    public void setState(StateOfTest state) {
        this.state = state;
    }

    /**
     * Get the state of a test
     * @return the state of the test
     */
    public StateOfTest getState() {
        return state;
    }

    public String getCitizencardnumber() {
        return citizencardnumber;
    }

    public String getNhscode() {
        return nhscode;
    }

    public TestType getTestType() {
        return testType;
    }

    public List<TestParameter> getTestParameterList() { return testParameterList; }

    private void citizencardnumberValidation(String citizencardnumber){
        if (!StringUtils.isNumeric(citizencardnumber)) throw new IllegalArgumentException("Citizen card number is numeric only.");
        if (citizencardnumber.length()!=16){
            throw  new IllegalArgumentException("The citizen card number must have 16 digits");
        }
    }

    private void nhscodeValidation(String nhscode){
        if (!StringUtils.isNumeric(nhscode)) throw new IllegalArgumentException("National Healthcare Service code is numeric only.");
        if (nhscode.length()!=12){
            throw  new IllegalArgumentException("The National Healthcare Service code must have 12 digits");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Test test = (Test) other;
        return this.getCitizencardnumber().equals((test).getCitizencardnumber()) || this.getNhscode().equals((test).getNhscode());
    }

    /**
     *
     * @param testparameterSelected
     * @param result
     * @param metric
     */
    public void addTestResult(TestParameter testparameterSelected, String result, String metric) {
       /* for (TestParameter testParameter: testParameterList) {
            if (testParameter.equals(testparameterSelected)){
                testType.getExternalModule();
                getReferenceValue(testParameter.getParam());


                testParameter.AddResult(refValue,result,metric);
            }
        }
        */
    }

}
