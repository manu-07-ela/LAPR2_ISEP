package app.mappers;

import app.domain.model.testrelated.Test;
import app.mappers.dto.testResultDto;

public class TestResultsMapper {
    public testResultDto toDTO(Test t){
        TestParameterMapper tpmapper = new TestParameterMapper();
        return new testResultDto(t.getMedicalReport(),tpmapper.toDTO(t.getTestParameterList()));
    }
}