package app.controller;

import app.adapter.ExternalModuleBarcode;
import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.model.attributes.BarcodeDomain;
import app.domain.store.SampleStore;
import app.domain.store.TestStore;
import app.mappers.TestMapper;
import app.mappers.dto.TestDTO;
import net.sourceforge.barbecue.BarcodeException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

/**
 * Represents the controller used to record samples in a test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class RecordSampleController {
    /**
     * Represents a instance of test store
     */
    private TestStore testStore;
    /**
     * Represents a instance of sample store
     */
    private SampleStore sampleStore;
    /**
     * Represents a instance of company
     */
    private Company company;
    /**
     * Represents a instance of test mapper
     */
    private TestMapper testMapper;

    /**
     * Constructs an instance of {@code RecordSampleController}
     */
    public RecordSampleController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.sampleStore = company.getSampleStore();
        this.testMapper = new TestMapper();
    }

    /**
     * Returns a DTO-type list of test waiting for samples in the system
     * @return A DTO-type list of tests waiting for samples
     */
    public List<TestDTO> getListOfTestsWaitingForSample(){
        return testMapper.toDto(testStore.getListOfTestWaitingForSample());
    }

    /**
     * Get a test by its internal code
     * @param testDto a test dto which the internal code will be taken to compare with the tests stored in the TestStore
     * @return the test corresponding to the desired internal code
     */
    public Test getTestByInternalCode(TestDTO testDto){
        return testStore.getTestByInternalCode(testDto.getInternalCode());
    }

    /**
     * Builds an instance of the API that will be used to generate the bar codes.
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ExternalModuleBarcode getExternalModule() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties props = new Properties();
        String classAux = props.getProperty("Controller.BarcodeAdapter.Class");
        Class<?> oClass = Class.forName(classAux);
        ExternalModuleBarcode api = (ExternalModuleBarcode) oClass.newInstance();
        return api;
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     * @throws BarcodeException
     */
    public BarcodeDomain generateBarcode() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, BarcodeException {
        DecimalFormat df = new DecimalFormat("00000000000");
        int instancesOfBarcode = 0;
        String barcodeNumber = df.format(instancesOfBarcode);
        ExternalModuleBarcode api = getExternalModule();
        instancesOfBarcode++;
        return api.getBarcode(df.format(barcodeNumber));
    }

    /**
     *
     * @param barcode
     */
    public void showBarcodes(BarcodeDomain barcode){

        JFrame frame = new JFrame();
        frame.getContentPane().add((Component) barcode.getBarcode());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setLocation(500, 500);
        frame.setVisible(true);

    }

    /**
     *
     * @param barcode
     * @return
     */
    public Sample associateBarcodeWithSample(BarcodeDomain barcode){
        return sampleStore.createSample(barcode);

    }

    /**
     *
     * @param test
     * @param samples
     * @return
     */
    public boolean associateSamplesWithTest(Test test, Sample samples){
        if (sampleStore.validateSample(samples)){
            test.addSamples(samples);
            return true;
        }
        return false;
    }


}
