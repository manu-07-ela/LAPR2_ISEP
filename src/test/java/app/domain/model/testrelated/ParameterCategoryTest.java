
package app.domain.model.testrelated;

import org.junit.Assert;
import org.junit.Test;

public class ParameterCategoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed() {
        ParameterCategory pc = new ParameterCategory(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBlankNameIsNotAllowed() {
        ParameterCategory pc = new ParameterCategory("12345", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC2_1() {
        ParameterCategory pc = new ParameterCategory("10d5th", "Category");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC2_2() {
        ParameterCategory pc = new ParameterCategory("10d", "Category");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC2_3() {
        ParameterCategory pc = new ParameterCategory("10d.6", "Category");
    }

    @Test
    public void ensureCodeAndNameMeetsAC() {
        ParameterCategory pc = new ParameterCategory("1f5dc", "CategoryPa");
        Assert.assertNotNull(pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameMeetsAC1_1() {
        ParameterCategory pc = new ParameterCategory("aB3d5", "Parameter Category");
    }

    @Test
    public void parameterCategoriesCodesEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5dc", "CategoryPa");
        ParameterCategory pc2 = new ParameterCategory("1f5dc", "Category");
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesNamesEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategory pc2 = new ParameterCategory("1f5dc", "Category");
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategory pc2 = new ParameterCategory("1f5ac", "Category");
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesRefEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategory pc2 = pc1;
        Assert.assertEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesNotEqualsNull(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategory pc2 = null;
        Assert.assertNotEquals(pc1,pc2);
    }

    @Test
    public void parameterCategoriesNotEqualsClass(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        Parameter p1 = new Parameter("12345","test","test",pc1);
        Assert.assertNotEquals(pc1,p1);
    }

    @Test
    public void parameterCategoriesNotEquals(){
        ParameterCategory pc1 = new ParameterCategory("1f5ac", "Category");
        ParameterCategory pc2 = new ParameterCategory("1f5dc", "Test");
        Assert.assertNotEquals(pc1,pc2);
    }



}

