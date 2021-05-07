package app.mappers.dto;

import app.domain.model.TestType;

import java.util.List;

public class ClinicalAnalysisLaboratoryDTO {
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
     * Clinical Analysis Laboratory's tax identification number
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
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     */
    public ClinicalAnalysisLaboratoryDTO (String name, String address, float phoneNumber , float tin){
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
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }
    /**
     *
     * @return
     */
    public float getPhoneNumber() {
        return phoneNumber;
    }
    /**
     *
     * @return
     */
    public float getTin() {
        return tin;
    }
    /**
     *
     * @return
     */
    public String getLaboratoryId() {
        return laboratoryId;
    }
    /**
     *
     * @return
     */
    public List<TestType> getListOfTestTypes() {
        return listOfTestTypes;
    }
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(float phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     *
     * @param tin
     */
    public void setTin(float tin) {
        this.tin = tin;
    }
    /**
     *
     * @param laboratoryId
     */
    public void setLaboratoryId(String laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    /**
     *
     * @param name   Clinical Analysis Laboratory's name
     */
    private void nameValidation(String name){
        if (name.length()>20){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters");
        }

    }

    /**
     *
     * @param address     Clinical Analysis Laboratory's address
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
        String la = ""+phoneNumber;
        if (la.length()!=11){
            throw  new IllegalArgumentException("Phone number has to have 11 digits");
        }
    }

    /**
     *
     * @param tin
     */
    private void tinValidation(float tin){
        String la = ""+tin;
        if (la.length()!=10){
            throw  new IllegalArgumentException("Tin has to have 10 digits");
        }
    }

    /**
     *
     * @param laboratoryId Clinical Analysis Laboratory's ID
     */
    private void laboratoryIdValidation(String laboratoryId){
        if (laboratoryId.length()>5){
            throw  new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
        }
    }
}
