package app.mappers;

import app.domain.model.testrelated.TestParameter;
import app.mappers.dto.TestParameterDTO;

import java.util.ArrayList;
import java.util.List;

public class TestParameterMapper {

    /**
     * Transforms the list of TestParameter into a list of TestParameterDTO.
     * @param testParametersList A list of TestParameter.
     * @return A list of TestParameterDTO.
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
     * Transforms the list of TestParameter into a list of TestParameterDTO
     * @param objList A list of TestParameter
     * @return A list of TestParameterDTO
     */
    public List<TestParameterDTO> testParameterListToDTO(List<TestParameter> objList) {
        List<TestParameterDTO> testParametersListDto =new ArrayList();
        TestParameterDTO objDTO;
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
    public TestParameterDTO testParameterToDTO(TestParameter obj){
        return new TestParameterDTO(obj.getParameterName(), obj.getParameterId());
    }

    /**
     * Transforms a TestParameter into a TestParameterDTO.
     * @param testParameter A TestParameter.
     * @return A TestParameterDTO.
     */
    public TestParameterDTO toDTO(TestParameter testParameter){
        return new TestParameterDTO(testParameter.getParameterName(), testParameter.getParameterResult(), testParameter.getParameterMetric(), testParameter.getParameterMinRefValue(), testParameter.getParameterMaxRefValue(), testParameter.getRefValueMetric() );
    }

}
