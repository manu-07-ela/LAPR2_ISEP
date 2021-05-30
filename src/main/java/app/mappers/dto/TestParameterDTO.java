package app.mappers.dto;

public class TestParameterDTO {

    /**
     * The parameter name.
     */
    private String parameterName;
    /**
     *
     */
    private String parameterId;

    /**
     * The parameter result.
     */
    private String testParameterResult;

    /**
     * The metric of the parameter result.
     */
    private String testParameterMetric;

    /**
     * The minimum reference value of the parameter.
     */
    private double testParameterMinRefValue;

    /**
     * The maximum reference value of the parameter.
     */
    private double testParameterMaxRefValue;

    /**
     * The metric of the reference values.
     */
    private String refValueMetric;


    /**
     * Build an instance of {@code TestParameterDto}.
     * @param parameterName The parameter name.
     * @param parameterId The code of the parameter
     */
    public TestParameterDTO(String parameterName, String parameterId){
        this.parameterName=parameterName;
        this.parameterId=parameterId;

    }

    /**
     *
     * @param parameterName The parameter name.
     * @param testParameterResult The parameter result.
     * @param testParameterMetric
     * @param testParameterMinRefValue
     * @param testParameterMaxRefValue
     * @param refValueMetric
     */
    public TestParameterDTO(String parameterName, String testParameterResult, String testParameterMetric, double testParameterMinRefValue, double testParameterMaxRefValue, String refValueMetric){
        this.parameterName=parameterName;
        this.testParameterResult=testParameterResult;
        this.testParameterMetric=testParameterMetric;
        this.testParameterMinRefValue=testParameterMinRefValue;
        this.testParameterMaxRefValue=testParameterMaxRefValue;
        this.refValueMetric=refValueMetric;
    }

    /**
     * Get the ID of the Test Parameter dto.
     * @return the ID of TestParameterDto.
     */
    public String getParameterId() { return parameterId; }

    /**
     * Get the Name of the Test Parameter dto.
     * @return the Name of TestParameterDto.
     */
    public String getParameterName(){
        return parameterName;
    }

    /**
     * Get the metric of the result of the Test Parameter dto.
     * @return the metric of the result of the TestParameterDto.
     */
    public String getTestParameterMetric() {
        return testParameterMetric;
    }

    /**
     * Get the Result of the Test Parameter dto.
     * @return the Result of TestParameterDto.
     */
    public String getTestParameterResult() {
        return testParameterResult;
    }

    /**
     * Textual description of the TestParameterDTO
     * @return Information about the TestParameterDTO
     */
    @Override
    public String toString() {
        return String.format("----------* %s Parameter Information *----------%n Parameter Result: %s%n Result Metric: %s%n Min Ref Value: %s%n Max Ref Value: %s%n Ref Value Metric: %s",parameterName,testParameterResult,testParameterMetric,testParameterMinRefValue,testParameterMaxRefValue,refValueMetric);
    }

    /**
     * Compare the test parameter dto with the other object provided.
     * @param o Object we want to compare with the test parameter dto.
     * @return true if the received object represents another test parameter dto equivalent to the test parameter dto. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        TestParameterDTO otherTestParameterDTO = (TestParameterDTO) o;

        return this.getParameterName().equals(otherTestParameterDTO.getParameterName()) && this.getTestParameterResult()==null  || this.getParameterName().equals(otherTestParameterDTO.getParameterName()) && this.getTestParameterResult().equalsIgnoreCase(otherTestParameterDTO.getTestParameterResult()) && this.getTestParameterMetric().equalsIgnoreCase(otherTestParameterDTO.getTestParameterMetric());
    }

    /**
     * Textual description of the TestParameterDTO
     * @return Information about the TestParameterDTO
     */
    public String toString2(){
        return String.format("----------* %s Parameter Information *----------%n ParameterId",parameterName,parameterId);
    }

}
