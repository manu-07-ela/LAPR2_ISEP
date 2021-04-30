package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a type of test.
 */

public class TestType {

    /**
     * The test type code.
     */
    private String code;

    /**
     * The description of the test type.
     */
    private String description;

    /**
     * The test type collecting method.
     */
    private String collectingMethod;

    /**
     * List of parameter categories that the test type has associated.
     */
    private List<ParameterCategory> listOfParameterCategories = new ArrayList();

    /**
     *
     * @param code
     * @param description
     * @param collectingMethod
     * @param listOfParameterCategories
     */
    public TestType (String code, String description, String collectingMethod, List<ParameterCategory> listOfParameterCategories){
    }

    /**
     *
     * @param code
     */
    private void checkCodeRules (String code) {
    }

    /**
     *
     * @param description
     */
    private void checkDescriptionRules (String description) {
    }

    /**
     *
     * @param collectingMethod
     */
    private void checkcollectingMethodRules (String collectingMethod) {
    }

}
