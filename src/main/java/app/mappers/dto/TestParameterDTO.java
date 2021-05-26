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
     * @param testParameterResult The parameter result.
     * @param testParameterMetric The metric of the parameter result.
     * @param testParameterMinRefValue The minimum reference value of the parameter.
     * @param testParameterMaxRefValue The maximum reference value of the parameter.
     * @param refValueMetric The metric of the reference values.
     */
    public TestParameterDTO (String parameterName,String parameterId, String  testParameterResult, String testParameterMetric, double testParameterMinRefValue, double testParameterMaxRefValue, String refValueMetric){
        this.parameterName=parameterName;
        this.parameterId=parameterId;
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
        return String.format("----------* %s Parameter Information *----------%nResult: %s%nResult Metrics: %s%nMin. Reference Value: %f%nMax. Reference Value: %f%nReference Values Metrics: %s",parameterName,testParameterResult,testParameterMetric,testParameterMinRefValue,testParameterMaxRefValue,refValueMetric);
    }

}
