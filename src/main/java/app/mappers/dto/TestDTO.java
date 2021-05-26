package app.mappers.dto;

import app.domain.model.Test;

/**
 * Represents a data transfer object of Test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */


public class TestDTO {

    /**
     * Represents the internal code associated with a test
     */
    private String internalCode;

    /**
     * Represents the description of a test
     */
    private String description;

    /**
     * Builds a DTO test instantiation by receiving one test per meter
     * @param test the test that will be copied
     */
    public TestDTO(Test test) {
        this.internalCode = test.getInternalCode();
        this.description = test.getTestType().getCollectingMethod();
    }

    /**
     * Takes the internal code associated with a test
     * @return the internal code
     */
    public String getInternalCode(){
        return internalCode;
    }
}
