package app.interfaces;

import app.domain.model.testrelated.RefValue;

public interface ExternalModuleReferencesValue {
    /**
     * Method that will generate and return the reference value that will be associated with a parameter result
     * @param parameterId the parameter id
     * @return the reference value
     */
     RefValue getRefValue(String parameterId);

}
