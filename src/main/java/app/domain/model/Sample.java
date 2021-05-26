package app.domain.model;

import app.domain.model.attributes.Barcode;

import java.util.Objects;

/**
 * represents a sample that will be associated with a test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class Sample {
    /**
     * Represents the Barcode associated with a sample
     */
    private final Barcode barcode;

    /**
     * Builds a barcode instance by receiving a barcode by parameter
     * @param barcode the barcode that will be associated with a sample
     */
    public Sample(Barcode barcode) {
        this.barcode = barcode;
    }

    /**
     * Get the barcode associated with a sample
     * @return the barcode
     */
    public Barcode getBarcode() {
        return barcode;
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
