package app.domain.model;

import java.util.List;

public class ClinicalAnalysisLaboratory {
    /**
     * Clinical Analysis Laboratory's name
     */
    private String name;

    /**
     * Clinical Analysis Laboratory's address
     */
    private String address;

    /**
     * Clinical Analysis Laboratory's phone number
     */
    private float phoneNumber;

    /**
     * Clinical Analysis Laboratory's tax indentification number
     */
    private float tin;

    /**
     * Clinical Analysis Laboratory's ID
     */
    private String laboratoryId;

    /**
     * List of Test Type that the Clinical Analysis Laboratory does
     */
    private List<TestType> listOfTestTypes;

    /**
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @param tin
     * @param laboratoryId
     * @param listOfTestTypes
     */
    public ClinicalAnalysisLaboratory(String name, String address, int phoneNumber , int tin, String laboratoryId,List<TestType> listOfTestTypes){
        nameValidation(name);
        AddressValidation(address);
        phoneNumberValidation(phoneNumber);
        tinValidation(tin);
        laboratoryIdValidation(laboratoryId);
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.tin=tin;
        this.laboratoryId=laboratoryId;
        this.listOfTestTypes=listOfTestTypes;
    }

    /**
     *
     * @param name
     */
    private void nameValidation(String name){
        if (name.length()>20){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters");
        }

    }

    /**
     *
     * @param address
     */
    private void AddressValidation(String address){
        if (address.length()>30){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters");
        }
    }

    /**
     *
     * @param phoneNumber
     */
    private void phoneNumberValidation(float phoneNumber){
        if (phoneNumber<10000000000f || phoneNumber>=99999999999f){
            throw  new IllegalArgumentException("Phone number has to have 11 digits");
        }
    }

    /**
     *
     * @param tin
     */
    private void tinValidation(int tin){
        if (tin<1000000000 ||tin > 9999999999f){
            throw  new IllegalArgumentException("Tin has to have 10 digits");
        }
    }

    /**
     *
     * @param laboratoryId
     */
    private void laboratoryIdValidation(String laboratoryId){
        if (laboratoryId.length()>5){
            throw  new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
        }
    }

    public ClinicalAnalysisLaboratory create (String name, String address, int phoneNumber , int tin, String laboratoryId,List<TestType> listOfTestTypes){
        return new ClinicalAnalysisLaboratory(name,address,phoneNumber,tin,laboratoryId,listOfTestTypes);
    }



}
