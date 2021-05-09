package app.mappers;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTyperMapperTest {
    ParameterCategoryDto pcDto;
    ParameterCategory pc;
    TestType tt;
    TestTypeDTO ttDTO;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDto> listPCDto;
    List<TestType> testTypeList;
    List<TestTypeDTO> testTypeListDTO;
    TestTyperMapper ttMapper;

    @Before
    public void setup() {
        pcDto = new ParameterCategoryDto("12345", "test");
        pc = new ParameterCategory("12345", "test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);

        tt = new TestType("98765", "test", "method", listPC);
        ttDTO = new TestTypeDTO("98765", "test", "method", listPCDto);


        testTypeList = new ArrayList();
        testTypeList.add(tt);
        testTypeListDTO = new ArrayList<>();
        testTypeListDTO.add(ttDTO);

        ttMapper= new TestTyperMapper();
    }

    @Test
    public void toDTOlist() {
        List<TestTypeDTO> result = ttMapper.toDTO(testTypeList);
        Assert.assertEquals(testTypeListDTO,result);
    }

    @Test
    public void toDTO() {
        TestTypeDTO result = ttMapper.toDTO(tt);
        Assert.assertEquals(tt,result);
    }

    @Test
    public void toDTOpclist() {
        List<ParameterCategoryDto> result = ttMapper.toDtopclist(listPC);
        Assert.assertEquals(listPCDto,result);
    }

    @Test
    public void toDTOlistpc() {
        ParameterCategoryDto result = ttMapper.toDtopc(pc);
        Assert.assertEquals(pcDto,result);
    }

}