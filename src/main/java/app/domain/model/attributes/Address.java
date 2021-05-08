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
    private String address;

    /**
     * Builds an address instance by receiving an address by parameter
     * @param address the address of an employee
     */
    public Address(String address) {
        checkRulesForAddress(address);
        this.address = address;
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
        return address.equals(address1.address);
    }

    /**
     * Get the address of an employee
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Checks if the business rules applied to the address are respected
     * @param address the address
     */
    private void checkRulesForAddress(String address){
        if (StringUtils.isBlank(address)) throw new IllegalArgumentException("ERROR: Address can´t be blank");

    }
}
