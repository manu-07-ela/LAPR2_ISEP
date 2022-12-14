package app.mappers;

import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.TestTypeDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateClinicalAnalysisLaboratoryMapperTest {

    ParameterCategoryDTO pcDto;
    ParameterCategory pc;
    TestType tt;
    TestTypeDTO ttDTO;
    List<ParameterCategory> listPC;
    List<ParameterCategoryDTO> listPCDto;
    List<TestType> testTypeList;
    List<TestTypeDTO> testTypeListDTO;
    ClinicalAnalysisLaboratory cal;
    ClinicalAnalysisLaboratoryDTO calDTO;
    CreateClinicalAnalysisLaboratoryMapper calMapper;


    @Before
    public void setup(){
        pcDto = new ParameterCategoryDTO("12345","test");
        pc = new ParameterCategory("12345","test");
        listPC = new ArrayList();
        listPCDto = new ArrayList();
        listPC.add(pc);
        listPCDto.add(pcDto);
        /*
        tt = new TestType("98765","test","method",listPC);
        ttDTO = new TestTypeDTO("98765","test","method",listPCDto);

         */


        testTypeList = new ArrayList();
        testTypeList.add(tt);
        testTypeListDTO = new ArrayList<>();
        testTypeListDTO.add(ttDTO);


        cal = new ClinicalAnalysisLaboratory("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeList);
        calDTO = new ClinicalAnalysisLaboratoryDTO("Carlos","Rua das cavalas","12345678912","1234567891","12ki3",testTypeListDTO);
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

    /*@Test
    public void toDomain() {
        TestType result = calMapper.toDomain(ttDTO);
        Assert.assertEquals(tt,result);
    }

    @Test
    public void toModel2() {
        List<TestType> result = calMapper.toModel(testTypeListDTO);
        Assert.assertEquals(testTypeList,result);
    }*/

    @Test
    public void toModel1() {
        ClinicalAnalysisLaboratory result = calMapper.toModel(calDTO);
        Assert.assertEquals(cal,result);
    }

//    @Test
//    public void toDto() {
//        ClinicalAnalysisLaboratoryDTO result = calMapper.toDto(cal);
//        Assert.assertEquals(calDTO,result);
//    }

    @Test
    public void toDtopc() {
        ParameterCategoryDTO result = calMapper.toDtopc(pc);
        Assert.assertEquals(pcDto,result);
    }

    @Test
    public void toDtopclis() {
        List<ParameterCategoryDTO> result = calMapper.toDtopclist(listPC);
        Assert.assertEquals(listPCDto,result);
    }

//    @Test
//    public void toDtoo() {
//        List<TestTypeDTO> result = calMapper.toDtoo(testTypeList);
//        Assert.assertEquals(testTypeListDTO,result);
//    }
//
//    @Test
//    public void toDtoo2() {
//        TestTypeDTO result = calMapper.toDtoo(tt);
//        Assert.assertEquals(ttDTO,result);
//    }
}