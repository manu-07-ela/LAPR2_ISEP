
package app.adapter;

import app.domain.model.RefValue;
import com.example3.CovidReferenceValues1API;

public class CovidReferenceValues1APIAdapter  implements ExternalModuleReferencesValue {

    @Override
    public RefValue getRefValue(String parameterId) {
        CovidReferenceValues1API covidAPI = new CovidReferenceValues1API();
        double minValue = covidAPI.getMinReferenceValue(parameterId,12345);
        double maxValue = covidAPI.getMaxReferenceValue(parameterId, 12345);
        String metric = covidAPI.usedMetric(parameterId,12345);
        return new RefValue(metric,minValue,maxValue);
    }

}


