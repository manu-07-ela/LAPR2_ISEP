package app.domain.model;

/**
 * Represents a category of parameters.
 */
public class ParameterCategory {

    /**
     * The parameter category code.
     */
    private String code;

    /**
     * The name of the parameter category.
     */
    private String name;

    /**
     * Constructs an instance of {@code ParameterCategory} receiving the code and name
     *
     * @param code the parameter category code
     * @param name the parameter category name
     */
    public ParameterCategory(String code, String name){
        this.code=code;
        this.name=name;
    }
}
