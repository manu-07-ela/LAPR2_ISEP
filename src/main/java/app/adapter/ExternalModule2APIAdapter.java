/*
package app.adapter;


import app.domain.model.Parameter;
import app.domain.model.RefValue;
import com.example2.ExternalModule2API;

public class ExternalModule2APIAdapter implements ExternalModuleReferencesValue {

    public RefValue getRefValue(Parameter parameter){
        ExternalModule2API externalAPI = new ExternalModule2API();
        String metric = externalAPI.getMetricsFor(parameter.getCode());
        double minValue = externalAPI.getReferenceFor(parameter.getCode()).getMinValue();
        double maxValue = externalAPI.getReferenceFor(parameter.getCode()).getMaxValue();
        return new RefValue(metric,minValue,maxValue);
    }


}*/

