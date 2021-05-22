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
    public boolean AddResult(String refValue,String result,String metric){
        tparamresult = new TestParameterResult(refValue,result,metric);
        return true;
    }
}
