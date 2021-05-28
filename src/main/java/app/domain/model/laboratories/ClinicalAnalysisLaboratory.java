package app.domain.model.laboratories;

import app.domain.model.testRelated.TestType;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

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
     * Build an instance of Clinical Analysis Laboratory
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     * @param laboratoryId            Clinical Analysis Laboratory's ID
     * @param listOfTestTypes         List of Test Type that the Clinical Analysis Laboratory does
     */
    public ClinicalAnalysisLaboratory(String name, String address, String phoneNumber , String tin, String laboratoryId, List<TestType> listOfTestTypes){
        super(name,address,phoneNumber,tin);
        laboratoryIdValidation(laboratoryId);
        listOfTestTypesValidation(listOfTestTypes);
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
     * Checks whether the LaboratoryId contains all business rule
     * @param laboratoryId Clinical Analysis Laboratory's ID
     */
    private void laboratoryIdValidation(String laboratoryId){
        if (StringUtils.isBlank(laboratoryId) || !StringUtils.isAlphanumeric(laboratoryId) || laboratoryId.length() != 5 ) {
            throw new IllegalArgumentException("The laboratoryId must have only 5 alphanumeric characters");
        }
    }

    /**
     * Checks whether the LaboratoryId contains all business rule
     * @param listOfTestTypes List of Test Type that the Clinical Analysis Laboratory does
     */
    private void listOfTestTypesValidation(List<TestType> listOfTestTypes) {
        if (listOfTestTypes==null){
            throw new IllegalArgumentException("The list of Test Types mustn't be null");
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
