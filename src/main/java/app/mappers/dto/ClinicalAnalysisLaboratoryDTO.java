package app.mappers.dto;

import app.domain.model.TestType;
import org.apache.commons.lang3.StringUtils;

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
     *
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     *
     * @return
     */
    public String getTin() {
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
    public List<TestTypeDTO> getListOfTestTypes() {
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
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     *
     * @param tin
     */
    public void setTin(String tin) {
        this.tin = tin;
    }
    /**
     *
     * @param laboratoryId
     */
    public void setLaboratoryId(String laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

}
