package app.domain.model;

import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import app.domain.store.TestTypeStore;
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
    private ParameterStore parameterStore;

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
     * Represents a instance of the store of Client
     */
    private ClientStore clientStore;
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
        this.clientStore = new ClientStore();
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
     * Get the instance of TestTypeStore.
     * @return the instance of TestTypeStore.
     */
    public TestTypeStore getTestTypeStore(){
        return testTypeStore;
    }

    /**
     * Get the instance of ParameterCategoryStore.
     * @return the instance of ParameterCategoryStore.
     */
    public ParameterCategoryStore getParameterCategoryStore(){
        return parameterCategoryStore;
    }

    /**
     * Gets the list containing the company's parameters.
     * @return
     */
    public ParameterStore getParameterStore(){
        return parameterStore;
    }


    /**
     *
     * @return
     */
    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore(){ return clinicalnAlysisLaboratoryStore; }

    /**
     * Gets the instance of ClientStore
     * @return
     */
    public ClientStore getClientStore() {
        return clientStore;
    }
}
