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
    public void validateSample() {
    }

    @Test
    public void addSample() {
    }

    @Test
    public void saveSample() {
    }

    @Test
    public void getListOfSamples() {
    }
}