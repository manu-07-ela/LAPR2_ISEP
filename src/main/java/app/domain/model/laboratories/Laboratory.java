package app.domain.model.laboratories;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a Laboratory
 * @author Rita Ariana
 */
public abstract class Laboratory {

    /**
     * Name of the Laboratory.
     */
    private String name;

    /**
     * Address of the Laboratory.
     */
    private String address;

    /**
     * Phone Number of the Laboratory.
     */
    private String phoneNumber;

    /**
     * Tin number of the Laboratory.
     */
    private String tin;

    /**
     *
     * @param name the name of the Laboratory.
     * @param address the address of the Laboratory.
     * @param phoneNumber the phone number of the Laboratory.
     * @param tin the tin number of the Laboratory.
     */
    public Laboratory(String name, String address, String phoneNumber, String tin){
        nameValidation(name);
        AddressValidation(address);
        phoneNumberValidation(phoneNumber);
        tinValidation(tin);
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.tin=tin;
    }

    /**
     * Get the name of the Laboratory.
     * @return Laboratory's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the address of the Laboratory.
     * @return Laboratory's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the Phone Number of the Laboratory.
     * @return Laboratory's Phone Number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the tax identification number of the Laboratory.
     * @return Laboratory's tax identification number.
     */
    public String getTin() {
        return tin;
    }

    /**
     * Checks whether the name contains all business rules
     * @param name   Clinical Analysis Laboratory's name
     */
    private void nameValidation(String name){
        if (StringUtils.isBlank(name) || name.length()>20){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters and cannot be blank");
        }

    }
    /**
     * Checks whether the address contains all business rules
     * @param address     Clinical Analysis Laboratory's address
     */
    private void AddressValidation(String address){
        if (StringUtils.isBlank(address) || address.length()>30 ){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters and cannot be blank");
        }
    }
    /**
     * Checks whether the Phone Number contains all business rules
     * @param phoneNumber Clinical Analysis Laboratory's phone number
     */
    private void phoneNumberValidation(String phoneNumber){
        if (StringUtils.isBlank(phoneNumber) || phoneNumber.length()!=11){
            throw  new IllegalArgumentException("Phone number is a number with 11 digits");
        }
    }
    /**
     * Checks whether the tax identification number contains all business rules
     * @param tin Clinical Analysis Laboratory's tax identification number
     */
    private void tinValidation(String tin){
        if (StringUtils.isBlank(tin) || tin.length()!=10){
            throw  new IllegalArgumentException("Tin is a number with 10 digits");
        }
    }


}
