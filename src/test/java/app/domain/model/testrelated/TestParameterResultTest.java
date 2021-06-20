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
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        tr.resultValidation("   ");
    }

    @Test
    public void  resultValidation2() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        tr.resultValidation("34");
    }


    @Test (expected = IllegalArgumentException.class)
    public void  metricValidation1() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        tr.metricValidation("      ");

    }

    @Test
    public void  metricValidation2() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        tr.metricValidation("mg");

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

    @Test
    public void getChemicalAnalysisDate() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        Date chemicalDate = new Date("17/05/2021  10:07:00");
        TestParameterResult tr = new TestParameterResult(ref,"45","metric",chemicalDate);

        Assert.assertEquals(chemicalDate,tr.getChemicalAnalysisDate());
    }

}