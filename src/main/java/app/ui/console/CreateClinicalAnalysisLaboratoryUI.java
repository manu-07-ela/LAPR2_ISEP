package app.ui.console;

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
                System.out.printf("%nEnter the following data aboutClinical Analysis Laboratory you want to create%n");
                String name = Utils.readLineFromConsole("Name: ");
                String address = Utils.readLineFromConsole("address: ");
                String phoneNumber = Utils.readLineFromConsole("phoneNumber: ");
                String tin = Utils.readLineFromConsole("Tin : ");
                String laboratoryId =Utils.readLineFromConsole("LaboratoryId : ");

                Utils.showList(clinicalcontroller.getTestTypeList(),"Choose what kind of Test Type should the Clinical Analysis Laboratory be able to perform");



                List<TestTypeDTO> lista = new ArrayList<>();
                String resposta;

                do {
                    TestTypeDTO testDTO = (TestTypeDTO) Utils.selectsObject(clinicalcontroller.getTestTypeList());
                    lista.add(testDTO);
                    System.out.println("Do you want to choose other TestTypes?");
                    resposta = Utils.readLineFromConsole("S/N:");

                }while (resposta.equalsIgnoreCase("S"));
                ClinicalAnalysisLaboratoryDTO calDto = new ClinicalAnalysisLaboratoryDTO(name,address,phoneNumber,tin,laboratoryId,lista);
                clinicalcontroller.CreateClinicalAnalysisLaboratory(calDto);
                dadosInvalidos=false;

                System.out.printf("Do you really want to create a Clinical Analysis Laboratory with the name: %s ,address: %s, phone number: %s , Tin : %s , LaboratoryId: %s and with the list of Test Types you selected?",name, address,phoneNumber,tin,laboratoryId);
                String confirmaçao = Utils.readLineFromConsole("S/N:");

                if(confirmaçao.equalsIgnoreCase("S")){
                    if(clinicalcontroller.saveClinicalAnalysisLaboratory()){
                        System.out.println("The Clinical Analysis Laboratory was created successfully");
                    }
                }

            } catch (IllegalArgumentException e){
                System.out.printf("%nMessage: %s%n" ,e.getMessage());
            }
        } while (dadosInvalidos);

    }
}
