package app.domain.model;

import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratory  {

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
    private String phoneNumber;

    /**
     * Clinical Analysis Laboratory's tax identification number
     */
    private String tin;

    /**
     * Clinical Analysis Laboratory's ID
     */
    private String laboratoryId;

    /**
     * List of Test Type that the Clinical Analysis Laboratory does
     */
    private List<TestType> listOfTestTypes;


    /**
     * Build an instance of Clinical Analysis Laboratory
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     * @param laboratoryId            Clinical Analysis Laboratory's ID
     * @param listOfTestTypes         List of Test Type that the Clinical Analysis Laboratory does
     */
    public ClinicalAnalysisLaboratory(String name, String address, String phoneNumber , String tin, String laboratoryId, List<TestType> listOfTestTypes){
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
        this.listOfTestTypes= listOfTestTypes;
    }

    /**
     * Get the laboratoryId of the Clinical Analysis Laboratory
     * @return Clinical Analysis Laboratory's ID
     */
    public String getLaboratoryId() {
        return laboratoryId;
    }
    /**
     *  Get the list of Test Types of the Clinical Analysis Laboratory
     * @return List of Test Type that the Clinical Analysis Laboratory
     */
    public List<TestType> getListOfTestTypes() {
        return listOfTestTypes;
    }

    /**
     * Get the name of the Clinical Analysis Laboratory
     * @return  Clinical Analysis Laboratory's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the address of the Clinical Analysis Laboratory
     * @return Clinical Analysis Laboratory's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the Phone Number of the Clinical Analysis Laboratory
     * @return Clinical Analysis Laboratory's Phone Number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Get the tax identification number of the Clinical Analysis Laboratory
     * @return Clinical Analysis Laboratory's tax identification number
     */
    public String getTin() {
        return tin;
    }
    /**
     * Checks whether the name contains all business rules
     * @param name   Clinical Analysis Laboratory's name
     */
    private void nameValidation(String name){
        if (StringUtils.isBlank(name) || name.length()>20){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters and cannot be blank");
        }

    }

    /**
     * Checks whether the address contains all business rules
     * @param address     Clinical Analysis Laboratory's address
     */
    private void AddressValidation(String address){
        if (StringUtils.isBlank(address) || address.length()>30 ){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters and cannot be blank");
        }
    }

    /**
     * Checks whether the Phone Number contains all business rules
     * @param phoneNumber Clinical Analysis Laboratory's phone number
     */
    private void phoneNumberValidation(String phoneNumber){
        if (StringUtils.isBlank(phoneNumber) || phoneNumber.length()!=11){
            throw  new IllegalArgumentException("Phone number is a number with 11 digits");
        }
    }

    /**
     * Checks whether the tax identification number contains all business rules
     * @param tin Clinical Analysis Laboratory's tax identification number
     */
    private void tinValidation(String tin){
        if (StringUtils.isBlank(tin) || tin.length()!=10){
            throw  new IllegalArgumentException("Tin is a number with 10 digits");
        }
    }

    /**
     * Checks whether the LaboratoryId contains all business rule
     * @param laboratoryId Clinical Analysis Laboratory's ID
     */
    private void laboratoryIdValidation(String laboratoryId){
        if (StringUtils.isBlank(laboratoryId) || !StringUtils.isAlphanumeric(laboratoryId) || laboratoryId.length() != 5 ) {
            throw new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
        }
    }

    /**
     * Compare an Object with other.
     * @param o An Object we want to compare
     * @return True if the object contains one atribute equal to one of the atributes of the other except the name and the list of Test Types . Otherwise, it return false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClinicalAnalysisLaboratory that = (ClinicalAnalysisLaboratory) o;
        return this.getAddress().equals((that).getAddress()) || this.getLaboratoryId().equals((that).getLaboratoryId()) || this.getTin().equals((that).getTin()) || this.getPhoneNumber().equals((that).getPhoneNumber());
    }

    /**
     * Textual description of the Laboratory
     * @return Information about the Laboratory
     */
    @Override
    public String toString() {
        return "ClinicalAnalysisLaboratory{" +
                "laboratoryId='" + laboratoryId + '\'' +
                ", listOfTestTypes=" + listOfTestTypes +
                '}';
    }
}
