package app.domain.model.laboratories;

import app.domain.model.laboratories.ChemicalLaboratory;
import app.domain.store.SampleStore;
import org.junit.Assert;
import org.junit.Test;


public class ChemicalLaboratoryTest {

    @Test
    public void getSampleStore() {
        ChemicalLaboratory chemicalLab = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");
        SampleStore result = chemicalLab.getSampleStore();
        Assert.assertNotEquals(result, new SampleStore());
    }
}