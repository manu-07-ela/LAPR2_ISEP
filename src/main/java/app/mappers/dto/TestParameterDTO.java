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
     * 
     * @return
     */
    public String getParameterId() { return parameterId; }

    /**
     * Textual description of the TestParameterDTO
     * @return Information about the TestParameterDTO
     */
    @Override
    public String toString() {
        return String.format("----------* %s Parameter Information *----------%n Parameter Result: %s%n Result Metric: %s%n Min Ref Value: %s%n Max Ref Value: %s%n Ref Value Metric: %s",parameterName,testParameterResult,testParameterMetric,testParameterMinRefValue,testParameterMaxRefValue,refValueMetric);
    }

}
