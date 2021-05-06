package app.domain.store;
import app.domain.model.OrganizationRole;

import java.util.ArrayList;
import java.util.List;

public class OrganizationRoleStore {

    private List<OrganizationRole> listOrgRoles;

    public List<OrganizationRole> getListOrgRoles() {
        return listOrgRoles;
    }

    public OrganizationRoleStore() {
        this.listOrgRoles = new ArrayList<>();
    }

    public OrganizationRole createOrganizationRole(OrganizationRole orgRoleDto){
        return new OrganizationRole(orgRoleDto.getDesignation());
    }



}
