package app.mappers.dto;


import app.domain.model.ParameterCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParameterCategoryDtoTest {

    ParameterCategoryDto pcDto;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDto("12345","test");
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
        ParameterCategoryDto pc1 = new ParameterCategoryDto("1f5dc", "Category");
        ParameterCategoryDto pc2 = new ParameterCategoryDto("1f5dc", "Category");
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoRefEquals(){
        ParameterCategoryDto pc1 = new ParameterCategoryDto("1f5ac", "Category");
        ParameterCategoryDto pc2 = pc1;
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoCodeEquals(){
        ParameterCategoryDto pc1 = new ParameterCategoryDto("1f5ac", "Category");
        ParameterCategoryDto pc2 = new ParameterCategoryDto("1f5ac", "Category test");
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNameEquals(){
        ParameterCategoryDto pc1 = new ParameterCategoryDto("1f5ac", "Category");
        ParameterCategoryDto pc2 = new ParameterCategoryDto("1f5ab", "Category");
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNotEqualsNull(){
        ParameterCategoryDto pc1 = new ParameterCategoryDto("1f5ac", "Category");
        ParameterCategoryDto pc2 = null;
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNotEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategoryDto pc2 = new ParameterCategoryDto("12345","test");
        Assert.assertNotEquals(pc1,pc2);
    }
}