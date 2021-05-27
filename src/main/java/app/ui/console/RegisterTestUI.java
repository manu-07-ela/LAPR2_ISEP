package app.ui.console;

import app.controller.RegisterTestController;
import app.domain.model.*;
import app.domain.model.attributes.NhsCode;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RegisterTestUI implements Runnable{

    /**
     * Represents a instance of register test controller
     */
    private final RegisterTestController registerTestctrl;

    /**
     * Initializes the controller
     */
    public RegisterTestUI(){
        registerTestctrl = new RegisterTestController();
    }

    /**
     * Invokes the necessary methods for the interface to function
     */
    @Override
    public void run() {
        System.out.printf("%nRegistering a Test to be performed%n");
        createTest();
    }

    private NhsCode nhscode(){
        boolean invalidData = true;
        NhsCode nhscAux = null;
        do{
            try {
                String nhsc = Utils.readLineFromConsole("National Healthcare Service code: ");
                nhscAux = new NhsCode(nhsc);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return nhscAux;
    }

    /**
     * Create an instance of client
     */
    public void createTest() {
        boolean dadosInvalidos=true;
        do {
            try {
                System.out.printf("%nType the Tax identification number of the user you want to register a Test on%n");
                Client cl;
                List<TestParameter> listpm = new ArrayList<>();
                String resposta;
                do {
                    String tin = Utils.readLineFromConsole("Tax identification number: ");
                    cl= registerTestctrl.getClient(tin);
                    if (cl == null){
                        throw new IllegalArgumentException("That Tax identification number isnt registered in the system.");
                    }
                    System.out.println();
                    System.out.println("Is this the client that you want to register a test on?");
                    System.out.println("Name:" + cl.getName());
                    System.out.println("Citizen card number: " + cl.getCitizencardnumber());
                    System.out.println("National Healthcare Service number: " + cl.getNhs());
                    System.out.println("Birth Date: " + cl.getDate());
                    System.out.println("Gender: " + cl.getSex());
                    System.out.println("Tax identification number: " + cl.getTin());
                    System.out.println("Phone number: " + cl.getPhonenumber());
                    System.out.println("Email: " + cl.getEmail());
                    resposta = Utils.readLineFromConsole("S/N:");
                } while(resposta.equalsIgnoreCase("S"));
                NhsCode nhscode = nhscode();
                System.out.printf("Do you want to register a test with the National Healthcare Service code %s ?",nhscode);
                resposta = Utils.readLineFromConsole("S/N:");
                if (resposta.equalsIgnoreCase("S")) {

                    //TEST TYPE
                    Utils.showList(registerTestctrl.getTestTypeList(), "Choose what kind of Test Type should be registered");

                    Object option = Utils.selectsObject(registerTestctrl.getTestTypeList());
                    if (option == null) {
                        throw new IllegalArgumentException("The Test Type list mustn't be empty");
                    }
                    TestType tt = (TestType) option;

                    //Parameter Category
                    do {
                        Utils.showList(registerTestctrl.getParameterCategoryList(), "Choose what kind of Parameter Categories should be associated with the test");

                        option = Utils.selectsObject(registerTestctrl.getParameterCategoryList());
                        if (option == null) {
                            throw new IllegalArgumentException("The Parameter Category list mustn't be empty");
                        }
                        registerTestctrl.getParameterCategoryList().remove(option);
                        //Parameter

                        do {
                            Utils.showList(registerTestctrl.getParameterList(), "Choose what kind of Parameters should be associated with the test");

                            option = Utils.selectsObject(registerTestctrl.getParameterList());
                            registerTestctrl.getParameterList().remove(option);
                            if (option == null) {
                                throw new IllegalArgumentException("The Parameter list mustn't be empty");
                            }
                            Parameter pm = (Parameter) option;
                            TestParameter tpm = new TestParameter(pm);
                            listpm.add(tpm);
                            System.out.println("Do you want to choose another Parameter?");
                            resposta = Utils.readLineFromConsole("S/N:");
                        } while (resposta.equalsIgnoreCase("S"));
                        System.out.println("Do you want to choose another Parameter Category?");
                        resposta = Utils.readLineFromConsole("S/N:");
                    } while (resposta.equalsIgnoreCase("S"));

                    registerTestctrl.createTest(cl,nhscode,tt,listpm);
                    System.out.printf("Do you want to register the test?");
                    resposta = Utils.readLineFromConsole("S/N:");
                    if (resposta.equalsIgnoreCase("S")) {
                        if (registerTestctrl.saveTest()) {
                            System.out.printf("%nThe test was registered successfully%n");
                        }
                    }
                }
            }catch(IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n", e.getMessage());
            }
        }while (dadosInvalidos);
    }

}

