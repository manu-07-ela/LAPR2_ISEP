package app.domain.model.testrelated;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;


public class SampleTest {
    Sample sample;
    Sample sampleAux;
    BarcodeDomain barcodeDomain;
    BarcodeDomain barcodeDomainAux;

    @Test(expected = IllegalArgumentException.class)
    public void notNullSample(){
        barcodeDomain = new BarcodeDomain(null, null);
        sample = new Sample(barcodeDomain);
    }
    @Test
    public void getBarcode() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        sample = new Sample(barcodeDomain);
        String result = "00000000000";
        Assert.assertEquals(result, sample.getBarcode().getBarcodeNumber());
    }

    @Test
    public void testBarcodeNumberEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        sample = new Sample(barcodeDomain);
        sampleAux = new Sample(barcodeDomain);
        Assert.assertEquals(sample.getBarcode().getBarcodeNumber(), sampleAux.getBarcode().getBarcodeNumber());
    }
    @Test
    public void testBarcodeEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        sampleAux = new Sample(barcodeDomainAux);
        sample = new Sample(barcodeDomain);
        Assert.assertNotEquals(sampleAux.getBarcode(), sample.getBarcode());
    }
    @Test
    public void testBarcodeReferenceEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = barcodeDomain;
        sampleAux = new Sample(barcodeDomainAux);
        sample = new Sample(barcodeDomain);
        Assert.assertEquals(barcodeDomain, barcodeDomainAux);
    }
    @Test
    public void testBarcodesNumberNotEquals() throws BarcodeException {
        barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000001"), "00000000001");
        sampleAux = new Sample(barcodeDomainAux);
        sample = new Sample(barcodeDomain);
        Assert.assertNotEquals(sampleAux.getBarcode().getBarcodeNumber(), sample.getBarcode().getBarcodeNumber());

    }
}