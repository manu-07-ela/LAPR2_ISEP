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

public class CreateClinicalAnalysisLaboratoryMapperTest {

    ParameterCategoryDto pcDto;
    ParameterCategory pc;
    TestType tt;
    TestTypeDTO ttDTO;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDto> listPCDto;
    List<TestType> testTypeList;
    List<TestTypeDTO> testTypeListDTO;
    CreateClinicalAnalysisLaboratoryMapper calMapper;


    @Before
    public void setup(){
        pcDto=new ParameterCategoryDto("12345","test");
        pc = new ParameterCategory("12345","test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);

        tt = new TestType("98765","test","method",listPC);
        ttDTO = new TestTypeDTO("98765","test","method",listPCDto);


        testTypeList = new ArrayList();
        testTypeList.add(tt);
        testTypeListDTO = new ArrayList<>();
        testTypeListDTO.add(ttDTO);

        calMapper = new CreateClinicalAnalysisLaboratoryMapper();


    }

    @Test
    public void toDomainpc() {
        ParameterCategory result = calMapper.toDomainpc(pcDto);
        Assert.assertEquals(pc,result);
    }

    @Test
    public void toDomainpclis() {
        List<ParameterCategory> result = calMapper.toDomainpclist(listPCDto);
        Assert.assertEquals(listPC,result);
    }

    @Test
    public void toDomain() {
        TestType result = calMapper.toDomain(ttDTO);
        Assert.assertEquals(tt,result);
    }

    @Test
    public void toModel() {
        List<TestType> result = calMapper.toModel(testTypeListDTO);
        Assert.assertEquals(testTypeList,result);
    }


}