package app.mappers.dto;

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
    private List<ParameterCategoryDto> listOfParameterCategories;

    /**
     * Build an instance of {@code TestType} by receiving the code, description, collection method and associated parameter categories.
     * @param code The test type code.
     * @param description The description of the test type.
     * @param collectingMethod The test type collecting method.
     * @param listOfParameterCategories List of parameter categories that the test type has associated.
     */
    public TestTypeDTO (String code, String description, String collectingMethod, List<ParameterCategoryDto> listOfParameterCategories){
        this.code=code;
        this.description=description;
        this.collectingMethod=collectingMethod;
        this.listOfParameterCategories=listOfParameterCategories;
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
    public List<ParameterCategoryDto> getListOfParameterCategories() {
        return listOfParameterCategories;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("<Code> %s /  <description> %s / <collectingMethod> %s ",code ,description,collectingMethod);
    }
}
