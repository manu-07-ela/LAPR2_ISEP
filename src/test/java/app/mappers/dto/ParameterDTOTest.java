package app.mappers.dto;

import app.domain.model.testrelated.Parameter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterDTOTest {

    @Test
    public void getCode() {
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5dc", "Category");
        ParameterDTO p = new ParameterDTO ("HB000","test","method",pc1);

        Assert.assertEquals("HB000",p.getCode());
    }

    @Test
    public void getShortName() {
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5dc", "Category");
        ParameterDTO p = new ParameterDTO ("HB000","test","method",pc1);

        Assert.assertEquals("test",p.getShortName());
    }

    @Test
    public void getDescription() {
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5dc", "Category");
        ParameterDTO p = new ParameterDTO ("HB000","test","method",pc1);

        Assert.assertEquals("method",p.getDescription());
    }

    @Test
    public void getCategory() {
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5dc", "Category");
        ParameterDTO p = new ParameterDTO ("HB000","test","method",pc1);

        Assert.assertEquals(pc1,p.getCategory());
    }
}