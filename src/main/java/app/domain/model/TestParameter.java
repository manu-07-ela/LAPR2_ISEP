package app.domain.model;

public class TestParameter {

    /**
     *
     */
    private TestParameterResult tparamresult;
    /**
     *
     */
    private Parameter param;

    /**
     *
     * @param param
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
     *
     * @return
     */
    public TestParameterResult getTparamresult() {
        return tparamresult;
    }
    /**
     *
     * @return
     */
    public Parameter getParam() {
        return param;
    }

    /**
     *
     * @param refValue
     * @param result
     * @param metric
     * @return
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
