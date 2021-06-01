
package app.adapter;


import app.adapter.interfaces.ExternalModuleReferencesValue;
import app.domain.model.testrelated.RefValue;
import com.example2.ExternalModule2API;

public class ExternalModule2APIAdapter implements ExternalModuleReferencesValue {

    /**
     *  It creates a object of RefValues using the ExternalModule2API
     * @param parameterId The code of the parameter
     * @return an instance of RefValue
     */
    public RefValue getRefValue(String parameterId){
        ExternalModule2API externalAPI = new ExternalModule2API();
        String metric = externalAPI.getMetricsFor(parameterId);
        double minValue = externalAPI.getReferenceFor(parameterId).getMinValue();
        double maxValue = externalAPI.getReferenceFor(parameterId).getMaxValue();
        return new RefValue(metric,minValue,maxValue);
    }


}


