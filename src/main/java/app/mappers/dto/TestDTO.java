package app.mappers.dto;

/**
 * Represents a data transfer object of Test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */


public class TestDTO {

    /**
     *
     */
    private String internalCode;

    /**
     *
     */
    private String description;

    /**
     *
     * @param internalCodeDto
     */
    public TestDTO(String internalCodeDto) {
        this.internalCode= internalCodeDto;
    }

    /**
     * Takes the internal code associated with a test
     * @return the internal code
     */
    public String getInternalCode(){
        return internalCode;
    }
}
