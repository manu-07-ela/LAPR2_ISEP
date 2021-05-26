package app.domain.store;

import app.domain.model.Sample;
import app.domain.model.attributes.BarcodeDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * stores all samples recorded in the system
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class SampleStore {
    /**
     * the list of existing samples in the system
     */
    private List<Sample> samples;

    /**
     * Instantiates a new SampleStore
     */
    public SampleStore() {
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
}
