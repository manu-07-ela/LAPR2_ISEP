package app.mappers.dto;

import app.domain.model.testRelated.Test;

/**
 * Represents a data transfer object of Test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */


public class TestDto {

    /**
     * Represents the internal code associated with a test
     */
    private final String internalCode;

    /**
     * Represents the description of a test
     */
    private final String description;

    /**
     * Creates a new instance of TestDto with the following attributes: internal code and description.
     * @param internalCode internal test code.
     * @param description test description.
     */
    public TestDto(String internalCode, String description) {
        this.internalCode = internalCode;
        this.description = description;
    }

    /**
     * Copy builder for a test
     * @param test the test to be copied
     */
    public TestDto(Test test){
        this.internalCode = test.getInternalCode();
        this.description = test.getDescription();
    }

    /**
     * Takes the internal code associated with a test
     * @return the internal code
     */
    public String getInternalCode(){
        return internalCode;
    }

    /**
     * Textual description of a test
     * @return Information that characterizes a test
     */
    @Override
    public String toString() {
        return String.format("%nInternal Code: %s%nDescription: %s%n", internalCode, description);
    }
}
