package app.adapter;

import app.domain.model.attributes.Barcode;

import java.io.IOException;

/**
 * interface that will be implemented by the external module adapter responsible for generating the bar codes
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public interface ExternalModuleBarcode {
    /**
     * Method that will generate and return the barcode that will be associated with a sample
     * @return A barcode
     */
    Barcode getBarcode() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
