package app.domain.store;

import app.domain.model.attributes.OrganizationRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Guard and manage instances of the organization's roles
 * @author  Manuela Leite <1200720@isep.ipp.pt>
 */
public class OrganizationRoleStore implements Serializable {
    /**
     * List that contains all the organizational roles played in the company
     */
    private List<OrganizationRole> listOrgRoles;

    /**
     * Get the list of all organization roles
     * @return The list of organization roles
     */
    public List<OrganizationRole> getListOrgRoles() {

        return listOrgRoles;
    }

    /**
     * Instantiates a new OrganizationRoleStore.
     */
    public OrganizationRoleStore() {
        this.listOrgRoles = new ArrayList<>();
        listOrgRoles.add(new OrganizationRole("ADMINISTRATOR"));
        listOrgRoles.add(new OrganizationRole("RECEPTIONIST"));
        listOrgRoles.add(new OrganizationRole("MEDICAL LAB TECHNICIAN"));
        listOrgRoles.add(new OrganizationRole("CLINICAL CHEMISTRY TECHNICIAN"));
        listOrgRoles.add(new OrganizationRole("SPECIALIST DOCTOR"));
        listOrgRoles.add(new OrganizationRole("LABORATORY COORDINATOR"));
    }

    /**
     * Creates a new instance of OrganizationRole receiving an object of type OrganizationRoleDto
     * @param orgRole the DTO organization role
     * @return a organization role
     */
    public OrganizationRole createOrganizationRole(OrganizationRole orgRole){
        if (validateOrganizationRole(orgRole)) throw new IllegalArgumentException("This Organization Role do not exist in Company");
        return new OrganizationRole(orgRole);
    }

    /**
     * Global validation of Organization role
     * @param orgRole Organization Role that we intend to validate.
     * @return false if the organizationRole already exists or is null. Otherwise, it returns true.
     */
    public  boolean validateOrganizationRole(OrganizationRole orgRole){
        return !listOrgRoles.contains(orgRole);
    }

    /**
     * save a new organization role in the List.
     * @param organizationRole Organization role we intend to save.
     * @return true if the organization role was saved, false otherwise;
     */
    public boolean saveOrganizationRole(OrganizationRole organizationRole){
        if (validateOrganizationRole(organizationRole) && organizationRole!= null)
            return listOrgRoles.add(organizationRole);
        return false;

    }

}
