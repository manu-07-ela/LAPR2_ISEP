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
     *
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
     *
     * @param calDTO
     */
    public ClinicalAnalysisLaboratory(ClinicalAnalysisLaboratoryDTO calDTO) {
        nameValidation(calDTO.getName());
        AddressValidation(calDTO.getAddress());
        phoneNumberValidation(calDTO.getPhoneNumber());
        tinValidation(calDTO.getTin());
        laboratoryIdValidation(calDTO.getLaboratoryId());
        this.name=calDTO.getName();
        this.address=calDTO.getAddress();
        this.phoneNumber=calDTO.getPhoneNumber();
        this.tin=calDTO.getTin();
        this.laboratoryId= calDTO.getLaboratoryId();
        this.listOfTestTypes= new ArrayList((Collection) calDTO.getListOfTestTypes());
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
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTin() {
        return tin;
    }

    /**
     *
     * @param name   Clinical Analysis Laboratory's name
     */
    private void nameValidation(String name){
        if (StringUtils.isBlank(name)){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters");
        }else if(name.length()>20){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters");
        }

    }

    /**
     *
     * @param address     Clinical Analysis Laboratory's address
     */
    private void AddressValidation(String address){
        if (StringUtils.isBlank(address)){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters");
        }else if (address.length()>30){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters");
        }
    }

    /**
     *
     * @param phoneNumber
     */
    private void phoneNumberValidation(String phoneNumber){
        if (StringUtils.isBlank(phoneNumber)){
            throw  new IllegalArgumentException("Phone number has to have 11 digits");
        }else if (phoneNumber.length()!=11){
            throw  new IllegalArgumentException("Phone number has to have 11 digits");
        }
    }

    /**
     *
     * @param tin
     */
    private void tinValidation(String tin){
        if (StringUtils.isBlank(tin)){
            throw  new IllegalArgumentException("Tin has to have 10 digits");
        }else if (tin.length()!=10){
            throw  new IllegalArgumentException("Tin has to have 10 digits");
        }
    }

    /**
     *
     * @param laboratoryId Clinical Analysis Laboratory's ID
     */
    private void laboratoryIdValidation(String laboratoryId){
        if (StringUtils.isBlank(laboratoryId))
            throw  new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
        if ( !StringUtils.isAlphanumeric(laboratoryId) || laboratoryId.length() != 5 )
            throw  new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClinicalAnalysisLaboratory that = (ClinicalAnalysisLaboratory) o;
        return this.getAddress().equals((that).getAddress()) || this.getLaboratoryId().equals((that).getLaboratoryId()) || this.getTin().equals((that).getTin()) || this.getPhoneNumber().equals((that).getPhoneNumber());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ClinicalAnalysisLaboratory{" +
                "laboratoryId='" + laboratoryId + '\'' +
                ", listOfTestTypes=" + listOfTestTypes +
                '}';
    }
}
