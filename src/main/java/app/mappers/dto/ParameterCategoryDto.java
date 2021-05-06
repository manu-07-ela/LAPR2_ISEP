package app.mappers.dto;

/**
 *
 */
public class ParameterCategoryDto {

    /**
     *
     */
    private String code;

    /**
     *
     */
    private String name;


    /**
     *
     * @param code
     * @param name
     */
    public ParameterCategoryDto(String code,String name){
        this.code=code;
        this.name=name;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
