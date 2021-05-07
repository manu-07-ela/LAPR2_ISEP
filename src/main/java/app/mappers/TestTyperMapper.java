package app.mappers;

import app.domain.model.TestType;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class TestTyperMapper {


    public static List<TestTypeDTO> toModel(List<TestType> testTypeList) {
        List<TestTypeDTO> testTypeListDTO =new ArrayList();
        TestTypeDTO objDTO;
        for (TestType lista : testTypeList) {
            if (lista != null){
                objDTO = ToDTO(lista);
                testTypeListDTO.add(objDTO);
            }
        }
        return testTypeListDTO;
    }

    public static TestTypeDTO ToDTO(TestType obj){
        return new TestTypeDTO(obj);
    }
}
