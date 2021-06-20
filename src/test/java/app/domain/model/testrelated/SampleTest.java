package app.domain.model.testrelated;

import app.domain.model.testrelated.BarcodeDomain;
import app.domain.model.testrelated.Sample;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;


public class SampleTest {



    @Test(expected = IllegalArgumentException.class)
    public void notNullSample(){
        BarcodeDomain barcodeDomain = new BarcodeDomain(null, null);
        Sample sample = new Sample(barcodeDomain);
    }

    @Test
    public void getBarcode() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        String result = "00000000000";
        Assert.assertEquals(result, sample.getBarcode().getBarcodeNumber());
    }

    @Test
    public void testBarcodeNumberEquals() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        Sample sampleAux = new Sample(barcodeDomain);
        Assert.assertEquals(sample.getBarcode().getBarcodeNumber(), sampleAux.getBarcode().getBarcodeNumber());
    }

    @Test
    public void testBarcodeEquals() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sampleAux = new Sample(barcodeDomainAux);
        Sample sample = new Sample(barcodeDomain);
        Assert.assertNotEquals(sampleAux.getBarcode(), sample.getBarcode());
    }
    @Test
    public void testBarcodeReferenceEquals() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = barcodeDomain;
        Sample sampleAux = new Sample(barcodeDomainAux);
        Sample sample = new Sample(barcodeDomain);
        Assert.assertEquals(barcodeDomain, barcodeDomainAux);
    }
    @Test
    public void testBarcodesNumberNotEquals() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000001"), "00000000001");
        Sample sampleAux = new Sample(barcodeDomainAux);
        Sample sample = new Sample(barcodeDomain);
        Assert.assertNotEquals(sampleAux.getBarcode().getBarcodeNumber(), sample.getBarcode().getBarcodeNumber());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSampleValidation() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = null;
        Sample sampleAux = new Sample(sample);

    }

    @Test
    public void testSampleEqualsReference() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        Sample sampleAux = sample;

        Assert.assertTrue(sample.equals(sampleAux));
    }

    @Test
    public void testSampleEqualsOtherClass() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        MedicalReport md = new MedicalReport("lallalalalla");

        Assert.assertFalse(sample.equals(md));
    }

    @Test
    public void testSampleEquals() throws BarcodeException {
        BarcodeDomain barcodeDomain = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        BarcodeDomain barcodeDomainAux = new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000");
        Sample sample = new Sample(barcodeDomain);
        Sample sampleAux = new Sample(sample);

        Assert.assertTrue(sample.equals(sampleAux));
    }


}