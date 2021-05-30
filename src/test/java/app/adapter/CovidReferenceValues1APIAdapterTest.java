package app.adapter;

import app.domain.model.testrelated.RefValue;
import com.example3.CovidReferenceValues1API;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CovidReferenceValues1APIAdapterTest {

    @Test
    public void getRefValue() {
        CovidReferenceValues1API covidAPI = new CovidReferenceValues1API();
        String parameterId = "HB000";
        RefValue ref = new RefValue("-1.0",-1.0,-1.0);


        CovidReferenceValues1APIAdapter apiAdapter = new CovidReferenceValues1APIAdapter();
        Assert.assertEquals(ref,apiAdapter.getRefValue(parameterId));
    }
}