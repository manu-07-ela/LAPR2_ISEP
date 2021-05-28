package app.ui.console.functionalities;



import app.mappers.dto.TestDTO;

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
     * Initializes the Write Medical Report Interface and the controller.
     */
    public WriteMedicalReportUI(){
        writeMedicalReportctrl = new WriteMedicalReportController();

    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
        try {
            boolean flag;
            do {
                TestDTO selectedTest = (TestDTO) Utils.showAndSelectOne(writeMedicalReportctrl.getTestHasSamplesAnalyzedList(), "Select the desired test.");
                Utils.showList(writeMedicalReportctrl.getTestParameterList(selectedTest), "The results of each analyzed parameter and the respective reference values.");
                askTheMedicalReport();
                if (writeMedicalReportctrl.getTestHasSamplesAnalyzedList().size() > 0){
                    flag = Utils.confirm("Do you want to write any more medical report? (S/N)");
                } else {
                    flag = false;
                }
            }while (flag);
        } catch (IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n" ,e.getMessage());
        }

    }

    /**
     * Asks the user for the medical report to be associated with the selected test.
     */
    public void askTheMedicalReport(){
        boolean result = false;
        boolean invalidData = true;
        do {
            System.out.printf("%nInsert the medical test report%n");
            String diagnosis = Utils.readLineFromConsole("");
            boolean flag = Utils.confirm("Do you really intend to associate these report with the test? (S/N)");
            if (flag) {
                try {
                    result = writeMedicalReportctrl.addMedicalReport(diagnosis);
                }catch (IllegalArgumentException e){
                    System.out.printf("%nMessage: %s%n" ,e.getMessage());
                }
                invalidData = false;
            }
        }while (invalidData);
        if(result){
            System.out.println("The medical report was successfully associated with the test.");
        } else {
            System.out.println("It was not possible to add the medical report to the test.");
        }
    }

}
