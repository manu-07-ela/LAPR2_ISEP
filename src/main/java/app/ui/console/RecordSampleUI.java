package app.ui.console;

import app.controller.RecordSampleController;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.model.attributes.BarcodeDomain;
import app.mappers.dto.TestDTO;
import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;

import java.io.IOException;

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
     *
     */
    @Override
    public void run() {
        TestDTO testDTO = (TestDTO) Utils.showAndSelectOne(recordSampleController.getListOfTestsWaitingForSample(), "Select the desired test");
        int loop = askTheAmountOfSamples(testDTO);
        generateBarcodes(loop);

    }
    private int askTheAmountOfSamples(TestDTO testDTO){
        System.out.println("----------* Test Selected *----------");
        System.out.println(testDTO.toString());
        return Utils.readIntegerFromConsole("Enter the number of samples you want to associate with this test: ");
    }

    private void generateBarcodes(int i){
        for (int j=0; j<=i; j++){
            try {
                BarcodeDomain barcodeDomain = recordSampleController.generateBarcode();
                recordSampleController.showBarcodes(barcodeDomain);
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
        }
    }



}
