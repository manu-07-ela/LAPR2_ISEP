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
