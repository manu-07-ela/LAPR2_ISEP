
package app.adapter;


import app.domain.model.Parameter;
import app.domain.model.RefValue;
import com.example2.ExternalModule2API;

public class ExternalModule2APIAdapter implements ExternalModuleReferencesValue {

    public RefValue getRefValue(String parameterId){
        ExternalModule2API externalAPI = new ExternalModule2API();
        String metric = externalAPI.getMetricsFor(parameterId);
        double minValue = externalAPI.getReferenceFor(parameterId).getMinValue();
        double maxValue = externalAPI.getReferenceFor(parameterId).getMaxValue();
        return new RefValue(metric,minValue,maxValue);
    }


}


