package app.mappers;

import app.domain.model.testrelated.Test;
import app.mappers.dto.TestResultDto;

public class TestResultsMapper {
    /**
     * Transforms an object of type TestResult into an object of type TestResultDto
     * @param t a TestResult object
     * @return an instance of TestDTO
     */
    public TestResultDto toDTO(Test t){
        TestParameterMapper tpMapper = new TestParameterMapper();
        return new TestResultDto(t.getMedicalReport().getDiagnosis(),tpMapper.toDTO(t.getTestParameterList()));
    }
}