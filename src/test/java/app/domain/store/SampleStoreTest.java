package app.domain.store;

import app.domain.model.testrelated.BarcodeDomain;
import app.domain.model.testrelated.Sample;
import app.domain.store.SampleStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SampleStoreTest {
    Sample sample;
    SampleStore sampleStore;

    @Test
    public void createSample() throws BarcodeException {
        sampleStore = new SampleStore();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        Sample result = sampleStore.createSample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        Assert.assertEquals(sample.getBarcode().getBarcodeNumber(), result.getBarcode().getBarcodeNumber());
    }

    @Test
    public void validateSampleNotNull() throws BarcodeException {
        sampleStore = new SampleStore();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        boolean result = sampleStore.validateSample(sample);
        Assert.assertTrue(result);
    }
    @Test
    public void validateSampleNull() {
        sampleStore = new SampleStore();
        sample = null;
        boolean result = sampleStore.validateSample(sample);
        Assert.assertFalse(result);

    }
    @Test
    public void validateSampleOfAListAlreadyContainsTheSample() throws BarcodeException {
        sampleStore = new SampleStore();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "0000000000"));
        sampleStore.addSample(sample);
        Sample sampleAux = sample;
        boolean result = sampleStore.validateSample(sampleAux);
        Assert.assertFalse(result);

    }

    @Test
    public void addValidSample() throws BarcodeException {
        sampleStore = new SampleStore();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        boolean result = sampleStore.addSample(sample);
        Assert.assertTrue(result);
    }


    @Test
    public void saveValidSample() throws BarcodeException {
        sampleStore = new SampleStore();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "00000000000"));
        boolean result = sampleStore.saveSample(sample);
        Assert.assertTrue(result);
    }
    @Test
    public void saveInvalidSample(){
        sampleStore = new SampleStore();
        sample = null;
        boolean result = sampleStore.saveSample(sample);
        Assert.assertFalse(result);

    }
    @Test
    public void saveTestAlreadyExistInSystem() throws BarcodeException {
        sampleStore = new SampleStore();
        sample = new Sample(new BarcodeDomain(BarcodeFactory.createUPCA("00000000000"), "0000000000"));
        sampleStore.saveSample(sample);
        Sample sampleAux = sample;
        boolean result = sampleStore.saveSample(sampleAux);
        Assert.assertFalse(result);

    }
    
}