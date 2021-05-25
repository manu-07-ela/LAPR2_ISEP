package app.domain.model.attributes;

import java.text.DecimalFormat;

/**
 * Represents a barcode that will be associated with a sample
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class Barcode {
    /**
     * Represents a barcode
     */
    private Object barcode;
    /**
     * Represents the number associated with a barcode
     */
    private String barcodeNumber;
    /**
     * Account of the instances of bar code
     */
    private static int instancesOfBarcodes;

    /**
     * Builds a barcode instance by receiving a barcode by parameter
     * @param barcode the barcode
     */
    public Barcode(Object barcode){
        DecimalFormat df  = new DecimalFormat("00000000000");
        this.barcode = barcode;
        barcodeNumber = df.format(instancesOfBarcodes);
        instancesOfBarcodes++;
    }

    /**
     * Get the barcode
     * @return the barcode
     */
    public Object getBarcode() {
        return barcode;
    }

    /**
     * Get the number associated with the barcode
     * @return the number of a barcode
     */
    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    /**
     * Get the total instances of barcode
     * @return the instances of barcode
     */
    public static int getInstancesOfBarcodes() {
        return instancesOfBarcodes;
    }
}
