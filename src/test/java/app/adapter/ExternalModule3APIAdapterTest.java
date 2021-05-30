package app.adapter;

import app.domain.model.testrelated.RefValue;
import com.example1.ExternalModule3API;
import com.example2.ExternalModule2API;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExternalModule3APIAdapterTest {

    @Test
    public void getRefValue() {
        ExternalModule3API externalAPI = new ExternalModule3API();
        String parameterId = "HB000";
        RefValue ref = new RefValue("g/L",130.0,180.0);

        ExternalModule3APIAdapter apiAdapter = new   ExternalModule3APIAdapter();
        Assert.assertEquals(ref,apiAdapter.getRefValue(parameterId));
    }
}