package app.adapter;


import app.domain.model.attributes.BarcodeDomain;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

public class BarcodeAdapter implements ExternalModuleBarcode {

    @Override
    public BarcodeDomain generateBarcode(String barcodeNumber) throws BarcodeException {
       Barcode barcode = BarcodeFactory.createUPCA(barcodeNumber);
        barcode.setPreferredBarHeight(150);
       return new BarcodeDomain(barcode, barcodeNumber);
    }
}
