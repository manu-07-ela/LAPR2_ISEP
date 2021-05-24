package app.mappers;

import app.domain.model.Test;
import app.mappers.dto.TestDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Transform objects of type Test into objects of type TestDTO
 * @author Manuela Leite <1200720@isep.ipp.pt>
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */


public class TestMapper {

    /**
     * Transforms an object of type Test into an object of type TestDTO
     * @param test a Test object
     * @return an instance of TestDTO
     */
    public TestDTO toDto(Test test){
        return new TestDTO(test.getInternalCode());
    }

    /**
     * Transforms a list of objects of type Test into a list of objects of type TestDTO
     * @param tests a list of Test
     * @return a list of TestDTO
     */
    public List<TestDTO> toDto(List<Test> tests){
        List<TestDTO> testDto = new ArrayList<>();

        for (Test t : tests){
            testDto.add(this.toDto(t));
        }
        return  testDto;
    }


}
