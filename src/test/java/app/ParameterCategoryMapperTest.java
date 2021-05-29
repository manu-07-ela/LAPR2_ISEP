package app;

import app.domain.model.testrelated.ParameterCategory;
import app.mappers.ParameterCategoryMapper;
import app.mappers.dto.ParameterCategoryDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapperTest {

    ParameterCategoryDTO pcDto;
    ParameterCategory pc;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDTO> listPCDto;
    ParameterCategoryMapper pcMapper;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDTO("12345","test");
        pc = new ParameterCategory("12345","test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);
        pcMapper = new ParameterCategoryMapper();

    }

    @Test
    public void pcToDto() {
        ParameterCategoryDTO result = pcMapper.toDto(pc);
        Assert.assertEquals(pcDto,result);
    }

    @Test
    public void listToDto() {
        List<ParameterCategoryDTO> result = pcMapper.toDto(listPC);
        Assert.assertEquals(listPCDto,result);
    }
}