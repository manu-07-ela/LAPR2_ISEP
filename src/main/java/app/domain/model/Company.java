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
     * Company's designation
     */
    private final String designation;

    /**
     * Represents an instance Auth facade
     */
    private final AuthFacade authFacade;

    /**
     * Represents an instance of the store of TestTypes
     */
    private final TestTypeStore testTypeStore;

    /**
     * Represents an instance of the store of ParameterCategories
     */
    private final ParameterCategoryStore parameterCategoryStore;

    /**
     * Represents an instance of the store of Parameters
     */
    private final ParameterStore parameterStore;

    /**
     * Represents an instance of the store of ClinicalAnalysisLaboratories
     */
    private final ClinicalAnalysisLaboratoryStore clinicalnAlysisLaboratoryStore;
    /**
     * Represents a instance of the store of employees
     */
    private final EmployeeStore employeeStore;
    /**
     * Represents a instance of the store of organization roles
     */
    private final OrganizationRoleStore organizationRoleStore;
    /**
     * Represents a instance of the store of Client
     */
    private final ClientStore clientStore;

    /**
     * Creates an instance of Company
     * @param designation Company's designation
     */
    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testTypeStore = new TestTypeStore();
        this.parameterStore = new ParameterStore();
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
     * Gets AuthFacade
     * @return The AuthFacade
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
     * @return The ParameterStore
     */
    public ParameterStore getParameterStore(){
        return parameterStore;
    }


    /**
     * Gets the list containing the ClinicalAnalysisLaboratoryStore
     * @return The ClinicalAnalysisLaboratoryStore
     */
    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore(){ return clinicalnAlysisLaboratoryStore; }

    /**
     * Gets the instance of ClientStore
     * @return the instance of clientStore.
     */
    public ClientStore getClientStore() {
        return clientStore;
    }
}