package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a phone number of an employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class PhoneNumber {

    /**
     * The phone number of an employee
     */
    private double phoneNumber;

    /**
     * Builds a phone number instance by receiving an phone number by parameter
     * @param phoneNumber
     */
    public PhoneNumber(double phoneNumber) {
        checkRulesForPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the phone number
     * @return the phone number
     */
    public double getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Checks if the business rules applied to the phone number are respected
     * @param phoneNumber the phone number
     */
    private void checkRulesForPhoneNumber(double phoneNumber){
        if (StringUtils.isBlank(Double.toString(phoneNumber))) throw  new IllegalArgumentException("ERROR: Phone number can't be blank.");
        if(Double.toString(phoneNumber).length() != 11) throw  new IllegalArgumentException("ERROR: Phone number must have 11 digits.");
    }
}
