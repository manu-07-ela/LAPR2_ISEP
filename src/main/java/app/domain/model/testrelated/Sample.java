package app.domain.model.testrelated;

import java.io.Serializable;
import java.util.Objects;

/**
 * represents a sample that will be associated with a test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class Sample implements Serializable {
    /**
     * Represents the Barcode associated with a sample
     */
    private final BarcodeDomain barcodeDomain;

    /**
     * Builds a barcode instance by receiving a barcode by parameter
     * @param barcodeDomain the barcode that will be associated with a sample
     */
    public Sample(BarcodeDomain barcodeDomain) {
        if (barcodeDomain==null) throw new IllegalArgumentException("Barcode can't be blank");
        this.barcodeDomain = new BarcodeDomain(barcodeDomain.getBarcode(), barcodeDomain.getBarcodeNumber());
    }

    /**
     * Copy builder for a sample
     * @param sample the sample that will be copied
     */
    public Sample(Sample sample){
        if (sample==null) throw new IllegalArgumentException("Barcode can't be blank");
        this.barcodeDomain = new BarcodeDomain(sample.getBarcode());
    }

    /**
     * Get the barcode associated with a sample
     * @return the barcode
     */
    public BarcodeDomain getBarcode() {
        return barcodeDomain;
    }

    /**
     * Compare the sample of a test with other object received
     * @param other Object we want to compare with the sample
     * @return true if the received object represents another sample equivalent to the sample. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Sample)) return false;
        Sample sample = (Sample) other;
        return Objects.equals(this.getBarcode(), sample.getBarcode());
    }

}
