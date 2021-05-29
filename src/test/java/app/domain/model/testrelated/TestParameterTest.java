package app.domain.model.testrelated;

import app.domain.model.testrelated.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Ref;

import static org.junit.Assert.*;

public class TestParameterTest {

    @Test
    public void getParamResult() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        TestParameter tpm = new TestParameter(p);

        TestParameterResult tr2 = tpm.getParamResult();

        Assert.assertEquals(tr2, null);
    }

    @Test
    public void getParam() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        TestParameter tpm = new TestParameter(p);

        Parameter p2 = tpm.getParam();

        Assert.assertEquals(p,p2);
    }

    @Test
    public void addResult1() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        TestParameter tpm = new TestParameter(p);
        RefValue ref = new RefValue("metric1",30.0,50.0);

        boolean verificacao = tpm.AddResult(ref,"45","metric");

        Assert.assertTrue(verificacao);
    }

    @Test
    public void addResult2() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        TestParameter tpm = new TestParameter(p);
        RefValue ref = new RefValue("metric1",30.0,50.0);

        boolean verificacao = tpm.AddResult(null,null,null);

        Assert.assertFalse(verificacao);
    }

    @Test
    public void getParameterName() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        TestParameter tpm = new TestParameter(p);

        String la= "test";

        Assert.assertEquals(la,tpm.getParameterName());
    }

    @Test
    public void getParameterId() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        TestParameter tpm = new TestParameter(p);

        Assert.assertEquals("HB000",tpm.getParameterId());
    }

    @Test
    public void getParameterMetric() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        TestParameter tpm = new TestParameter(p,tr);

        Assert.assertEquals("metric",tpm.getParameterMetric());

    }

    @Test
    public void getParameterResult() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        TestParameter tpm = new TestParameter(p,tr);

        Assert.assertEquals("45",tpm.getParameterResult());
    }

    @Test
    public void getParameterMinRefValue() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        TestParameter tpm = new TestParameter(p,tr);

        Assert.assertEquals(30.0,tpm.getParameterMinRefValue(),0);
    }

    @Test
    public void getParameterMaxRefValue() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        TestParameter tpm = new TestParameter(p,tr);

        Assert.assertEquals(50.0,tpm.getParameterMaxRefValue(),0);
    }

    @Test
    public void getRefValueMetric() {
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        Parameter p = new Parameter("HB000","test","method", pc);
        RefValue ref = new RefValue("metric1",30.0,50.0);
        TestParameterResult tr = new TestParameterResult(ref,"45","metric");

        TestParameter tpm = new TestParameter(p,tr);




        Assert.assertEquals("metric1",tpm.getRefValueMetric());

    }
}