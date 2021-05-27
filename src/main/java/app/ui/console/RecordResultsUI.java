package app.ui.console;

import app.controller.RecordResultsController;
import app.domain.model.Parameter;
import app.mappers.dto.TestParameterDTO;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RecordResultsUI implements  Runnable {

    private RecordResultsController controller;

    public RecordResultsUI (){
        controller = new RecordResultsController();
    }

    @Override
    public void run() {

        if (controller.PossibilityOfRecordResult()){
            System.out.println("There are no tests available to record it's results");
        }else {
            System.out.println("\nRecording the Results");
            RecordResults();
        }
    }


    public  void RecordResults(){
        try {
            String barcode = Utils.readLineFromConsole("Enter the barcode number to record the results of the test");
            // List<TestParameterDTO> listaDeParametros = controller.getTestParameterList(barcode);
            List<TestParameterDTO> listaDeParametros = new ArrayList<>();
            TestParameterDTO tpm1= new TestParameterDTO("White Cell Count","HBOOO");
            listaDeParametros.add(tpm1);
            int i=0;
            while (i <= listaDeParametros.size()){
                Utils.showList(listaDeParametros,"Choose the Parameter you want to register the results");
                TestParameterDTO parameter = (TestParameterDTO) Utils.selectsObject(listaDeParametros);

                String result;
                String metric;
                String resposta;
                do {

                    System.out.println("\nEnter the result and the metric to record the results of the test");
                    result = Utils.readLineFromConsole("Result: ");
                    metric = Utils.readLineFromConsole("Metric: ");

                    System.out.println("Do you want to record results with theses results?");
                    System.out.printf("Result: %s\n",result);
                    System.out.printf("Metric: %s\n",metric);
                    resposta = Utils.readLineFromConsole("S/N:");

                }while (resposta.equalsIgnoreCase("S"));
                if (controller.addTestResult(parameter.getParameterId(),result,metric)){
                    listaDeParametros.remove(parameter);
                    i++;
                }

            }




        }catch (IllegalArgumentException e){
            System.out.printf("%n Message: %s%n",e.getMessage());
        }



    }
}





