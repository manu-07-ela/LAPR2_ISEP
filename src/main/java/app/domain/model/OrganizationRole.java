package app.domain.model;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

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
        if (!isValidDesignation(designation)) {
            throw new IllegalArgumentException("Designation must have at maximum 15 characters");
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

    public boolean isValidDesignation(String designation){
        return  designation.length() <= 35 || StringUtils.isBlank(designation);
    }


    /**
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        OrganizationRole that = (OrganizationRole) other;
        return designation.equalsIgnoreCase(that.designation);
    }


}
