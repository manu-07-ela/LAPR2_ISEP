package app.mappers;

import app.domain.model.attributes.OrganizationRole;
import app.mappers.dto.OrganizationRoleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * transform objects of type OrganizationRole into objects of type OrganizationRoleDTO
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class OrganizationRoleMapper {
    /**
     *Transforms an object of type OrganizationRole into an object of type OrganizationRoleDTO
     * @param orgRole an OrganizationRole object
     * @return an instance of OrganizationRoleDTO
     */
    public OrganizationRoleDTO toDTO(OrganizationRole orgRole){
        return new OrganizationRoleDTO(orgRole.getDesignation());
    }
    public OrganizationRole toOrganizationRole(OrganizationRoleDTO organizationRoleDTO){
        return new OrganizationRole(organizationRoleDTO.getDesignation());
    }
    /**
     *Transforms a list of objects of type OrganizationRole into a list of objects of type OrganizationRoleDTO
     * @param orgRole a list of organization roles
     * @return a list of organization roles DTO
     */
    public List<OrganizationRoleDTO> listOrgRolesDto(List<OrganizationRole> orgRole){
        List<OrganizationRoleDTO> orgRolesDto = new ArrayList<>();

        for (OrganizationRole role : orgRole){
            orgRolesDto.add(this.toDTO(role));
        }
        return orgRolesDto;

    }
}
