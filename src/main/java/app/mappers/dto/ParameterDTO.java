package app.mappers.dto;

import java.util.Objects;

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
    private ParameterCategoryDTO category;

    /**
     * Build an instance of {@code TestType} by receiving the code, description, collection method and associated parameter categories.
     * @param code the parameter code
     * @param shortName the parameter short name
     * @param description the parameter description
     */
    public ParameterDTO(String code, String shortName, String description,ParameterCategoryDTO cat){
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
    public ParameterCategoryDTO getCategory() {
        return category;
    }

    /**
     *Textual description of the parameter dto.
     *@return Information about the characteristics of the parameter dto.
     */

    /**
     * Textual description of a parameter
     * @return the textual description
     */
    @Override
    public String toString(){
        return String.format("<Code> %s / <Short Name> %s/ <Description> %s",code,shortName,description);
    }

    /**
     * Compare the parameter DTO with the other object provided
     * @param other Object we want to compare with the parameter DTO
     * @return true if the received object represents another parameterDTO equivalent to the parameterDTO. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ParameterDTO that = (ParameterDTO) other;
        return Objects.equals(code, that.code) && Objects.equals(shortName, that.shortName) && Objects.equals(description, that.description) && Objects.equals(category, that.category);
    }

}
