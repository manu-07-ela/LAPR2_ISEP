package app.ui.console.functionalities;


import app.controller.RecordResultsController;


import app.mappers.dto.TestParameterDto;
import app.ui.console.utils.Utils;

import java.util.List;

public class RecordResultsUI implements  Runnable {

    private RecordResultsController controller;

    public RecordResultsUI (){
        controller = new RecordResultsController();
    }

    @Override
    public void run() {

        if (controller.PossibilityOfRecordResult()){
            System.out.println("\nRecording the Results");
            RecordResults();
        }else {
            System.out.println("There are no tests available to record it's results");
        }
    }


    public  void RecordResults(){
        try {
            String barcode;
            boolean verificacao=true;
            List<TestParameterDto> listaDeParametros = null;
            do {
                try {
                    barcode = Utils.readLineFromConsole("Enter the barcode number to record the results of the test");
                    listaDeParametros = controller.getTestParameterList(barcode);
                    verificacao=false;
                }catch (IllegalArgumentException e){
                    System.out.printf("%n Message: %s%n",e.getMessage());
                }
            }while (verificacao);
           // String barcode = Utils.readLineFromConsole("Enter the barcode number to record the results of the test");
           // List<TestParameterDto> listaDeParametros = controller.getTestParameterList(barcode);
           /* List<TestParameter> listaDeParametros = new ArrayList<>();
            ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
            List<ParameterCategory> listPC = new ArrayList();
            listPC.add(pc);
            Parameter p = new Parameter("HB000","test","method", pc);
            Parameter p2 = new Parameter("PLT00","test","method", pc);


            TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PLT00");
            List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
            listaDeParametrosDTO.add(temDto2);

            TestParameter tpm1 = new TestParameter(p);
            TestParameter tpm2 = new TestParameter(p2);
           // listaDeParametros.add(tpm1);
            listaDeParametros.add(tpm2);
            Client la = new Client("freferf","1234567890123456","1234567890","12/09/2001","female","1234567890","12345678901","erferfregergerergreg@gmail.com");
            TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
            NhsCode nhs = new NhsCode("123456789012");
            Test test = new Test(la,nhs,tt,listaDeParametros);
            int i=0;
            controller.setTest(test);

            */
            int i=0;
            while (i <= listaDeParametros.size()){
                TestParameterDto parameter;
                do {
                    Utils.showList(listaDeParametros, "Choose the Parameter you want to register the results");
                    parameter = (TestParameterDto) Utils.selectsObject(listaDeParametros);
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





