package app.domain.model;

import com.example1.ExternalModule3API;

public class ExternalModule3APIAdapter implements ExternalModuleReferencesValue{

    @Override
    public RefValue getRefValue(Parameter parameter) {
        ExternalModule3API externalAPI = new ExternalModule3API();
        String metric = externalAPI.usedMetric(parameter.getCode(), 12345);
        double minValue = externalAPI.getMinReferenceValue(parameter.getCode(), 12345);
        double maxValue = externalAPI.getMaxReferenceValue(parameter.getCode(), 12345);
        return new RefValue(metric,minValue,maxValue);
    }
}
