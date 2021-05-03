package app.domain.model;

import app.domain.store.ParameterCategoryStore;
import app.domain.store.TestTypeStore;
import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

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
     * @param designation
     */
    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testTypeStore = new TestTypeStore();
        this.parameterCategoryStore = new ParameterCategoryStore();
    }

    /**
     *
     * @return
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
     * Gets the List containing the company's test types.
     * @return the list of test types
     */
    public TestTypeStore getTestTypeStore(){
        return testTypeStore;
    }

    /**
     * 
     * @return
     */
    public ParameterCategoryStore getParameterCategoryStore(){
        return parameterCategoryStore;
    }

}
