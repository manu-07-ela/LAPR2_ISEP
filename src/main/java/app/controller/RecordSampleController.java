package app.controller;

import app.adapter.interfaces.ExternalModuleBarcode;
import app.domain.model.Company;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.Sample;
import app.domain.model.testrelated.Test;
import app.domain.model.testrelated.BarcodeDomain;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.SampleStore;
import app.domain.store.TestStore;
import app.mappers.TestMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.TestDTO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private final TestStore testStore;
    /**
     * Represents a instance of sample store
     */
    private final SampleStore sampleStore;
    /**
     * Represents a instance of company
     */
    private final Company company;
    /**
     * Represents a instance of test mapper
     */
    private final TestMapper testMapper;
    /**
     * Counts the instances of barcodes
     */
    private static int instancesOfBarcode;


    /**
     * Constructs an instance of {@code RecordSampleController}
     */
    public RecordSampleController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.sampleStore = company.getChemicalLaboratory().getSampleStore();
        this.testMapper = new TestMapper();
    }

    /**
     * Returns a DTO-type list of test waiting for samples in the system
     * @return A DTO-type list of tests waiting for samples
     */
    public List<TestDTO> getListOfTestsWaitingForSample(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory){
        return testMapper.toDto(testStore.getListOfTestWaitingForSample(clinicalAnalysisLaboratory));
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
        Properties props = App.getInstance().getProps();
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
        instancesOfBarcode++;
        String barcodeNumber = df.format(instancesOfBarcode);
        ExternalModuleBarcode api = getExternalModule();
        return api.generateBarcode(barcodeNumber);
    }

    /**
     * Show the barcodes
     * @param barcode the barcode that will be shown
     */
    public void showBarcodes(BarcodeDomain barcode){
        JFrame frame = new JFrame("Barcode");
        frame.getContentPane().add((Component) barcode.getBarcode());
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
     * Method responsible for writing the barcodes in a folder
     * @param image the barcode that will be saved
     * @param fileName the name of the file associated with the barcode
     */
    public void imageIoWrite(BufferedImage image, String fileName) {
        try {
            String pwd = System.getProperty("user.dir");

            File barcodes = new File(pwd + "\\src\\main\\barcodes");
            if (!barcodes.exists()) {
                barcodes.mkdirs();
            }
            File outputFile = new File(pwd + "\\src\\main\\barcodes\\"+fileName+".jpeg");

            ImageIO.write(image, "jpeg", outputFile);
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("The image was successfully saved to the \"barcodes\" folder.");
    }

    /**
     * Transforms a BarcodeDomain in a BufferedImage
     * @param barcode the BarcodeDomain that will be converted
     * @return the bufferedImage
     * @throws OutputException if the conversion is not successful
     */
    public BufferedImage barcodeImage(BarcodeDomain barcode) throws OutputException {
        return BarcodeImageHandler.getImage((Barcode) barcode.getBarcode());
    }

    /**
     * Save the sample
     * @param sample the sample we intend to save
     * @return true if the sample was saved, false otherwise
     */
    public boolean saveSample(Sample sample){
        return sampleStore.saveSample(sample);
    }

    /**
     * Get the list of existing laboratories in the system
     * @return the list of laboratories
     */
    public List<ClinicalAnalysisLaboratory> getListOfLaboratories(){
        return company.getClinicalAnalysisLaboratoryStore().getClinicalAnalysisLaboratoryList();
    }

}
