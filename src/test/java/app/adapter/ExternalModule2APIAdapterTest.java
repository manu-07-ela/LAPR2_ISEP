package app.adapter;

import app.domain.model.testrelated.RefValue;
import com.example2.ExternalModule2API;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExternalModule2APIAdapterTest {

    @Test
    public void getRefValue() {
        ExternalModule2API externalAPI = new ExternalModule2API();
        String parameterId = "HB000";
        RefValue ref = new RefValue("g/L",130.0,180.0);

        ExternalModule2APIAdapter apiAdapter = new   ExternalModule2APIAdapter();
        Assert.assertEquals(ref,apiAdapter.getRefValue(parameterId));

    }
}