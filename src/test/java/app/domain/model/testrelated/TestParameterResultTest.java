package app.domain.model.testrelated;

import app.domain.model.testrelated.RefValue;
import app.domain.model.testrelated.TestParameterResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TestParameterResultTest {

    @Test
    public void getMetric() {
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        Assert.assertEquals("metric",tr.getMetric());
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
       /* RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");
        Date chemicalAnalysisDate = Calendar.getInstance().getTime();

        Assert.assertEquals(chemicalAnalysisDate,tr.getChemicalAnalysisDate());

        */
    }
}