package app.domain.model.testrelated;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class BarcodeDomainTest {
    String barcodeNumber = "00000000000";
    BarcodeDomain barcodeDomain;
    BarcodeDomain barcodeDomainAux;

    @Test(expected = IllegalArgumentException.class)
    public void barcodeNotNull(){
        barcodeDomain = new BarcodeDomain(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBarcodeNumberNotNull() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), null);
    }

    @Test
    public void getBarcode() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        barcodeDomainAux = barcodeDomain;
        Assert.assertEquals(barcodeDomain, barcodeDomainAux);
    }

    @Test
    public void getBarcodeNumber() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        String result = "00000000000";
        Assert.assertEquals(barcodeDomain.getBarcodeNumber(), result);
    }

    @Test
    public void testEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA(barcodeNumber), barcodeNumber);
        Assert.assertNotEquals(barcodeDomain, barcodeDomainAux);
    }

}