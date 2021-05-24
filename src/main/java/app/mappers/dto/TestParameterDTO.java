package app.mappers.dto;

import app.domain.model.Parameter;
import app.domain.model.TestParameterResult;

public class TestParameterDTO {

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
     * @param tparamresult
     */
    public TestParameterDTO (Parameter param,TestParameterResult tparamresult){
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
}
