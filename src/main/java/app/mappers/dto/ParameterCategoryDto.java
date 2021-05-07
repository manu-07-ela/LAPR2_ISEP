package app.mappers.dto;

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
     *
     * @return
     */
    @Override
    public String toString(){
        return String.format("<Parameter Category> %s - <Code> %s",name,code);
    }
}
