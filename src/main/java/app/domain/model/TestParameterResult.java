package app.domain.model;

public class TestParameterResult {
    /**
     * The metric of the result
     */
    private String metric;
    /**
     * The result of the TestParameter
     */
    private String result;
    /**
     * An object of RefValue with the reference values
     */
    private RefValue refValue;

    /**
     * Constructs an instance of the TestParameterResult
     * @param refValue An object of RefValue with the reference values
     * @param result The result of the testParameter
     * @param metric The metric of the result
     */
    public TestParameterResult(RefValue refValue , String result , String metric){
        this.refValue=refValue;
        this.result = result;
        this.metric = metric;
    }

    /**
     * Get the metric of the result
     * @return the metric of the result
     */
    public String getMetric() {
        return metric;
    }
    /**
     * Get the result of the TestParameter
     * @return the result of the TestParameter
     */
    public String getResult() {
        return result;
    }
    /**
     * Get the object of the reference values
     * @return an object of the reference values
     */
    public RefValue getRefValue() {
        return refValue;
    }


}
