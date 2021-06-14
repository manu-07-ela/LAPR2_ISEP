package app.domain.model.laboratories;

import app.domain.store.SampleList;

import java.io.Serializable;

/**
 * Represents a chemical laboratory
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class ChemicalLaboratory extends Laboratory implements Serializable {
    /**
     * Represents an instance of sample store
     */
    private final SampleList sampleList;
    /**
     * builds an instance of the chemical laboratory receiving the following attributes by parameter: name, address, cell phone and tin
     * @param name        the name of the Laboratory.
     * @param address     the address of the Laboratory.
     * @param phoneNumber the phone number of the Laboratory.
     * @param tin         the tin number of the Laboratory.
     */
    public ChemicalLaboratory(String name, String address, String phoneNumber, String tin) {
        super(name, address, phoneNumber, tin);
        this.sampleList = new SampleList();
    }

    /**
     * Get the instance o sample store
     * @return the sample store
     */
    public SampleList getSampleStore() {
        return sampleList;
    }
}
