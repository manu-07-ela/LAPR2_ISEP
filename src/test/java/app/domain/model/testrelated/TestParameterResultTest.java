package app.domain.model.testrelated;

import app.domain.model.testrelated.RefValue;
import app.domain.model.testrelated.TestParameterResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TestParameterResultTest {

    @Test (expected = IllegalArgumentException.class)
    public void  resultValidation1() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref," ","metric");

    }


    @Test (expected = IllegalArgumentException.class)
    public void  metricValidation1() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","     ");

    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,null,null);
    }


    @Test
    public void getMetric() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        Assert.assertEquals("metric",tr.getMetric());
    }

    @Test(expected = IllegalArgumentException.class )
    public void getMetric2() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","     ");

    }

    @Test
    public void getResult() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        Assert.assertEquals("45",tr.getResult());
    }

    @Test
    public void getRefValue() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        Assert.assertEquals(ref,tr.getRefValue());
    }

}