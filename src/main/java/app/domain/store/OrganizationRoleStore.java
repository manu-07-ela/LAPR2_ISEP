package app.domain.store;

import app.domain.model.OrganizationRole;
import java.util.ArrayList;
import java.util.List;

/**
 * Guard and manage instances of the organization's roles
 * @author  Manuela Leite <1200720@isep.ipp.pt>
 */
public class OrganizationRoleStore {
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
    }

    /**
     * Creates a new instance of OrganizationRole receiving an object of type OrganizationRoleDto
     * @param orgRoleDto the DTO organization role
     * @return a organization role
     */
    public OrganizationRole createOrganizationRole(OrganizationRole orgRoleDto){
        return new OrganizationRole(orgRoleDto.getDesignation());
    }



}
