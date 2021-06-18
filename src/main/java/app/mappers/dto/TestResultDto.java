package app.mappers.dto;

import java.util.List;

public class TestResultDto {
    /**
     * Represents the diagnosis of the medical report
     */
    private final String diagnosis;
    /**
     * Represents the list of Test Parameter DTO
     */
    private final List<TestParameterDTO> tpList;

    /**
     * Build an instance of {@code TestResultDto} by receiving the diagnosis and the parameter list.
     * @param diagnosis the diagnosis
     * @param tplist the parameters list
     */
    public TestResultDto(String diagnosis, List<TestParameterDTO> tplist) {
        this.diagnosis = diagnosis;
        this.tpList = tplist;
    }

    /**
     *Get the parameters associated with the test
     * @return the list of parameters
     */
    public List<TestParameterDTO> getTpList() {
        return tpList;
    }

    /**
     * Get the diagnosis associated with the test
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Textual description of the test result
     * @return the textual description
     */
    @Override
    public String toString() {
        return  tpList + "\n" +" Medical Report: " + diagnosis;
    }

}