package app.mappers;

/**
 * Represents a data transfer object of organization role
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class OrganizationRoleDTO {
    /**
     * The designation of the data transfer object of the type organization role
     */
    private final String designation;

    /**
     * Creates a new instance of OrganizationRoleDto receiving its designation as a parameter
     * @param designation organization role designation
     */
    public OrganizationRoleDTO(String designation) {
        this.designation = designation;
    }

    /**
     * Get the designation of a organization role
     * @return designation of the OrganizationRoleDto
     */
    public String getDesignation() {
        return designation;
    }
}
