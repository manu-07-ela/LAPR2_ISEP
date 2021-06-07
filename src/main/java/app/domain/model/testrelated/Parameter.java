package app.domain.model.testrelated;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;


/**
 * Represents a parameter.
 *
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class Parameter implements Serializable {

    /**
     * The parameter code.
     */
    private String code;

    /**
     * The short name of the parameter.
     */
    private String shortName;

    /**
     * The description of the parameter.
     */
    private String description;

    /**
     * The Category of the parameter.
     */
    private ParameterCategory category;

    /**
     * Constructs an instance of {@code Parameter} receiving the code, the short name and the description.
     *
     * @param code the parameter code
     * @param shortName the parameter short name
     * @param description the parameter description
     */
    public Parameter(String code, String shortName, String description,ParameterCategory cat){
        checkRules(code, shortName, description,cat);
        this.code=code;
        this.shortName= shortName;
        this.description=description;
        this.category=cat;
    }

    /**
     * Checks if the code, the short name and the description, associated with the parameter, respects the business rules.
     * @param code The parameter code.
     * @param shortName The short name of the parameter.
     * @param description The description of the parameter.
     */
    private void checkRules (String code, String shortName, String description, ParameterCategory cat) {

        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( !StringUtils.isAlphanumeric(code) || code.length() != 5 )
            throw new IllegalArgumentException("The code must be 5 alphanumeric characters.");
        if ( !StringUtils.isAlphanumeric(code) || code.equals(cat.getCode()))
            throw new IllegalArgumentException("The Parameter Code cannot be the same as the Parameter Category Code");

        if (StringUtils.isBlank(shortName))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (shortName.length() > 10)
            throw new IllegalArgumentException("The name must be a maximum of 10 characters.");

        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (description.length() > 20)
            throw new IllegalArgumentException("The name must be a maximum of 20 characters.");

    }


    /**
     * Get the parameter code.
     * @return The parameter code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Get the short name of the parameter.
     * @return The short name of the parameter.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Get the description of the parameter.
     * @return The description of the parameter.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the category of the parameter.
     * @return The category of the parameter.
     */
    public ParameterCategory getCategory() {
        return category;
    }

    /**
     * Compare the parameter with the other object provided.
     * @param obj Object we want to compare with the parameter.
     * @return true if the received object represents another parameter equivalent to the parameter. Otherwise, it returns false.
     */

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Parameter auxParameter = (Parameter) obj;
        return this.getCode().equals(auxParameter.getCode()) || this.getShortName().equalsIgnoreCase(auxParameter.getShortName()) || this.getDescription().equalsIgnoreCase(auxParameter.getShortName());
    }

    /**
     * Textual description of the parameter.
     * @return Information about the characteristics of the parameter.
     */
    @Override
    public String toString(){
        return String.format("Parameter: %s%nCode: %s%nDescription: %s", shortName, code, description);
    }



}
