package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a address of an employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class Address {
    /**
     * The adress of an employee
     */
    private String designation;

    /**
     * Builds an address instance by receiving an address by parameter
     * @param address the address of an employee
     */
    public Address(String address) {
        checkRulesForAddress(address);
        this.designation = address;
    }

    /**
     * Copy builder of address
     * @param address the address
     */
    public Address(Address address){
        this.designation = address.getDesignation();
    }


    /**
     * Compare the address with other object received
     * @param other Object we want to compare with the address
     * @return true if the received object represents another address equivalent to the address. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Address address1 = (Address) other;
        return designation.equals(address1.designation);
    }

    /**
     * Get the address of an employee
     * @return the address
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Checks if the business rules applied to the address are respected
     * @param address the address
     */
    private void checkRulesForAddress(String address){
        if (StringUtils.isBlank(address)) throw new IllegalArgumentException("ERROR: Address can´t be blank");
    }
}
