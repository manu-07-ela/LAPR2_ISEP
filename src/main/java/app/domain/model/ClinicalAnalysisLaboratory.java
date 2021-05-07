package app.domain.model;

import app.mappers.dto.ClinicalAnalysisLaboratoryDTO;

import java.util.List;
import java.util.Objects;

/**
 * @author Carlos Rodrigues <1201001@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratory extends Laboratory {
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
        super(name, address, phoneNumber, tin);
        laboratoryIdValidation(laboratoryId);
        this.laboratoryId=laboratoryId;
        this.listOfTestTypes=listOfTestTypes;
    }

    /**
     *
     * @param calDTO
     */
    public ClinicalAnalysisLaboratory(ClinicalAnalysisLaboratoryDTO calDTO) {
        super(calDTO.getName(), calDTO.getAddress(), calDTO.getPhoneNumber(), calDTO.getTin());
        laboratoryIdValidation(calDTO.getLaboratoryId());
        this.laboratoryId= calDTO.getLaboratoryId();
        this.listOfTestTypes= calDTO.getListOfTestTypes();
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
     * @param laboratoryId Clinical Analysis Laboratory's ID
     */
    private void laboratoryIdValidation(String laboratoryId){
        if (laboratoryId.length()>5){
            throw  new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
        }
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
        return this.getAddress().equals((that).getAddress()) || this.getLaboratoryId().equals((that).getLaboratoryId()) || this.getTin()==(that).getTin() || this.getPhoneNumber()==(that).getPhoneNumber();
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
