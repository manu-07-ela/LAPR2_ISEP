package app.mappers;

import app.domain.model.attributes.NhsCode;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestParameter;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
import app.mappers.dto.TestDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMapperTest {
    Client client;
    NhsCode nhsCode;
    ParameterCategory parameterCategory;
    List<ParameterCategory> parameterCategories;
    Parameter parameter;
    TestParameter testParameter;
    List<TestParameter> testParameters;
    app.domain.model.testrelated.Test test;
    TestType testType;
    TestDTO testDTO;
    TestMapper testMapper;
    List<TestDTO> testDTOS;
    ClinicalAnalysisLaboratory lab;
    List<TestType> ttlist;

    @Test
    public void toDto() {
        client = new Client("José Pedrosa","2234567891234567","2234567891","14/12/1995","3231231231","12345678900","pedrosa@gmail.com","Rua da República");
        nhsCode = new NhsCode("123456789012");
        parameterCategory = new ParameterCategory("12se3", "blood");
        parameter = new Parameter("w82ks", "blood", "blood", parameterCategory);
        testParameter = new TestParameter(parameter);
        testParameters = new ArrayList<>();
        ttlist = new ArrayList<>();
        testParameters.add(testParameter);
        parameterCategories = new ArrayList<>();
        parameterCategories.add(parameterCategory);
        testType = new TestType("bag63", "blood", "blood", parameterCategories, "ExternalModule1");
        ttlist.add(testType);
        lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        test = new app.domain.model.testrelated.Test(client, nhsCode, testType, testParameters,lab,"123123123123");
        testMapper = new TestMapper();
        testDTO = new TestDTO(test.getInternalCode(), test.getDescription());
        TestDTO result = testMapper.toDto(test);
        Assert.assertEquals(result.getInternalCode(), test.getInternalCode());

    }

    @Test
    public void testToDto() {
        client = new Client("José Pedrosa","2234567891234567","2234567891","14/12/1995","3231231231","12345678900","pedrosa@gmail.com","Rua da República");
        nhsCode = new NhsCode("123456789012");
        parameterCategory = new ParameterCategory("12se3", "blood");
        parameter = new Parameter("w82ks", "blood", "blood", parameterCategory);
        testParameter = new TestParameter(parameter);
        testParameters = new ArrayList<>();
        ttlist = new ArrayList<>();
        testParameters.add(testParameter);
        parameterCategories = new ArrayList<>();
        parameterCategories.add(parameterCategory);
        testType = new TestType("bag63", "blood", "blood", parameterCategories, "ExternalModule1");
        ttlist.add(testType);
        lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
        test = new app.domain.model.testrelated.Test(client, nhsCode, testType, testParameters,lab,"123456789012");
        testMapper = new TestMapper();
        testDTO = new TestDTO(test.getInternalCode(), test.getDescription());
        testDTOS = new ArrayList<>();
        TestDTO resultAux = testMapper.toDto(test);
        List<TestDTO> result = new ArrayList<>();
        result.add(resultAux);
        testDTOS.add(testDTO);

        for (int i=0; 1<testDTOS.size(); i++){
            Assert.assertEquals(testDTOS.get(i), result.get(i));
        }

    }
}