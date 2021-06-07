package app.domain.model.testrelated;

import java.io.Serializable;

public class TestParameter implements Serializable {

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
    public TestParameterResult getParamResult() {
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
    public boolean addResult(RefValue refValue, String result, String metric){
        try {
            tparamresult = new TestParameterResult(refValue, result, metric);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    /**
     * Gets the name of the parameter
     * @return the name of the parameter
     */
    public String getParameterName() {
        return param.getShortName();
    }

    /**
     * Gets the code of the parameter
     * @return the code of the parameter
     */
    public String getParameterId(){ return param.getCode(); }

    /**
     * Gets the metric of the parameter
     * @return the metric of the parameter
     */
    public String getParameterMetric() {
        return tparamresult.getMetric();
    }

    /**
     * Gets the result of the test parameter
     * @return the result of the test parameter
     */
    public String getParameterResult() {
        return tparamresult.getResult();
    }

    /**
     * Gets the minimum value of the reference value
     * @return the minimum value of the reference value
     */
    public double getParameterMinRefValue() {
        return tparamresult.getRefValue().getMinValue();
    }

    /**
     * Gets the maximum value of the reference value
     * @return the maximum value of the reference value
     */
    public double getParameterMaxRefValue() {
        return tparamresult.getRefValue().getMaxValue();
    }

    /**
     * Gets the metric of the reference value
     * @return the metric of the reference value
     */
    public String getRefValueMetric() {
        return tparamresult.getRefValue().getMetric();
    }

    @Override
    public String toString() {
        return "TestParameter{" +
                "tparamresult=" + tparamresult +
                ", param=" + param +
                '}';
    }
}
