package app.adapter;

import app.domain.model.testrelated.BarcodeDomain;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeAdapterTest {

    @Test
    public void generateBarcode() throws BarcodeException {
        Barcode barcode = BarcodeFactory.createUPCA("00000000000");
        BarcodeDomain barcodeDomain = new BarcodeDomain(barcode, "00000000000");
        Assert.assertEquals(barcodeDomain.getBarcodeNumber(), "00000000000");
    }
}