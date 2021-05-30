
package app.adapter;


import app.adapter.interfaces.ExternalModuleReferencesValue;
import app.domain.model.testrelated.RefValue;
import com.example1.ExternalModule3API;

public class ExternalModule3APIAdapter implements ExternalModuleReferencesValue {


    @Override
    public RefValue getRefValue(String parameterId) {
        ExternalModule3API externalAPI = new ExternalModule3API();
        String metric = externalAPI.usedMetric(parameterId, 12345);
        double minValue = externalAPI.getMinReferenceValue(parameterId, 12345);
        double maxValue = externalAPI.getMaxReferenceValue(parameterId, 12345);
        return new RefValue(metric,minValue,maxValue);
    }





}


