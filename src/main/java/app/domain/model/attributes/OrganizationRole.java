package app.domain.model.attributes;
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
       checkRulesForDesignation(designation);
        this.designation = designation;
    }

    /**
     * Copy builder of organizationRole
     * @param orgRole the organization role
     */
    public OrganizationRole(OrganizationRole orgRole){
        this.designation = orgRole.getDesignation();
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
     * @param designation true if the designation obeys the rules imposed by the business, false otherwise.
     */
    public void checkRulesForDesignation(String designation){
        if (StringUtils.isBlank(designation)) throw new NullPointerException("ERROR: designation can't be blank.");
        if (designation.length() > 35) throw new IllegalArgumentException("ERROR: designation must have maximum 35 characters.");
    }

    /**
     * Compare the organization role with the other object provided.
     * @param other Object we want to compare with the organization role.
     * @return true if the received object represents another organization role equivalent to the organization role. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        OrganizationRole that = (OrganizationRole) other;
        return designation.equalsIgnoreCase(that.designation);
    }


}
