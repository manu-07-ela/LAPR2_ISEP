package app.domain.model.testrelated;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Ref;

import static org.junit.Assert.*;

public class RefValueTest {

    @Test
    public void testEquals() {
        RefValue refValue = new RefValue("mg",20.0,40.0);
        RefValue refValue2 = new RefValue("mg",20.0,40.0);

        Assert.assertTrue(refValue.equals(refValue2));
    }

    @Test
    public void testEqualsReference() {
        RefValue refValue = new RefValue("mg",20.0,40.0);
        RefValue refValue2 = refValue;

        Assert.assertTrue(refValue.equals(refValue2));
    }

    @Test
    public void testEqualsNull() {
        RefValue refValue = new RefValue("mg",20.0,40.0);
        RefValue refValue2 = null;

        Assert.assertFalse(refValue.equals(refValue2));
    }

    @Test
    public void testEqualsOtherClass() {
        RefValue refValue = new RefValue("mg",20.0,40.0);
        MedicalReport md = new MedicalReport("lallalalalla");

        Assert.assertFalse(refValue.equals(md));
    }

}