package app.domain.model;

import app.domain.store.*;
import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    /**
     *
     */
    private String designation;

    /**
     *
     */
    private AuthFacade authFacade;

    /**
     *
     */
    private TestTypeStore testTypeStore;

    /**
     *
     */
    private ParameterCategoryStore parameterCategoryStore;

    /**
     *
     */
    private ClinicalAnalysisLaboratoryStore clinicalnAlysisLaboratoryStore;
    /**
     * Represents a instance of the store of employees
     */
    private EmployeeStore employeeStore;
    /**
     * Represents a instance of the store of organization roles
     */
    private OrganizationRoleStore organizationRoleStore;
    /**
     *
     * @param designation
     */

    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testTypeStore = new TestTypeStore();
        this.parameterCategoryStore = new ParameterCategoryStore();
        this.clinicalnAlysisLaboratoryStore = new ClinicalAnalysisLaboratoryStore();
        this.employeeStore = new EmployeeStore();
        this.organizationRoleStore = new OrganizationRoleStore();
    }

    /**
     * Get the company designation.
     * @return The company designation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     *
     * @return
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Get the instance of employee store
     * @return the instance of employee store
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * Get the instance of organization role store
     * @return the instance of organization role store
     */
    public OrganizationRoleStore getOrganizationRoleStore() {
        return organizationRoleStore;
    }

    /**
     * Gets the List containing the company's test types.
     * @return the list of test types
     */
    public TestTypeStore getTestTypeStore(){
        return testTypeStore;
    }

    /**
     * Gets the list containing the company's parameter categories.
     * @return
     */
    public ParameterCategoryStore getParameterCategoryStore(){
        return parameterCategoryStore;
    }

    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore(){
        return clinicalnAlysisLaboratoryStore;
    }


    /**
     *
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     * @param laboratoryId            Clinical Analysis Laboratory's ID
     * @param listOfTestTypes         List of Test Type that the Clinical Analysis Laboratory does
     * @return
     */
    public ClinicalAnalysisLaboratory createClinicalAnalysisLaboratory (String name, String address, int phoneNumber , int tin, String laboratoryId, List<TestType> listOfTestTypes){
        return new ClinicalAnalysisLaboratory(name,address,phoneNumber,tin,laboratoryId,listOfTestTypes);
    }


}
