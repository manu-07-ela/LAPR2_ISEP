
package app.adapter;


import app.interfaces.ExternalModuleReferencesValue;
import app.controller.App;
import app.domain.model.testrelated.RefValue;
import com.example1.ExternalModule3API;

import java.io.Serializable;
import java.util.Properties;

public class ExternalModule3APIAdapter implements ExternalModuleReferencesValue, Serializable {

    /**
     *  It creates a object of RefValues using the ExternalModule3API
     * @param parameterId The code of the parameter
     * @return an instance of RefValue
     */
    @Override
    public RefValue getRefValue(String parameterId) {
        ExternalModule3API externalAPI = new ExternalModule3API();
        Properties props = App.getInstance().getProps();
        String acessKey = props.getProperty("accessKey");
        int accessKey = Integer.parseInt(acessKey);
        String metric = externalAPI.usedMetric(parameterId, accessKey);
        double minValue = externalAPI.getMinReferenceValue(parameterId, accessKey);
        double maxValue = externalAPI.getMaxReferenceValue(parameterId, accessKey);
        return new RefValue(metric,minValue,maxValue);
    }





}


