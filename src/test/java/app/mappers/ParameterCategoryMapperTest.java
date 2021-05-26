package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDtoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapperTest {

    ParameterCategoryDtoTest pcDto;
    ParameterCategory pc;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDtoTest> listPCDto;
    ParameterCategoryMapper pcMapper;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDtoTest("12345","test");
        pc = new ParameterCategory("12345","test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);
        pcMapper = new ParameterCategoryMapper();

    }

    @Test
    public void pcToDto() {
        ParameterCategoryDtoTest result = pcMapper.toDto(pc);
        Assert.assertEquals(pcDto,result);
    }

    @Test
    public void listToDto() {
        List<ParameterCategoryDtoTest> result = pcMapper.toDto(listPC);
        Assert.assertEquals(listPCDto,result);
    }
}