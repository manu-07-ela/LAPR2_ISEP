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
    private String refValue;

    /**
     *
     * @param refValue
     * @param result
     * @param metric
     */
    public TestParameterResult(String refValue ,String result , String metric){
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
    public String getRefValue() {
        return refValue;
    }


}
