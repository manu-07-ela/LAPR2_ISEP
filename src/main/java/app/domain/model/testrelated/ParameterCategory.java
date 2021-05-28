package app.domain.model.testrelated;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a category of parameters.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
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
        checkCodeRules(code);
        checkNameRules(name);
        this.code=code;
        this.name=name;
    }

    /**
     * Checks whether the code associated with the parameter category we intend to create complies with all business rules.
     * @param code The parameter category code.
     */
    private void checkCodeRules (String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( !StringUtils.isAlphanumeric(code) || code.length() != 5 )
            throw new IllegalArgumentException("The code must be 5 alphanumeric characters.");
    }

    /**
     * Checks whether the name associated with the parameter category we intend to create complies with all business rules.
     * @param name The name of the parameter category.
     */
    private void checkNameRules (String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 10)
            throw new IllegalArgumentException("The name must be a maximum of 10 characters.");
    }

    /**
     * Get the name of the parameter category.
     * @return The name of the parameter category.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the parameter category code.
     * @return The parameter category code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Compare the parameter category with the other object provided.
     * @param o Object we want to compare with the parameter category.
     * @return true if the received object represents another parameter category equivalent to the parameter category. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        ParameterCategory otherParameterCategory = (ParameterCategory) o;

        return this.getCode().equals(otherParameterCategory.getCode()) || this.getName().equalsIgnoreCase(otherParameterCategory.getName());
    }

    /**
     * Textual description of the parameter category.
     * @return Information about the characteristics of the parameter category.
     */
    @Override
    public String toString(){
        return String.format("<Name> %s / <Code> %s",name,code);
    }
}
