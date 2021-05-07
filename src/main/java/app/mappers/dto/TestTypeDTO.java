package app.mappers.dto;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class TestTypeDTO {
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
    private List<ParameterCategory> listOfParameterCategories;

    /**
     * Build an instance of {@code TestType} by receiving the code, description, collection method and associated parameter categories.
     * @param code The test type code.
     * @param description The description of the test type.
     * @param collectingMethod The test type collecting method.
     * @param listOfParameterCategories List of parameter categories that the test type has associated.
     */
    public TestTypeDTO (String code, String description, String collectingMethod, List<ParameterCategory> listOfParameterCategories){
        checkCodeRules(code);
        checkDescriptionRules(description);
        checkcollectingMethodRules(collectingMethod);
        this.code=code;
        this.description=description;
        this.collectingMethod=collectingMethod;
        this.listOfParameterCategories=listOfParameterCategories;
    }

    public TestTypeDTO (TestType obj){
        checkCodeRules(obj.getCode());
        checkDescriptionRules(obj.getDescription());
        checkcollectingMethodRules(obj.getCollectingMethod());
        this.code= obj.getCode();
        this.description= obj.getDescription();
        this.collectingMethod=obj.getCollectingMethod();
        this.listOfParameterCategories=obj.getListOfParameterCategories();
    }

    /**
     * Checks whether the code associated with the type of test we intend to create complies with all business rules.
     * @param code The test type code.
     */
    private void checkCodeRules (String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( !StringUtils.isAlphanumeric(code) || code.length() != 5 )
            throw new IllegalArgumentException("The code must be 5 alphanumeric characters.");
    }

    /**
     * Checks whether the description associated with the type of test we intend to create complies with all business rules.
     * @param description The description of the test type.
     */
    private void checkDescriptionRules (String description) {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank.");
        if (description.length() > 15)
            throw new IllegalArgumentException("The description must be a maximum of 15 characters.");
    }

    /**
     * Checks whether the collecting Method associated with the type of test we intend to create complies with all business rules.
     * @param collectingMethod The test type collecting method.
     */
    private void checkcollectingMethodRules (String collectingMethod) {
        if (StringUtils.isBlank(collectingMethod))
            throw new IllegalArgumentException("Collecting Method cannot be blank.");
        if (collectingMethod.length() > 20)
            throw new IllegalArgumentException("The collection method must be a maximum of 20 characters.");
    }

    /**
     * Get the test type code.
     * @return The test type code.
     */
    public String getCode (){
        return code;
    }

    /**
     * Get the test type description.
     * @return The test type description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the method of collecting the test type.
     * @return The test type collecting method.
     */
    public String getCollectingMethod() {
        return collectingMethod;
    }

    /**
     * Get the categories of parameters associated with the type of test.
     * @return List of parameter categories that the test type has associated.
     */
    public List<ParameterCategory> getListOfParameterCategories() {
        return listOfParameterCategories;
    }

}
