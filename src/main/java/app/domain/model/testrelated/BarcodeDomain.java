package app.domain.model.testrelated;


/**
 * Represents a barcode that will be associated with a sample
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class BarcodeDomain {
    /**
     * Represents a barcode
     */
    private Object barcode;
    /**
     * Represents the number associated with a barcode
     */
    private String barcodeNumber;

    /**
     * Builds a barcode instance by receiving a barcode by parameter
     * @param barcode the barcode
     */
    public BarcodeDomain(Object barcode, String barcodeNumber){
        if (barcode==null) throw new IllegalArgumentException("Barcode can´t be blank");
        if (barcodeNumber==null) throw new IllegalArgumentException("Barcode number can´t be blank");
        this.barcode = barcode;
        this.barcodeNumber = barcodeNumber;
    }

    /**
     * Barcode Copy Builder
     * @param barcodeDomain the barcode that will be copy
     */
    public BarcodeDomain(BarcodeDomain barcodeDomain){
        this.barcode = barcodeDomain.getBarcode();
        this.barcode = barcodeDomain.getBarcodeNumber();
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
     * Compare the barcode with other object received
     * @param other Object we want to compare with the barcode
     * @return true if the received object represents another barcode equivalent to the barcode. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof BarcodeDomain)) return false;
        BarcodeDomain that = (BarcodeDomain) other;
        return barcode.equals(that.barcode) && barcodeNumber.equals(that.barcodeNumber);
    }

}
