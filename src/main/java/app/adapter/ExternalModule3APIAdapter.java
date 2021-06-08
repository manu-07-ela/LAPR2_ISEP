
package app.adapter;


import app.adapter.interfaces.ExternalModuleReferencesValue;
import app.domain.model.testrelated.RefValue;
import com.example1.ExternalModule3API;

import java.io.Serializable;

public class ExternalModule3APIAdapter implements ExternalModuleReferencesValue, Serializable {

    /**
     *  It creates a object of RefValues using the ExternalModule3API
     * @param parameterId The code of the parameter
     * @return an instance of RefValue
     */
    @Override
    public RefValue getRefValue(String parameterId) {
        ExternalModule3API externalAPI = new ExternalModule3API();
        String metric = externalAPI.usedMetric(parameterId, 12345);
        double minValue = externalAPI.getMinReferenceValue(parameterId, 12345);
        double maxValue = externalAPI.getMaxReferenceValue(parameterId, 12345);
        return new RefValue(metric,minValue,maxValue);
    }





}


