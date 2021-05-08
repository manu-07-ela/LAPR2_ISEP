package app.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTypeStoreTest {

    TestType tt;
    ParameterCategory pc;
    List<ParameterCategory> listPC;
    TestTypeStore ttStore;

    @Before
    public void setup(){
        ttStore = new TestTypeStore();
        pc = new ParameterCategory("12A4D","Covid-19");
        listPC = new ArrayList();
        listPC.add(pc);
        tt = new TestType ("12345","test","collecting",listPC);
    }

    @Test
    public void createTestType(){
        TestType result = ttStore.createTestType("12345","test","collecting",listPC);
        assertEquals(tt, result);
    }

}