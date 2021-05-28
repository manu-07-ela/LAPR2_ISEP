package app.domain.model.testrelated;

public class TestParameter {

    /**
     * The result of the testParameter
     */
    private TestParameterResult tparamresult;
    /**
     *The parameter of the testParameter
     */
    private Parameter param;

    /**
     * Constructs an instance of TestParameter
     * @param param A parameter
     */
    public TestParameter (Parameter param){
        this.param=param;
        this.tparamresult=null;
    }

    /**
     *
     * @param param
     * @param tparamresult
     */
    public TestParameter (Parameter param,TestParameterResult tparamresult){
        this.param=param;
        this.tparamresult=tparamresult;
    }

    /**
     * Get the TestParameter result
     * @return the TestParameter result
     */
    public TestParameterResult getTparamresult() {
        return tparamresult;
    }
    /**
     * Get the Parameter of the TestParameter
     * @return the parameter of the TestParameter
     */
    public Parameter getParam() {
        return param;
    }

    /**
     * It adds the result of the testParameter
     * @param refValue An object of RefValue with the reference values
     * @param result The result of the testParameter
     * @param metric the metric of the result
     * @return true if the result was successful
     */
    public boolean AddResult(RefValue refValue, String result, String metric){
        tparamresult = new TestParameterResult(refValue, result, metric);
        return true;
    }

    /**
     *
     * @return
     */
    public String getParameterName() {
        return param.getShortName();
    }

    /**
     *
     * @return
     */
    public String getParameterId(){ return param.getCode(); }

    /**
     *
     * @return
     */
    public String getParameterMetric() {
        return tparamresult.getMetric();
    }

    /**
     *
     * @return
     */
    public String getParameterResult() {
        return tparamresult.getResult();
    }

    /**
     *
     * @return
     */
    public double getParameterMinRefValue() {
        return tparamresult.getRefValue().getMinValue();
    }

    /**
     *
     * @return
     */
    public double getParameterMaxRefValue() {
        return tparamresult.getRefValue().getMaxValue();
    }

    /**
     *
     * @return
     */
    public String getRefValueMetric() {
        return tparamresult.getRefValue().getMetric();
    }
}
