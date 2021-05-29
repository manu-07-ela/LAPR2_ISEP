package app;

import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.mappers.dto.ParameterDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterMapperTest {

    @Test
    public void toDtolista() {
       /* ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);


        List<ParameterDTO> parameterDTOS = new ArrayList<>();
        ParameterDTO parameterDTO = new ParameterDTO("HB000","test","method", pc);
        parameterDTOS.add(parameterDTO);

        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(p);


        Assert.assertEquals(parameterDTOS,parameterMapper.toDto(parameterList));

        */
    }

    @Test
    public void ToDto() {
        /*ParameterMapper parameterMapper = new ParameterMapper();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);

        ParameterDTO parameterDTO = new ParameterDTO("HB000","test","method", pc);

        Assert.assertEquals(parameterDTO,parameterMapper.toDto(p));

         */
    }
}