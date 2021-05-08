package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Represents a phone number of an employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class PhoneNumber {

    /**
     * The phone number of an employee
     */
    private String phoneNumber;

    /**
     * Builds a phone number instance by receiving an phone number by parameter
     * @param phoneNumber
     */
    public PhoneNumber(String phoneNumber) {
        checkRulesForPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Copy builder of phone number
     * @param phoneNumber the phone number
     */
    public PhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = phoneNumber.getPhoneNumber();
    }

    /**
     * Get the phone number
     * @return the phone number
     */
    public String  getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Checks if the business rules applied to the phone number are respected
     * @param phoneNumber the phone number
     */
    private void checkRulesForPhoneNumber(String phoneNumber){
        if (StringUtils.isBlank(phoneNumber)) throw  new NullPointerException("ERROR: Phone number can't be blank.");
        if (!StringUtils.isNumeric(phoneNumber)) throw new IllegalArgumentException("ERROR: Phone number is numeric only.");
        if(phoneNumber.length() != 11) throw  new IllegalArgumentException("ERROR: Phone number must have 11 digits.");
    }

    /**
     * Compare the phone number with other object received
     * @param other Object we want to compare with the phone number
     * @return true if the received object represents another phone number equivalent to the phone number. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        PhoneNumber that = (PhoneNumber) other;
        return Objects.equals(phoneNumber, that.phoneNumber);
    }

}
