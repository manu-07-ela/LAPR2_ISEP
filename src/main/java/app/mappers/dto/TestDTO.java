package app.mappers.dto;

import app.domain.model.Client;
import app.domain.model.TestParameter;
import app.domain.model.TestType;

import java.util.List;
/**
 * Represents a data transfer object of Test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */


public class TestDTO {

    /**
     * The Client
     */
    private final Client clDto;

    /**
     * Client's National Healthcare Service code
     */
    private final String nhscodeDto;
    /**
     * The list of parameters to be analysedthe list of parameters to be analyzed in a test
     */
    private final List<TestParameter> testParameterListDto;
    /**
     * The type of test associated with the test
     */
    private final TestType testTypeDto;

    /**
     * Creates a new instance of TestDto with the following attributes: citizen card number, nhs code, a list of test parameters and o the type of test.
     * @param clDto the number of the customer's citizen card associated with a test
     * @param nhscodeDto the NHS code associated with a test
     * @param testParameterListDto the list of parameters to be analyzed by the test
     * @param testTypeDto the type of test to be performed
     */
    public TestDTO(Client clDto, String nhscodeDto, List<TestParameter> testParameterListDto, TestType testTypeDto) {
        this.clDto = clDto;
        this.nhscodeDto = nhscodeDto;
        this.testParameterListDto = testParameterListDto;
        this.testTypeDto = testTypeDto;
    }

    /**
     * Takes the number of the citizen card associated with a test
     * @return the citizen card number
     */
    public Client getCitizencardnumberDto() {
        return clDto;
    }

    /**
     * Takes the NHS code associated with a test
     * @return the NHS code
     */
    public String getNhscodeDto() {
        return nhscodeDto;
    }

    /**
     * Takes the list of the parameters associated with a test
     * @return the list of test parameters
     */
    public List<TestParameter> getTestParameterListDto() {
        return testParameterListDto;
    }

    /**
     * Takes the type of the test associated with a test
     * @return the type of the test
     */
    public TestType getTestTypeDto() {
        return testTypeDto;
    }
}
