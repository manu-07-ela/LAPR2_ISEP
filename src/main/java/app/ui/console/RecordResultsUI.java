package app.ui.console;

import app.controller.RecordResultsController;
import app.domain.model.Parameter;
import app.mappers.dto.TestParameterDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class RecordResultsUI implements  Runnable {

    private RecordResultsController controller;

    public RecordResultsUI (){
        controller = new RecordResultsController();
    }

    @Override
    public void run() {
        /*
        if (controller.PossibilityOfRecordResult()){
            System.out.println("There are no tests available to record it's results");
        }else {
            System.out.println("\nRecording the Results");
            RecordResults();
        }
        
         */
    }


    public  void RecordResults(){
        try {
            String barcode = Utils.readLineFromConsole("Enter the barcode number to record the results of the test");
           /* List<TestParameterDTO> listaDeParametros = controller.getTestParameterList(barcode);
            for (int i =0; i < listaDeParametros.size();i++){
                Utils.showList(listaDeParametros,"Choose the Parameter you want to register the results");
                TestParameterDTO parameter = (TestParameterDTO) Utils.selectsObject(listaDeParametros);

                System.out.println("\nEnter the result and the metric to record the results of the test");
                String result = Utils.readLineFromConsole("Result: ");
                String metric = Utils.readLineFromConsole("Metric: ");
                controller.addTestResult(parameter,result,metric);
                listaDeParametros.remove(parameter);
            }

            */
        }catch (IllegalArgumentException e){
            System.out.printf("%n Message: %s%n",e.getMessage());
        }



    }
}
