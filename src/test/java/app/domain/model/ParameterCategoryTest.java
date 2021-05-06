package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed() {
        ParameterCategory pc = new ParameterCategory(null, null);
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
    public void equalParameterCategories(){
        ParameterCategory pc1 = new ParameterCategory("1f5dc", "CategoryPa");
        ParameterCategory pc2 = new ParameterCategory("1f5dc", "Category");
        Assert.assertEquals(pc1,pc2);
    }



}