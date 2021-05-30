package app.mappers;

import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.TestTypeDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTyperMapperTest {
    ParameterCategoryDTO pcDto;
    ParameterCategory pc;
    TestType tt;
    TestTypeDTO ttDTO;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDTO> listPCDto;
    List<TestType> testTypeList;
    List<TestTypeDTO> testTypeListDTO;
    TestTyperMapper ttMapper;

    @Before
    public void setup() {
        pcDto = new ParameterCategoryDTO("12345", "test");
        pc = new ParameterCategory("12345", "test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);

        //tt = new TestType("98765", "test", "method", listPC);
        //ttDTO = new TestTypeDTO("98765", "test", "method", listPCDto);


        testTypeList = new ArrayList();
        testTypeList.add(tt);
        testTypeListDTO = new ArrayList<>();
        testTypeListDTO.add(ttDTO);

        ttMapper= new TestTyperMapper();
    }

/*
    @Test
    public void toDTOlist() {
        List<TestTypeDTO> result = ttMapper.toDTO(testTypeList);
        Assert.assertEquals(testTypeListDTO,result);
    }

    @Test
    public void toDTO() {
        TestTypeDTO result = ttMapper.toDTO(tt);
        Assert.assertEquals(ttDTO,result);
    }

 */



    @Test
    public void toDTOpclist() {
        List<ParameterCategoryDTO> result = ttMapper.toDtopclist(listPC);
        Assert.assertEquals(listPCDto,result);
    }

    @Test
    public void toDTOlistpc() {
        ParameterCategoryDTO result = ttMapper.toDtopc(pc);
        Assert.assertEquals(pcDto,result);
    }

    @Test
    public void toModelpclist() {
        List<ParameterCategory> result = ttMapper.toModelpclist(listPCDto);
        Assert.assertEquals(listPC,result);
    }

    @Test
    public void toModellistpc() {
        ParameterCategory result = ttMapper.toModelpc(pcDto);
        Assert.assertEquals(pc,result);
    }
}