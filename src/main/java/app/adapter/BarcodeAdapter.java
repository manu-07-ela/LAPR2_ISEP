package app.adapter;


import app.adapter.interfaces.ExternalModuleBarcode;
import app.domain.model.testrelated.BarcodeDomain;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

import java.io.Serializable;

/**
 * Represents a adapter for the external API
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class BarcodeAdapter implements ExternalModuleBarcode, Serializable {
    /**
     * Method responsible for generating the barcodes from the external api
     * @param barcodeNumber the number that will be associated with the barcode
     * @return an instance of barcode domain
     * @throws BarcodeException if the barcode is not generated
     */
    @Override
    public BarcodeDomain generateBarcode(String barcodeNumber) throws BarcodeException {
        Barcode barcode = BarcodeFactory.createUPCA(barcodeNumber);
        barcode.setPreferredBarHeight(150);
        return new BarcodeDomain(barcode, barcodeNumber);
    }
}
