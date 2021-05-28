package app.ui.console.functionalities;

import app.controller.CreateClinicalAnalysisLaboratoryController;
import app.mappers.CreateClinicalAnalysisLaboratoryMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import app.mappers.dto.TestTypeDTO;
import app.ui.console.utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CreateClinicalAnalysisLaboratoryUI implements Runnable {
    /**
     *
     */
    private CreateClinicalAnalysisLaboratoryController clinicalcontroller;

    /**
     *
     */
    public CreateClinicalAnalysisLaboratoryUI(){
        clinicalcontroller = new CreateClinicalAnalysisLaboratoryController();
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.printf("%nCreating a new Clinical Analysis Laboratory%n");
        CreateClinicalAnalysisLaboratory();
    }

    public void CreateClinicalAnalysisLaboratory(){


        boolean dadosInvalidos=true;

        do{
            try {
                System.out.printf("%nEnter the following data about Clinical Analysis Laboratory you want to create%n");
                String name = Utils.readLineFromConsole("Name: ");
                String address = Utils.readLineFromConsole("address: ");
                String phoneNumber = Utils.readLineFromConsole("phoneNumber: ");
                String tin = Utils.readLineFromConsole("Tin : ");
                String laboratoryId =Utils.readLineFromConsole("LaboratoryId : ");

                Utils.showList(clinicalcontroller.getTestTypeList(),"Choose what kind of Test Type should the Clinical Analysis Laboratory be able to perform");



                List<TestTypeDTO> lista = new ArrayList<>();
                String resposta;

                do {
                    Object option = Utils.selectsObject(clinicalcontroller.getTestTypeList());
                    if (option == null){
                        throw  new IllegalArgumentException("The Test Type list mustn't be empty");
                    }
                    TestTypeDTO testDTO = (TestTypeDTO) option;
                    lista.add(testDTO);
                    System.out.println("Do you want to choose other TestTypes?");
                    resposta = Utils.readLineFromConsole("S/N:");

                }while (resposta.equalsIgnoreCase("S"));

                    ClinicalAnalysisLaboratoryDTO calDto = new ClinicalAnalysisLaboratoryDTO(name,address,phoneNumber,tin,laboratoryId,lista);
                    boolean result = clinicalcontroller.CreateClinicalAnalysisLaboratory(calDto);
                    dadosInvalidos=false;

                    if (result){
                        System.out.printf("Do you really want to create a Clinical Analysis Laboratory with the name: %s ,address: %s, phone number: %s , Tin : %s , LaboratoryId: %s and with the list of Test Types you selected?",name, address,phoneNumber,tin,laboratoryId);
                        String confirmaçao = Utils.readLineFromConsole("S/N:");

                        if(confirmaçao.equalsIgnoreCase("S")){
                            if(clinicalcontroller.saveClinicalAnalysisLaboratory()){
                                System.out.println("The Clinical Analysis Laboratory was created successfully");
                            }else {
                                System.out.println("There is already an equivalent Clinical Analysis Laboratory in the system");
                                System.out.println("The Clinical Analysis Laboratory has not been saved.");
                            }
                        }
                    }else {
                        System.out.println("There is already an equivalent specification of Clinical Analysis Laboratory (example : equal address) in the system");
                        System.out.println("The Clinical Analysis Laboratory has not been created.");

                    }
            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n" ,e.getMessage());
            }
        } while (dadosInvalidos);

    }
}
