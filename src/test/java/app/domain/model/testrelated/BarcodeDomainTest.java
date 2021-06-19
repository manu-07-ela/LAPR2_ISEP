package app.domain.model.testrelated;

import app.domain.model.attributes.Address;
import app.domain.model.testrelated.BarcodeDomain;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class BarcodeDomainTest {


    @Test(expected = IllegalArgumentException.class)
    public void barcodeNotNull(){
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBarcodeNumberNotNull() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), null);
    }

    @Test
    public void getBarcode() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        BarcodeDomain barcodeDomainAux = barcodeDomain;
        Assert.assertEquals(barcodeDomain, barcodeDomainAux);
    }

    @Test
    public void getBarcodeNumber() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        String result = "00000000000";
        Assert.assertEquals(barcodeDomain.getBarcodeNumber(), result);
    }

    @Test
    public void testEquals() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        Assert.assertNotEquals(barcodeDomain, barcodeDomainAux);
    }

    @Test(expected = IllegalArgumentException.class)
    public void BarcodeDomainValidation() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(null);
    }

    @Test
    public void BarcodeDomainValidation2() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(barcodeDomain);
    }

    @Test
    public void BarcodeDomainEqualsOtherClass() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        Address name2 = new Address("Rua das cavalas");
        Assert.assertFalse(barcodeDomain.equals(name2));
    }

    @Test
    public void BarcodeDomainEquals() throws BarcodeException {
        String barcodeNumber = "00000000000";
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(barcodeDomain);
        Assert.assertTrue(barcodeDomain.equals(barcodeDomainAux));
    }



}