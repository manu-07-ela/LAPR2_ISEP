package app.domain.model;

public class TestParameterResult {
    /**
     *
     */
    private String metric;
    /**
     *
     */
    private String result;
    /**
     *
     */
    private RefValue refValue;

    /**
     *
     * @param refValue
     * @param result
     * @param metric
     */
    public TestParameterResult(RefValue refValue , String result , String metric){
        this.refValue=refValue;
        this.result = result;
        this.metric = metric;
    }

    /**
     *
     * @return
     */
    public String getMetric() {
        return metric;
    }
    /**
     *
     * @return
     */
    public String getResult() {
        return result;
    }
    /**
     *
     * @return
     */
    public RefValue getRefValue() {
        return refValue;
    }


}
