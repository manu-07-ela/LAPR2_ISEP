package app.mappers;

import app.domain.model.TestParameter;
import app.mappers.dto.TestParameterDTO;

import java.util.ArrayList;
import java.util.List;

public class TestParameterMapper {

    /**
     * Transforms the list of TestParameter into a list of TestParameterDTO
     * @param testParametersList A list of TestParameter
     * @return A list of TestParameterDTO
     */
    public List<TestParameterDTO> toDTO(List<TestParameter> testParametersList) {
        List<TestParameterDTO> testParametersListDto =new ArrayList();
        TestParameterDTO objDTO;
        for (TestParameter lista : testParametersList) {
            if (lista != null){
                objDTO = toDTO(lista);
                testParametersListDto.add(objDTO);
            }
        }
        return testParametersListDto;
    }


    /**
     * Transforms a TestParameter into a TestParameterDTO
     * @param obj a TestParameter
     * @return a TestParameterDTO
     */
    public TestParameterDTO toDTO(TestParameter obj){
        return new TestParameterDTO(obj.getParameterName(), obj.getParameterId(), obj.getParameterResult(), obj.getParameterMetric(), obj.getParameterMinRefValue(), obj.getParameterMaxRefValue(),obj.getRefValueMetric());
    }

}
