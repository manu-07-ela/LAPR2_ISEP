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
     * @return an instance of the External module to be used by system
     * @throws ClassNotFoundException if the class I try to instantiate does not exist
     * @throws InstantiationException if the class instance is unsuccessful
     * @throws IllegalAccessException if I try to access a method of the class that I don't have permission
     */
    public ExternalModuleBarcode getExternalModule() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties props = new Properties();
        String classAux = props.getProperty("Controller.BarcodeAdapter.Class");
        Class<?> oClass = Class.forName(classAux);
        ExternalModuleBarcode api = (ExternalModuleBarcode) oClass.newInstance();
        return api;
    }

    /**
     * Generates the barcodes that will be associated with the samples in the future
     * @return the barcode
     * @throws ClassNotFoundException if the class I try to instantiate does not exist
     * @throws InstantiationException if the class instance is unsuccessful
     * @throws IllegalAccessException if I try to access a method of the class that I don't have permission
     * @throws IOException if an input or output error occurs
     * @throws BarcodeException if the barcode cannot be generated
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
     * Show the barcodes
     * @param barcode the barcode that will be shown
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
     * Associates a barcode with a sample
     * @param barcode the barcode that will be associated with the sample
     * @return the sample
     */
    public Sample associateBarcodeWithSample(BarcodeDomain barcode){
        return sampleStore.createSample(barcode);

    }

    /**
     * Associate a test with the samples
     * @param test the test we desired to associated with the sample
     * @param samples the sample we desired to associated with the test
     * @return true, if the association successful. False, otherwise.
     */
    public boolean associateSamplesWithTest(Test test, Sample samples){
        if (sampleStore.validateSample(samples)){
            test.addSamples(samples);
            return true;
        }
        return false;
    }

    /**
     * Generates the date and time when the samples were associated with a test
     * @param test the test that will be associated with the date and time of sample collection
     */
    public void generateDataAndTimeForSamplesCollected(Test test){
        test.generateDataAndTimeForSamplesCollected();
    }

    /**
     * After the samples are added to the test, it needs to change its status to SamplesCollected
     * @param test the test that needs to change state
     */
    public void changeTheStatusOfTest(Test test){
        test.changeStateForSamplesCollected();
    }


}
