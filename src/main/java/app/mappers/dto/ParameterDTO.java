package app.mappers.dto;

import app.domain.model.testrelated.ParameterCategory;

/**
 * Represents a data transfer object of parameter
 * @author José Pessoa <1201007@isep.ipp.pt>
 */
public class ParameterDTO {
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
     * Build an instance of {@code TestType} by receiving the code, description, collection method and associated parameter categories.
     * @param code the parameter code
     * @param shortName the parameter short name
     * @param description the parameter description
     */
    public ParameterDTO(String code, String shortName, String description,ParameterCategory cat){
        this.code=code;
        this.shortName= shortName;
        this.description=description;
        this.category=cat;
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
     *Textual description of the parameter dto.
     *@return Information about the characteristics of the parameter dto.
     */


    @Override
    public String toString(){
        return String.format("<Code> %s / <Short Name> %s/ <Description> %s",code,shortName,description);
    }
}
