package app.ui.console.functionalities;


import app.mappers.dto.TestParameterDTO;
import app.controller.RecordResultsController;
import app.ui.console.utils.Utils;

import java.util.List;

public class RecordResultsUI implements  Runnable {

    /**
     * Represents a instance of record results controller.
     */
    private RecordResultsController controller;

    /**
     * Initializes the controller.
     */
    public RecordResultsUI (){
        controller = new RecordResultsController();
    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {

        if (controller.PossibilityOfRecordResult()){
            System.out.println("\nRecording the Results");
            RecordResults();
        }else {
            System.out.println("There are no tests available to record it's results");
        }
    }

    /**
     * It records the results of the tests
     */
    public  void RecordResults(){
        try {
            String barcode;
            boolean verificacao=true;
            List<TestParameterDTO> listaDeParametros = null;
            do {
                try {
                    barcode = Utils.readLineFromConsole("Enter the barcode number to record the results of the test");
                    listaDeParametros = controller.getTestParameterList(barcode);
                    verificacao=false;
                }catch (IllegalArgumentException e){
                    System.out.printf("%n Message: %s%n",e.getMessage());
                }
            }while (verificacao);

            int i=0;
            while (i <= listaDeParametros.size()){
                TestParameterDTO parameter;
                do {
                    System.out.println("Choose the Parameter you want to register the results");
                    int j=1;
                    for (TestParameterDTO parameterDTO: listaDeParametros) {
                        System.out.println(j+ "- "+ parameterDTO.toString2());
                        j++;
                    }
                    parameter = (TestParameterDTO) Utils.selectsObject(listaDeParametros);
                    if (parameter==null){
                        System.out.println("You must choose a parameter to record it's results");
                    }
                }while (parameter==null);
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

                }while (!resposta.equalsIgnoreCase("S"));

                if (controller.addTestResult(parameter.getParameterId(),result,metric)){
                    listaDeParametros.remove(parameter);
                    i++;
                }else {
                    throw new IllegalArgumentException("The Results were not added");
                }
            }
            System.out.println("The results were successful added");

        }catch (IllegalArgumentException e){
            System.out.printf("%n Message: %s%n",e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}





