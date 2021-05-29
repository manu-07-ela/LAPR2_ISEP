package app.domain.store;

import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.store.ParameterStore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ParameterStoreTest {

    ParameterCategory pc;
    List<ParameterCategory> listPC;
    Parameter p;
    ParameterStore pStore;
    List<Parameter> listParameter;

    @Before
    public void setup(){
        pStore = new ParameterStore();
        pc = new ParameterCategory("ABC10","BloodCount");
        listPC = new ArrayList();
        listPC.add(pc);
        p = new Parameter ("TT030","rbc","Red Blood Cells",pc);
        listParameter = new ArrayList();
    }

    @Test
    public void saveValidParameter() {
        boolean result = pStore.saveParameter(p);
        Assert.assertTrue(result);
    }
    @Test
    public void saveInvalidParameter() {
        pStore.addParameter(p);
        boolean result = pStore.saveParameter(p);
        Assert.assertFalse(result);
    }
    @Test
    public void saveNullParameter() {
        Parameter param = null;
        boolean result = pStore.saveParameter(param);
        Assert.assertFalse(result);
    }

    @Test
    public void validateValidParameter() {
        boolean result = pStore.validateParameter(p);
        Assert.assertTrue(result);
    }
    @Test
    public void validateInvalidTestType(){
        pStore.addParameter(p);
        boolean result =pStore.validateParameter(p);
        Assert.assertFalse(result);
    }
    @Test
    public void validateNullTestType(){
        Parameter test = null;
        boolean result = pStore.validateParameter(test);
        Assert.assertFalse(result);
    }

    @Test
    public void createParameter() {
        Parameter result = pStore.createParameter("TT030","rbc","Red Blood Cells",pc);
        Assert.assertEquals(p, result);
    }

    @Test
    public void getParameterList() {
        listParameter.add(p);
        pStore.addParameter(p);
        List<Parameter> result = pStore.getParameterList();
        Assert.assertEquals(listParameter,result);
    }

    @Test
    public void getNonexistentParameterByCode(){
        Parameter result=pStore.getParameterByCode("12345");
        Assert.assertEquals(null,result);
    }
}
