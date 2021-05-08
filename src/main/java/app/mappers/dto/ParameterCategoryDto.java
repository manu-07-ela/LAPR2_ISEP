package app.mappers.dto;

import app.domain.model.ParameterCategory;

/**
 * Represents a data transfer object of parameter category.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ParameterCategoryDto {

    /**
     * The code of the data transfer object of the type parameter category.
     */
    private String code;

    /**
     * The name of the data transfer object of the type parameter category.
     */
    private String name;


    /**
     * Creates a new instance of ParameterCategoryDto with the following attributes: code and name.
     * @param code parameter category's code.
     * @param name parameter category's name.
     */
    public ParameterCategoryDto(String code,String name){
        this.code=code;
        this.name=name;
    }

    /**
     * Get the code of the parameter category.
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Get the name of the parameter category.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *Textual description of the parameter category dto.
     *@return Information about the characteristics of the parameter category dto.
     */
    @Override
    public String toString(){
        return String.format("<Name> %s / <Code> %s",name,code);
    }

    /**
     * Compare the parameter category dto with the other object provided.
     * @param o Object we want to compare with the parameter category.
     * @return true if the received object represents another parameter category dto equivalent to the parameter category dto. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        ParameterCategoryDto otherParameterCategoryDto = (ParameterCategoryDto) o;

        return this.getCode().equals(otherParameterCategoryDto.getCode()) && this.getName().equalsIgnoreCase(otherParameterCategoryDto.getName());
    }
}
