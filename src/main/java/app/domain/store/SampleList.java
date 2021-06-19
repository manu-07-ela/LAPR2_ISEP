package app.domain.store;

import app.domain.model.testrelated.Sample;
import app.domain.model.testrelated.BarcodeDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * stores all samples recorded in the system
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class SampleList implements Serializable {
    private static final long serialVersionUID = -3284548447529458871L;
    /**
     * the list of existing samples in the system
     */
    private List<Sample> samples;

    /**
     * Instantiates a new SampleStore
     */
    public SampleList() {
        this.samples = new ArrayList<>();
    }

    /**
     * Create a new instance of Sample receiving a Barcode per parameter
     * @param barcode the barcode
     * @return a new instance of sample
     */
    public Sample createSample(BarcodeDomain barcode){
        return new Sample(barcode);
    }

    /**
     * Global validation of a Sample
     * @param sample Sample that we intend to validate
     * @return false if the sample already exists or is null. Otherwise, it returns true.
     */
    public boolean validateSample(Sample sample) {
        return sample != null && !this.samples.contains(sample);
    }

    /**
     * Adds a new sample to the List
     * @param sample Sample we want to add to the List
     * @return true if the sample is added to the List, false otherwise.
     */
    public boolean addSample(Sample sample) {
        return samples.add(sample);
    }

    /**
     * Save the sample case it is in a valid state
     * @param sample The sample we intend to save
     * @return true if the sample was saved. Otherwise, false.
     */
    public boolean saveSample(Sample sample) {
        if (!validateSample(sample))
            return false;
        return this.addSample(sample);
    }

    /**
     * Get the list of existing samples in the system
     * @return The list of samples
     */
    public List<Sample> getListOfSamples(){
        return samples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleList that = (SampleList) o;
        return Objects.equals(samples, that.samples);
    }

}
