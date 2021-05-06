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
    public void ensureCodeMeetsAC2_4() {
        ParameterCategory pc = new ParameterCategory("1f5dc", "Category");
        Assert.assertNotNull(pc);
    }

}