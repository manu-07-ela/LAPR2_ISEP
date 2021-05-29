package app.mappers;

import app.domain.model.testrelated.*;

import app.mappers.dto.TestParameterDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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

    @Test
    public void testParameterToDto2() {
        ParameterCategory pc = new ParameterCategory("98765","hemogram");
        Parameter p = new Parameter("HB000","HB","test",pc);
        TestParameter tp = new TestParameter(p);
        TestParameterMapper testParameterMapper = new TestParameterMapper();
        TestParameterDTO result = testParameterMapper.testParameterToDTO(tp);
        TestParameterDTO tpDto = new TestParameterDTO("HB","HB000");
        Assert.assertEquals(tpDto,result);
    }

    @Test
    public void listToDto() {
        TestParameterMapper testParameterMapper = new TestParameterMapper();
        ParameterCategory pc = new ParameterCategory("98765","hemogram");
        Parameter p = new Parameter("HB000","HB","test",pc);
        RefValue rv= new RefValue("mg",0,1);
        TestParameterResult tpr = new TestParameterResult(rv,"0.5","mg");
        TestParameter tp = new TestParameter(p,tpr);
        List<TestParameter> list = new ArrayList<>();
        list.add(tp);
        List<TestParameterDTO> listTPDto = new ArrayList<>();
        TestParameterDTO tpDto = new TestParameterDTO("HB","0.5","mg",0,1,"mg");
        listTPDto.add(tpDto);
        List<TestParameterDTO> result = testParameterMapper.toDTO(list);
        Assert.assertEquals(listTPDto,result);
    }

    @Test
    public void listToDto2() {
        TestParameterMapper testParameterMapper = new TestParameterMapper();
        ParameterCategory pc = new ParameterCategory("98765","hemogram");
        Parameter p = new Parameter("HB000","HB","test",pc);
        TestParameter tp = new TestParameter(p);
        List<TestParameter> list = new ArrayList<>();
        list.add(tp);
        List<TestParameterDTO> listTPDto = new ArrayList<>();
        TestParameterDTO tpDto = new TestParameterDTO("HB","HB000");
        listTPDto.add(tpDto);
        List<TestParameterDTO> result = testParameterMapper.testParameterListToDTO(list);
        Assert.assertEquals(listTPDto,result);
    }

}