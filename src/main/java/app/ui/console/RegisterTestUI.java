package app.ui.console;

import app.controller.RegisterTestController;
import app.domain.model.Client;
import app.domain.store.ClientStore;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestTypeDTO;
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
     * Create an instance of client
     */
    public void createTest() {
        boolean dadosInvalidos=true;
        do {
            try {
                    System.out.printf("%nType the citizen card number of the user you want to register a Test on%n");
                    String citizencardnumber = Utils.readLineFromConsole("Citizen card number: ");
                    Client cl = registerTestctrl.getClient(citizencardnumber);
                    do {
                        if (cl == null) {
                            System.out.printf("%nThat number isnt registered in the system%n");
                            citizencardnumber = Utils.readLineFromConsole("Citizen card number: ");
                            cl = registerTestctrl.getClient(citizencardnumber);
                        }
                    } while (cl == null);
                    String nhscode = Utils.readLineFromConsole("National Healthcare Service code: ");
                    registerTestctrl.createTest(cl, nhscode);
                    dadosInvalidos = false;
                    System.out.printf("Do you want to register a test with the citizen card number %s and National Healthcare Service code %s", citizencardnumber, nhscode);
                    String resposta = Utils.readLineFromConsole("S/N:");
                    if (resposta.equalsIgnoreCase("S")) {

                        //TEST TYPE
                        Utils.showList(registerTestctrl.getTestTypeList(), "Choose what kind of Test Type should be registered");

                        List<TestTypeDTO> listatt = new ArrayList<>();

                        Object option = Utils.selectsObject(registerTestctrl.getTestTypeList());
                        if (option == null) {
                            throw new IllegalArgumentException("The Test Type list mustn't be empty");
                        }
                        TestTypeDTO ttDTO = (TestTypeDTO) option;
                        listatt.add(ttDTO);

                        //Parameter Category
                        do {
                            Utils.showList(registerTestctrl.getParameterCategoryList(), "Choose what kind of Parameter Categories should be associated with the test");

                            List<ParameterCategoryDTO> listapmc = new ArrayList<>();

                            option = Utils.selectsObject(registerTestctrl.getParameterCategoryList());
                            if (option == null) {
                                throw new IllegalArgumentException("The Parameter Category list mustn't be empty");
                            }
                            ParameterCategoryDTO pmcDTO = (ParameterCategoryDTO) option;
                            listapmc.add(pmcDTO);
                            //Parameter
                            List<ParameterDTO> listapm = new ArrayList<>();
                            do {
                                Utils.showList(registerTestctrl.getParameterList(), "Choose what kind of Parameters should be associated with the test");

                                option = Utils.selectsObject(registerTestctrl.getParameterList());
                                if (option == null) {
                                    throw new IllegalArgumentException("The Parameter list mustn't be empty");
                                }
                                ParameterDTO pmDTO = (ParameterDTO) option;
                                listapm.add(pmDTO);
                                System.out.println("Do you want to choose another Parameter?");
                                resposta = Utils.readLineFromConsole("S/N:");
                            }while(resposta.equalsIgnoreCase("S"));
                            System.out.println("Do you want to choose another Parameter Categorie?");
                            resposta = Utils.readLineFromConsole("S/N:");
                        }while(resposta.equalsIgnoreCase("S"));
                    }
                }catch(IllegalArgumentException e){
                    System.out.printf("%nMessage: %s%n", e.getMessage());
                }
        }while (dadosInvalidos);
    }

}
