package app.mappers;

import app.domain.model.TestParameter;
import app.mappers.dto.TestParameterDTO;

import java.util.ArrayList;
import java.util.List;

public class TestParameterMapper {

    /**
     *
     * @param testParameters
     * @return
     */
    public List<TestParameterDTO> toDTO(List<TestParameter> testParameters) {
        List<TestParameterDTO> testParameterDTOList =new ArrayList();
        TestParameterDTO objDTO;
        for (TestParameter lista : testParameters) {
            if (lista != null){
                objDTO = toDTO(lista);
                testParameterDTOList.add(objDTO);
            }
        }
        return testParameterDTOList;
    }

    /**
     *
     * @param obj
     * @return
     */
    public TestParameterDTO toDTO(TestParameter obj){
        return new TestParameterDTO(obj.getParam(), obj.getTparamresult());
    }

    public TestParameter toModel (TestParameterDTO obj){
        return new TestParameter(obj.getParam(),obj.getTparamresult());
    }
}
