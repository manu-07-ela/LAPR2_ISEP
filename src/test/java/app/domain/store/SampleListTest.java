package app.domain.store;

import app.domain.model.testrelated.BarcodeDomain;
import app.domain.model.testrelated.Sample;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class SampleListTest {
    Sample sample;
    SampleList sampleList;

    @Test
    public void createSample() throws BarcodeException {
        sampleList = new SampleList();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        Sample result = sampleList.createSample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        Assert.assertEquals(sample.getBarcode().getBarcodeNumber(), result.getBarcode().getBarcodeNumber());
    }

    @Test
    public void validateSampleNotNull() throws BarcodeException {
        sampleList = new SampleList();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        boolean result = sampleList.validateSample(sample);
        Assert.assertTrue(result);
    }
    @Test
    public void validateSampleNull() {
        sampleList = new SampleList();
        sample = null;
        boolean result = sampleList.validateSample(sample);
        Assert.assertFalse(result);

    }
    @Test
    public void validateSampleOfAListAlreadyContainsTheSample() throws BarcodeException {
        sampleList = new SampleList();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "0000000000"));
        sampleList.addSample(sample);
        Sample sampleAux = sample;
        boolean result = sampleList.validateSample(sampleAux);
        Assert.assertFalse(result);

    }

    @Test
    public void addValidSample() throws BarcodeException {
        sampleList = new SampleList();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        boolean result = sampleList.addSample(sample);
        Assert.assertTrue(result);
    }


    @Test
    public void saveValidSample() throws BarcodeException {
        sampleList = new SampleList();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        boolean result = sampleList.saveSample(sample);
        Assert.assertTrue(result);
    }
    @Test
    public void saveInvalidSample(){
        sampleList = new SampleList();
        sample = null;
        boolean result = sampleList.saveSample(sample);
        Assert.assertFalse(result);

    }
    @Test
    public void saveTestAlreadyExistInSystem() throws BarcodeException {
        sampleList = new SampleList();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "0000000000"));
        sampleList.saveSample(sample);
        Sample sampleAux = sample;
        boolean result = sampleList.saveSample(sampleAux);
        Assert.assertFalse(result);

    }

}