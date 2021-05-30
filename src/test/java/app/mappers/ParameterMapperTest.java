package app.mappers;

import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParameterMapperTest {

    @Test
    public void toDtolista() {
        ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);


        List<ParameterDTO> parameterDTOS = new ArrayList<>();
        ParameterCategoryDTO pcDto = new ParameterCategoryDTO("12A4D","Covid-19");
        ParameterDTO parameterDTO = new ParameterDTO("HB000","test","method", pcDto);
        parameterDTOS.add(parameterDTO);

        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(p);


        Assert.assertEquals(parameterDTOS,parameterMapper.toDto(parameterList));

    }

    @Test
    public void ToDto() {
        ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        ParameterCategoryDTO pcDto = new ParameterCategoryDTO("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);

        ParameterDTO parameterDTO = new ParameterDTO("HB000","test","method", pcDto);

        Assert.assertEquals(parameterDTO,parameterMapper.toDto(p));


    }

    @Test
    public void toDtoParameterCategoryDTo() {
        ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");

        ParameterCategoryDTO pcDto = new ParameterCategoryDTO("12A4D","Covid-19");

        Assert.assertEquals(pcDto,parameterMapper.toDtoParameterCategoryDTo(pc));
    }

    @Test
    public void toModellista() {
        ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);


        List<ParameterDTO> parameterDTOS = new ArrayList<>();
        ParameterCategoryDTO pcDto = new ParameterCategoryDTO("12A4D","Covid-19");
        ParameterDTO parameterDTO = new ParameterDTO("HB000","test","method", pcDto);
        parameterDTOS.add(parameterDTO);

        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(p);


        Assert.assertEquals(parameterList,parameterMapper.toModel(parameterDTOS));

    }

    @Test
    public void ToModel() {
        ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        ParameterCategoryDTO pcDto = new ParameterCategoryDTO("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);

        ParameterDTO parameterDTO = new ParameterDTO("HB000","test","method", pcDto);

        Assert.assertEquals(p,parameterMapper.toModel(parameterDTO));


    }

    @Test
    public void toModelParameterCategory() {
        ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");

        ParameterCategoryDTO pcDto = new ParameterCategoryDTO("12A4D","Covid-19");

        Assert.assertEquals(pc,parameterMapper.toModelParameterCategoryDTo(pcDto));
    }
}