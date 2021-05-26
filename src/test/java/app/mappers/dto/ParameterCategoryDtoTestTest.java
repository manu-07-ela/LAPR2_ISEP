package app.mappers.dto;


import app.domain.model.ParameterCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParameterCategoryDtoTestTest {

    ParameterCategoryDtoTest pcDto;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDtoTest("12345","test");
    }

    @Test
    public void getCode() {
        String result = pcDto.getCode();
        Assert.assertEquals("12345",result);
    }

    @Test
    public void getName() {
        String result = pcDto.getName();
        Assert.assertEquals("test",result);
    }

    @Test
    public void parameterCategoriesDtoEquals(){
        ParameterCategoryDtoTest pc1 = new ParameterCategoryDtoTest("1f5dc", "Category");
        ParameterCategoryDtoTest pc2 = new ParameterCategoryDtoTest("1f5dc", "Category");
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoRefEquals(){
        ParameterCategoryDtoTest pc1 = new ParameterCategoryDtoTest("1f5ac", "Category");
        ParameterCategoryDtoTest pc2 = pc1;
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoCodeEquals(){
        ParameterCategoryDtoTest pc1 = new ParameterCategoryDtoTest("1f5ac", "Category");
        ParameterCategoryDtoTest pc2 = new ParameterCategoryDtoTest("1f5ac", "Category test");
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNameEquals(){
        ParameterCategoryDtoTest pc1 = new ParameterCategoryDtoTest("1f5ac", "Category");
        ParameterCategoryDtoTest pc2 = new ParameterCategoryDtoTest("1f5ab", "Category");
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNotEqualsNull(){
        ParameterCategoryDtoTest pc1 = new ParameterCategoryDtoTest("1f5ac", "Category");
        ParameterCategoryDtoTest pc2 = null;
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNotEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategoryDtoTest pc2 = new ParameterCategoryDtoTest("12345","test");
        Assert.assertNotEquals(pc1,pc2);
    }
}