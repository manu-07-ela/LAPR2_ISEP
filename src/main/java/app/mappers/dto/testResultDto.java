package app.mappers.dto;

import app.domain.model.testrelated.MedicalReport;

import java.util.List;

public class testResultDto {
    /**
     * Represents the medicalreport
     */
    private final MedicalReport medicalreport;
    /**
     * Represents the list of Test Parameter DTO
     */
    private final List<TestParameterDTO> tplist;

    public testResultDto(MedicalReport medicalreport, List<TestParameterDTO> tplist) {
        this.medicalreport = medicalreport;
        this.tplist = tplist;
    }

    public List<TestParameterDTO> getTplist() {
        return tplist;
    }

    public MedicalReport getMedicalreport() {
        return medicalreport;
    }

    @Override
    public String toString() {
        return "testResultDto{" +
                "medicalreport='" + medicalreport + '\'' +
                ", tplist=" + tplist +
                '}';
    }
}
