package app.ui.console.functionalities;

import app.controller.RegisterTestController;
import app.domain.model.attributes.NhsCode;
import app.domain.model.users.Client;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
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
     * Create of National Healthcare Service code
     * @return the National Healthcare Service code
     */
    private NhsCode nhscode(){
            boolean invalidData = true;
            NhsCode nhscAux = null;
            do{
                try {
                    String nhsc = Utils.readLineFromConsole("National Healthcare Service code: ");
                    nhscAux = new NhsCode(nhsc);
                    invalidData = false;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }while (invalidData);
            return nhscAux;
    }

    /**
     * Shows the client
     * @param cl the client
     */
    private void showClient(Client cl){
        System.out.println("Name:" + cl.getName());
        System.out.println("Citizen card number: " + cl.getCitizenCardNumber());
        System.out.println("National Healthcare Service number: " + cl.getNhs());
        System.out.println("Birth Date: " + cl.getDate());
        System.out.println("Gender: " + cl.getSex());
        System.out.println("Tax identification number: " + cl.getTin());
        System.out.println("Phone number: " + cl.getPhoneNumber());
        System.out.println("Email: " + cl.getEmail());
    }

    /**
     * Creates a list of ParameterDTO that are incerted in a certain ParameterCategoryDTO
     * @param par A parameter category DTO
     * @param listpam A list of Parameters DTO
     * @return
     */
    private List<ParameterDTO> createParameterList(ParameterCategoryDTO par, List<ParameterDTO> listpam){
        for (ParameterDTO param : registerTestctrl.getParameterList()) {
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
                List<ParameterDTO> listpam = new ArrayList<>();
                List<ParameterDTO> listpm = new ArrayList<>();
                List<ParameterCategoryDTO> listpmc = new ArrayList<>();
                listpmc = registerTestctrl.getParameterCategoryList();
                Client cl;
                String resposta;
                boolean confirmation;
                Object option;
                ClinicalAnalysisLaboratoryDTO lab = (ClinicalAnalysisLaboratoryDTO) Utils.showAndSelectOne(registerTestctrl.getLaboratoryList(),"Please choose in which laboratory you are currently working");
                if (lab == null) {
                    throw new IllegalArgumentException("The Laboratory list mustn't be empty");
                }
                System.out.printf("%nType the Tax identification number of the user you want to register a Test on%n");

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
                } while(!resposta.equalsIgnoreCase("S"));
                NhsCode nhscode = nhscode();
                    //TEST TYPE
                    option = Utils.showAndSelectOne(registerTestctrl.getTestTypeList(), "Choose what kind of Test Type should be registered");

                    if (option == null) {
                        throw new IllegalArgumentException("The Test Type list mustn't be empty");
                    }
                    TestTypeDTO tt = (TestTypeDTO) option;

                    //Parameter Category
                    do {
                        option = Utils.showAndSelectOne(listpmc, "Choose what kind of Parameter Categories should be associated with the test");
                        if (option == null) {
                            throw new IllegalArgumentException("The Parameter Category list mustn't be empty");
                        }
                        ParameterCategoryDTO par = (ParameterCategoryDTO) option;
                        listpam=createParameterList(par,listpam);
                        listpmc.remove(par);
                        //Parameter
                        do {
                            option = Utils.showAndSelectOne(listpam, "Choose what kind of Parameters should be associated with the test");
                            if (option == null) {
                                throw new IllegalArgumentException("The Parameter list mustn't be empty");
                            }
                            ParameterDTO pm = (ParameterDTO) option;
                            listpm.add(pm);
                            listpam.remove(pm);
                            confirmation = false;
                            if(listpam.size()>0) {
                                System.out.printf("%nDo you want to select another Parameter?%n");
                                confirmation = Utils.confirm("S/N:");
                            }
                        } while (confirmation);
                        confirmation = false;
                        if(listpmc.size()>0) {
                            System.out.printf("%nDo you want to select another Parameter Category?%n");
                            confirmation = Utils.confirm("S/N:");
                        }
                    } while (confirmation);
                    registerTestctrl.createTest(cl,nhscode,tt,listpm,lab);
                    System.out.printf("Do you want to register the test?");
                    resposta = Utils.readLineFromConsole("S/N:");
                    if (resposta.equalsIgnoreCase("S")) {
                        if (registerTestctrl.saveTest()) {
                            System.out.printf("%nThe test was registered successfully%n");
                        }else{
                            System.out.printf("%nThat test was already registered%n");
                        }
                    }
            }catch(IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n", e.getMessage());
            }
    }
}

