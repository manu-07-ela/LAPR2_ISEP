package app.mappers.dto;

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
    private List<TestTypeDTO> listOfTestTypes;


    /**
     * Build an instance of ClinicalAnalysisLaboratoryDTO
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     * @param laboratoryId            Clinical Analysis Laboratory's ID
     * @param listOfTestTypes         List of Test Type that the Clinical Analysis Laboratory does
     */
    public ClinicalAnalysisLaboratoryDTO (String name, String address, String phoneNumber , String tin,String laboratoryId, List<TestTypeDTO> listOfTestTypes){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.tin=tin;
        this.laboratoryId=laboratoryId;
        this.listOfTestTypes=listOfTestTypes;
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
    public List<TestTypeDTO> getListOfTestTypes() {
        return listOfTestTypes;
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
