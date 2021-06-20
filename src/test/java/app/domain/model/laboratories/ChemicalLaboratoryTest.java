package app.domain.model.laboratories;

import app.domain.model.attributes.Address;
import app.domain.store.SampleList;
import org.junit.Assert;
import org.junit.Test;


public class ChemicalLaboratoryTest {

    @Test
    public void LabEquals() {
        ChemicalLaboratory chemicalLab = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");
        ChemicalLaboratory chemicalLab2 = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");

        Assert.assertTrue(chemicalLab.equals(chemicalLab2));
    }

    @Test
    public void LabEqualsReference() {
        ChemicalLaboratory chemicalLab = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");
        ChemicalLaboratory chemicalLab2 = chemicalLab;

        Assert.assertTrue(chemicalLab.equals(chemicalLab2));
    }

    @Test
    public void LabEqualsNull() {
        ChemicalLaboratory chemicalLab = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");
        ChemicalLaboratory chemicalLab2 = null;

        Assert.assertFalse(chemicalLab.equals(chemicalLab2));
    }

    @Test
    public void LabEqualsOtherClass() {
        ChemicalLaboratory chemicalLab = new ChemicalLaboratory("Chemical Laboratory", "Oxford Street", "23145623781", "7293817263");
        Address name2 = new Address("Rua das cavalas");

        Assert.assertFalse(chemicalLab.equals(name2));
    }

}