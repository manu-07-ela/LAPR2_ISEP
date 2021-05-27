package app.ui.console;

import app.controller.App;
import app.controller.RecordSampleController;
import app.domain.model.*;
import app.domain.model.attributes.BarcodeDomain;
import app.domain.model.attributes.NhsCode;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDTO;
import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an interface with the user to be able to record the sample associated with a test
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class RecordSampleUI implements Runnable{
    /**
     * Represents a instance of record sample controller
     */
    private RecordSampleController recordSampleController;

    /**
     * Initializes the controller
     */
    public RecordSampleUI() {
        this.recordSampleController = new RecordSampleController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {

        /*List<TestParameter> listaDeParametros = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
        List<ParameterCategory> listPC = new ArrayList();
        listPC.add(pc);
        Parameter p = new Parameter("HB000","test","method", pc);
        Parameter p2 = new Parameter("PLT00","test","method", pc);


        TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PTL00");
        List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
        listaDeParametrosDTO.add(temDto2);

        TestParameter tpm1 = new TestParameter(p);
        TestParameter tpm2 = new TestParameter(p2);
        listaDeParametros.add(tpm1);
        listaDeParametros.add(tpm2);
        Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
        TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3Adapter");
        NhsCode nhs = new NhsCode("123456789012");
        Test test = new Test(la,nhs,tt,listaDeParametros);
        TestDTO testDTO = new TestDTO(test);*/

        TestDTO testDTO = (TestDTO) Utils.showAndSelectOne(recordSampleController.getListOfTestsWaitingForSample(), "Select the desired test");
        int loop = askTheAmountOfSamples(testDTO);
        List<BarcodeDomain> barcodes = generateBarcodes(loop);
        boolean flag = Utils.confirm("Do you really intend to associate these barcodes with the samples? (S/N)");
        if (flag) associateBarcodesWithSamples(barcodes, testDTO);

    }

    /**
     * asks the user the number of samples to be associated with the selected test
     * @param testDTO serves to show the data related to the test selected by the user
     * @return the number of samples entered by the user
     */
    private int askTheAmountOfSamples(TestDTO testDTO){
        int samples;
        System.out.println("----------* Test Selected *----------");
        System.out.println(testDTO.toString());
       do {
           samples = Utils.readIntegerFromConsole("Enter the number of samples you want to associate with this test: ");
       }while (samples<=0);
        return samples;
    }

    /**
     * Generates the amount of barcode entered by the user
     * @param i the amount of samples entered by the user
     * @return a list of bar codes the same size as the number of samples entered by the user
     */
    private List<BarcodeDomain> generateBarcodes(int i){
        List<BarcodeDomain> barcodes = new ArrayList<>();
        for (int j=0; j<=i; j++){
            boolean invalidData = true;
            do {
                try {
                    BarcodeDomain barcodeDomain = recordSampleController.generateBarcode();
                    barcodes.add(barcodeDomain);
                    recordSampleController.showBarcodes(barcodeDomain);
                    invalidData = false;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BarcodeException e) {
                    e.printStackTrace();
                }
            }while (invalidData);

        }
        return barcodes;
    }

    /**
     * Associates the list of bar codes generated with the respective samples and the test selected by the user
     * @param barcodes the list of barcodes
     * @param testDTO the test that the samples will be associated
     */
    private void associateBarcodesWithSamples(List<BarcodeDomain> barcodes, TestDTO testDTO){
        Sample sample;
        Test test = recordSampleController.getTestByInternalCode(testDTO);

        for (BarcodeDomain b : barcodes){
            sample = recordSampleController.associateBarcodeWithSample(b);
            recordSampleController.associateSamplesWithTest(test, sample);
        }
        recordSampleController.generateDataAndTimeForSamplesCollected(test);
        recordSampleController.changeTheStatusOfTest(test);

    }

}
