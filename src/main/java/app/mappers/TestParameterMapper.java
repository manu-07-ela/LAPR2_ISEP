package app.mappers;

import app.domain.model.testRelated.TestParameter;
import app.mappers.dto.TestParameterDto;

import java.util.ArrayList;
import java.util.List;

public class TestParameterMapper {

    /**
     * Transforms the list of TestParameter into a list of TestParameterDTO.
     * @param testParametersList A list of TestParameter.
     * @return A list of TestParameterDTO.
     */
    public List<TestParameterDto> toDTO(List<TestParameter> testParametersList) {
        List<TestParameterDto> testParametersListDto =new ArrayList();
        TestParameterDto objDTO;
        for (TestParameter lista : testParametersList) {
            if (lista != null){
                objDTO = toDTO(lista);
                testParametersListDto.add(objDTO);
            }
        }
        return testParametersListDto;
    }

    /**
     * Transforms the list of TestParameter into a list of TestParameterDTO
     * @param objList A list of TestParameter
     * @return A list of TestParameterDTO
     */
    public List<TestParameterDto> testParameterListToDTO(List<TestParameter> objList) {
        List<TestParameterDto> testParametersListDto =new ArrayList();
        TestParameterDto objDTO;
        for (TestParameter lista : objList) {
            if (lista != null){
                objDTO = testParameterToDTO(lista);
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
    public TestParameterDto testParameterToDTO(TestParameter obj){
        return new TestParameterDto(obj.getParameterName(), obj.getParameterId());
    }

    /**
     * Transforms a TestParameter into a TestParameterDTO.
     * @param testParameter A TestParameter.
     * @return A TestParameterDTO.
     */
    public TestParameterDto toDTO(TestParameter testParameter){
        return new TestParameterDto(testParameter.getParameterName(), testParameter.getParameterResult(), testParameter.getParameterMetric(), testParameter.getParameterMinRefValue(), testParameter.getParameterMaxRefValue(), testParameter.getRefValueMetric() );
    }

}
