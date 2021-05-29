package app.domain.model.testrelated;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;


public class SampleTest {
    BarcodeDomain barcodeDomain;
    BarcodeDomain barcodeDomainAux;
    @Test
    public void getBarcode() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        String result = "00000000000";
        Assert.assertEquals(result, barcodeDomain.getBarcodeNumber());
    }

    @Test
    public void testBarcodeNumberEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Assert.assertEquals(barcodeDomain.getBarcodeNumber(), barcodeDomainAux.getBarcodeNumber());
    }
    @Test
    public void testBarcodeEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Assert.assertNotEquals(barcodeDomain, barcodeDomainAux);
    }
    @Test
    public void testBarcodeReferenceEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = barcodeDomain;
        Assert.assertEquals(barcodeDomain, barcodeDomainAux);
    }
    @Test
    public void testBarcodesNumberNotEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000001"), "00000000001");
        Assert.assertNotEquals(barcodeDomain.getBarcodeNumber(), barcodeDomainAux.getBarcodeNumber());

    }
}