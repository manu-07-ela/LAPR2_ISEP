package app.ui.console;

import app.controller.RecordSampleController;
import app.domain.model.Test;
import app.mappers.dto.TestDTO;
import app.ui.console.utils.Utils;

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
        Test test = recordSampleController.getTestByInternalCode(testDTO);


    }
    private void askTheAmountOfSamples(TestDTO testDTO){
        System.out.println("----------* Test Selected *----------");
        System.out.println(testDTO.toString());
    }
}
