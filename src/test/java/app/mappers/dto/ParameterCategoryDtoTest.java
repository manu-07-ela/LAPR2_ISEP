package app.mappers.dto;


import app.domain.model.testRelated.ParameterCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParameterCategoryDtoTest {

    ParameterCategoryDTO pcDto;

    @Before
    public void setup(){
        pcDto=new ParameterCategoryDTO("12345","test");
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
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5dc", "Category");
        ParameterCategoryDTO pc2 = new ParameterCategoryDTO("1f5dc", "Category");
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoRefEquals(){
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5ac", "Category");
        ParameterCategoryDTO pc2 = pc1;
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoCodeEquals(){
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5ac", "Category");
        ParameterCategoryDTO pc2 = new ParameterCategoryDTO("1f5ac", "Category test");
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNameEquals(){
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5ac", "Category");
        ParameterCategoryDTO pc2 = new ParameterCategoryDTO("1f5ab", "Category");
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNotEqualsNull(){
        ParameterCategoryDTO pc1 = new ParameterCategoryDTO("1f5ac", "Category");
        ParameterCategoryDTO pc2 = null;
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesDtoNotEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategoryDTO pc2 = new ParameterCategoryDTO("12345","test");
        Assert.assertNotEquals(pc1,pc2);
    }
}