package app.mappers.dto;

public class TestParameterDto {

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
    public TestParameterDto(String parameterName, String parameterId){
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
    public TestParameterDto(String parameterName, String testParameterResult, String testParameterMetric, double testParameterMinRefValue, double testParameterMaxRefValue, String refValueMetric){
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
        return String.format("----------* %s Parameter Information *----------%n ParameterId: %s",parameterName,parameterId);
    }

}
