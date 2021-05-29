package app.mappers;

import app.domain.model.testrelated.*;
import app.mappers.dto.TestParameterDTO;
import org.junit.Assert;
import org.junit.Test;


public class TestParameterMapperTest {

    @Test
    public void testParameterToDto() {
        ParameterCategory pc = new ParameterCategory("98765","hemogram");
        Parameter p = new Parameter("HB000","HB","test",pc);
        RefValue rv= new RefValue("mg",0,1);
        TestParameterResult tpr = new TestParameterResult(rv,"0.5","mg");
        TestParameter tp = new TestParameter(p,tpr);
        TestParameterMapper testParameterMapper = new TestParameterMapper();
        TestParameterDTO result = testParameterMapper.toDTO(tp);
        TestParameterDTO tpDto = new TestParameterDTO("HB","0.5","mg",0,1,"mg");
        Assert.assertEquals(tpDto,result);
    }

}