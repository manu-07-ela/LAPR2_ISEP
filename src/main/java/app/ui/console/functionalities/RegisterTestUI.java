package app.ui.console.functionalities;

import app.controller.RegisterTestController;
import app.domain.model.attributes.NhsCode;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestParameter;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
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

    /**
     * Create of National Healthcare Service code
     * @return the National Healthcare Service code
     */
    private NhsCode nhscode(String nhsc){
        boolean invalidData = true;
        NhsCode nhscAux = null;
        do{
            try {
                nhscAux = new NhsCode(nhsc);
                invalidData = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (invalidData);
        return nhscAux;
    }

    private void showClient(Client cl){
        System.out.println("Name:" + cl.getName());
        System.out.println("Citizen card number: " + cl.getCitizencardnumber());
        System.out.println("National Healthcare Service number: " + cl.getNhs());
        System.out.println("Birth Date: " + cl.getDate());
        System.out.println("Gender: " + cl.getSex());
        System.out.println("Tax identification number: " + cl.getTin());
        System.out.println("Phone number: " + cl.getPhonenumber());
        System.out.println("Email: " + cl.getEmail());
    }
    private List<Parameter> createParameterList(ParameterCategory par, List<Parameter> listpam){
        for (Parameter param : registerTestctrl.getParameterList()) {
            if (param.getCategory().equals(par)) {
                listpam.add(param);
            }
        }
        return listpam;
    }

    /**
     * Create an instance of Test
     */
    public void createTest() {
            try {
                System.out.printf("%nType the Tax identification number of the user you want to register a Test on%n");
                Client cl;
                List<TestParameter> listpm = new ArrayList<>();
                List<Parameter> listpam = new ArrayList<>();
                String resposta;
                boolean confirmation;
                do {
                    String tin = Utils.readLineFromConsole("Tax identification number: ");
                    cl= registerTestctrl.getClient(tin);
                    if (cl == null){
                        throw new IllegalArgumentException("That Tax identification number isnt registered in the system.");
                    }
                    System.out.println();
                    System.out.println("Is this the client that you want to register a test on?");
                    showClient(cl);
                    resposta = Utils.readLineFromConsole("S/N:");
                } while(resposta.equalsIgnoreCase("N"));
                String nhsc = Utils.readLineFromConsole("National Healthcare Service code: ");
                System.out.printf("Do you want to register a test with the National Healthcare Service code %s ?",nhsc);
                resposta = Utils.readLineFromConsole("S/N:");
                NhsCode nhscode = nhscode(nhsc);
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
                        ParameterCategory par = (ParameterCategory) option;
                        listpam=createParameterList(par,listpam);
                        registerTestctrl.getParameterCategoryList().remove(option);
                        //Parameter

                        do {
                            Utils.showList(listpam, "Choose what kind of Parameters should be associated with the test");
                            option = Utils.selectsObject(listpam);
                            listpam.remove(option);
                            if (option == null) {
                                throw new IllegalArgumentException("The Parameter list mustn't be empty");
                            }
                            Parameter pm = (Parameter) option;
                            TestParameter tpm = new TestParameter(pm);
                            listpm.add(tpm);
                            confirmation = false;
                            if(listpam.size()>0) {
                                System.out.printf("%nDo you want to select another Parameter?%n");
                                confirmation = Utils.confirm("S/N:");
                            }
                        } while (confirmation);
                        confirmation = false;
                        if(registerTestctrl.getParameterCategoryList().size()>0) {
                            System.out.printf("%nDo you want to select another Parameter Category?%n");
                            confirmation = Utils.confirm("S/N:");
                        }
                    } while (confirmation);
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
    }
}

