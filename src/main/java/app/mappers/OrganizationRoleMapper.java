package app.mappers;

import app.domain.model.OrganizationRole;
import app.mappers.dto.OrganizationRoleDTO;

import java.util.ArrayList;
import java.util.List;

public class OrganizationRoleMapper {

    public OrganizationRoleDTO toDTO(OrganizationRole orgRole){
        return new OrganizationRoleDTO(orgRole.getDesignation());
    }

    public List<OrganizationRoleDTO> listOrgRolesDto(List<OrganizationRole> orgRole){
        List<OrganizationRoleDTO> orgRolesDto = new ArrayList<>();

        for (OrganizationRole role : orgRole){
            orgRolesDto.add(this.toDTO(role));
        }
        return orgRolesDto;

    }
}
