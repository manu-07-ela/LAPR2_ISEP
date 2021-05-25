package app.ui.console;

import app.controller.WriteMedicalReportController;
import app.ui.console.utils.Utils;

/**
 * Represents an interface with the user to be able to write a new medical report.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class WriteMedicalReportUI implements Runnable{

    /**
     * Represents a instance of write medical report controller.
     */
    private WriteMedicalReportController writeMedicalReportctrl;

    /**
     *
     */
    public WriteMedicalReportUI(){
        writeMedicalReportctrl = new WriteMedicalReportController();

    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
        writeMedicalReport();
    }

    /**
     *
     */
    public void writeMedicalReport(){
        try {
            int testIndex = Utils.showAndSelectIndex(writeMedicalReportctrl.getTestHasSamplesAnalyzedList(),"Choose the test for which you want to make the diagnosis and write the report.");
            Utils.showList(writeMedicalReportctrl.getTestParameterList(writeMedicalReportctrl.getTestHasSamplesAnalyzedList().get(testIndex)),"The results of each analyzed parameter and the respective reference values.");
            System.out.printf("%nInsert the medical test report%n");
            String diagnosis = Utils.readLineFromConsole("");
            boolean confirm = Utils.confirm("Do you want to add this report to the test? (S/N)");
            if (confirm){
                writeMedicalReportctrl.addMedicalReport(diagnosis);
                System.out.println("The medical report was successfully associated with the test.");
            }
        } catch (IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }
    }

}
