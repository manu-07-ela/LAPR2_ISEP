package app.mappers.dto;

public class OrganizationRoleDTO {
    private String designation;

    public OrganizationRoleDTO(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
