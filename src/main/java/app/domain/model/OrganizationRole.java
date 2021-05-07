package app.domain.model;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a role in organization
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class OrganizationRole {
    /**
     * The designation of a role in organization.
     */
    String designation;

    /**
     * Constructs an instance of {@code OrganizationRole} receiving the designation.
     * @param designation characterizes the role in the organization.
     */
    public OrganizationRole(String designation){
        if (!isValidDesignation()) {
            throw new IllegalArgumentException("Designation must have at maximum 15 charcters");
        }
        this.designation = designation;

    }

    /**
     * Get the designation.
     * @return The designation of an Organization Role.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Textual description of an Organization Role
     * @return Information that characterizes an organization role.
     */
    @Override
    public String toString() {
        return String.format("designation= %s%n", designation);
    }

    /**
     * Checks whether the designation associated with the organization role we intend to create complies with all business rules.
     * @return true if the designation obeys the rules imposed by the business, false otherwise.
     */
    public boolean isValidDesignation(){
        return  designation.length() <= 15 || StringUtils.isBlank(designation);
    }
}
