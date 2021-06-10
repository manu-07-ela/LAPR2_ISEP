package app.mappers.dto;

import java.util.List;

public class testResultDto {
    /**
     * Represents the diagnosis of the medical report
     */
    private final String diagnosis;
    /**
     * Represents the list of Test Parameter DTO
     */
    private final List<TestParameterDTO> tplist;

    public testResultDto(String diagnosis, List<TestParameterDTO> tplist) {
        this.diagnosis = diagnosis;
        this.tplist = tplist;
    }

    public List<TestParameterDTO> getTplist() {
        return tplist;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return  tplist+ "\n" +" Medical Report: " + diagnosis;
    }

}