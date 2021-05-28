package app.mappers;

import app.domain.model.testRelated.Test;
import app.mappers.dto.TestDto;

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
    public TestDto toDto(Test test){
        return new TestDto(test.getInternalCode(),test.getDescription());
    }

    /**
     * Transforms a list of objects of type Test into a list of objects of type TestDTO
     * @param testList a list of Test
     * @return a list of TestDTO
     */
    public List<TestDto> toDto(List<Test> testList){
        List<TestDto> testListDto = new ArrayList<>();

        for (Test t : testList){
            testListDto.add(this.toDto(t));
        }
        return testListDto;
    }


}
