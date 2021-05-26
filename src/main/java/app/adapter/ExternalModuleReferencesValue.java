package app.adapter;


import app.domain.model.Parameter;
import app.domain.model.RefValue;

public interface ExternalModuleReferencesValue {

    public RefValue getRefValue(String parameterId);

}
