package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterCategoryMapperTest {

    ParameterCategoryDto pcDto;
    ParameterCategory pc;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDto> listPCDto;
    ParameterCategoryMapper pcMapper;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDto("12345","test");
        pc = new ParameterCategory("12345","test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);
        pcMapper = new ParameterCategoryMapper();

    }

    @Test
    public void pcToDto() {
        ParameterCategoryDto result = pcMapper.toDto(pc);
        Assert.assertNotEquals(pcDto,result);
    }

    @Test
    public void listToDto() {
        List<ParameterCategoryDto> result = pcMapper.toDto(listPC);
        Assert.assertNotEquals(listPCDto,result);
    }
}