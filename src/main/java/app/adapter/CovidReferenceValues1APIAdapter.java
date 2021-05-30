
package app.adapter;

import app.adapter.interfaces.ExternalModuleReferencesValue;
import app.controller.App;
import app.domain.model.testrelated.RefValue;
import com.example3.CovidReferenceValues1API;

import java.util.Properties;

public class CovidReferenceValues1APIAdapter  implements ExternalModuleReferencesValue {

    @Override
    public RefValue getRefValue(String parameterId) {
        Properties props = App.getInstance().getProps();
        String acessKey = props.getProperty("accessKey");
        int accessKey = Integer.parseInt(acessKey);
        CovidReferenceValues1API covidAPI = new CovidReferenceValues1API();
        double minValue = covidAPI.getMinReferenceValue(parameterId,accessKey);
        double maxValue = covidAPI.getMaxReferenceValue(parameterId, accessKey);
        String metric = covidAPI.usedMetric(parameterId,accessKey);
        return new RefValue(metric,minValue,maxValue);
    }

}


