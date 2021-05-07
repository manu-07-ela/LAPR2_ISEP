package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Laboratory {
    /**
     * Clinical Analysis Laboratory's name
     */
    private String name;

    /**
     * Clinical Analysis Laboratory's address
     */
    private String address;

    /**
     * Clinical Analysis Laboratory's phone number
     */
    private String phoneNumber;

    /**
     * Clinical Analysis Laboratory's tax identification number
     */
    private String tin;



    /**
     *
     * @param name                    Clinical Analysis Laboratory's name
     * @param address                 Clinical Analysis Laboratory's address
     * @param phoneNumber             Clinical Analysis Laboratory's phone number
     * @param tin                     Clinical Analysis Laboratory's tax identification number
     */
    public Laboratory(String name, String address, String  phoneNumber , String tin){
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
     *
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }
    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     *
     * @return
     */
    public String getTin() {
        return tin;
    }
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     *
     * @param tin
     */
    public void setTin(String tin) {
        this.tin = tin;
    }

    /**
     *
     * @param name   Clinical Analysis Laboratory's name
     */
    private void nameValidation(String name){
        if (StringUtils.isBlank(name)){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters");
        }else if(name.length()>20){
            throw  new IllegalArgumentException("The name mustn't have more than 20 characters");
        }

    }

    /**
     *
     * @param address     Clinical Analysis Laboratory's address
     */
    private void AddressValidation(String address){
        if (StringUtils.isBlank(address)){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters");
        }else if (address.length()>30){
            throw  new IllegalArgumentException("The address mustn't have more than 30 characters");
        }
    }

    /**
     *
     * @param phoneNumber
     */
    private void phoneNumberValidation(String phoneNumber){
        if (StringUtils.isBlank(phoneNumber)){
            throw  new IllegalArgumentException("Phone number has to have 11 digits");
        }else if (phoneNumber.length()!=11){
            throw  new IllegalArgumentException("Phone number has to have 11 digits");
        }
    }

    /**
     *
     * @param tin
     */
    private void tinValidation(String tin){
        if (StringUtils.isBlank(tin)){
            throw  new IllegalArgumentException("Tin has to have 10 digits");
        }else if (tin.length()!=10){
            throw  new IllegalArgumentException("Tin has to have 10 digits");
        }
    }







}
