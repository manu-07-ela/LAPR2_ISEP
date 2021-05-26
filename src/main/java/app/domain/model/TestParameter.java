package app.domain.model;

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
    public boolean AddResult(RefValue refValue,String result,String metric){
        try {
            tparamresult = new TestParameterResult(refValue, result, metric);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
