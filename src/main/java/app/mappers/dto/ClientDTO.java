package app.mappers.dto;

/**
 * Represents a data transfer object of Client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class ClientDTO {
    /**
     * Client's name
     */
    private final String name;
    /**
     * Client's citizen card number
     */
    private final String citizenCardNumber;

    /**
     * Client's National Healthcare Service number
     */
    private final String nhs;

    /**
     * Client's birth date
     */
    private final String date;

    /**
     * Client's gender
     */
    private final String sex;

    /**
     * Client's tax identification number
     */
    private final String tin;

    /**
     * Client's phone number
     */
    private final String phoneNumber;

    /**
     * Client's e-mail
     */
    private final String email;

    /**
     * Client's adress
     */
    private String address;

    /**
     * Creates a new instance of ClientDto with the following attributes: name, citizencardnumber, nhs, date, sex, tin, phonenumber, email
     * @param name name of Client
     * @param citizenCardNumber Citizen card number of Client
     * @param nhs National HealthCare Service number of Client
     * @param date Birth-date of Client
     * @param sex Gender of Client
     * @param tin Tax identification number of Client
     * @param phoneNumber Phone number of Client
     * @param email E-mail of Client
     * @param address Address of Client
     */
    public ClientDTO(String name, String citizenCardNumber, String nhs, String date, String sex, String tin, String phoneNumber, String email,String address) {
        this.name = name;
        this.citizenCardNumber = citizenCardNumber;
        this.nhs = nhs;
        this.date = date;
        this.sex = sex;
        this.tin = tin;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    /**
     * Creates a new instance of ClientDto with the following attributes: name, citizencardnumber, nhs, date, sex, tin, phonenumber, email
     * @param name name of Client
     * @param citizenCardNumber Citizen card number of Client
     * @param nhs National HealthCare Service number of Client
     * @param date Birth-date of Client
     * @param tin Tax identification number of Client
     * @param phoneNumber Phone number of Client
     * @param email E-mail of Client
     * @param address Address of Client
     */
    public ClientDTO(String name, String citizenCardNumber, String nhs, String date,String tin, String phoneNumber, String email,String address) {
        this.name = name;
        this.citizenCardNumber = citizenCardNumber;
        this.nhs = nhs;
        this.date = date;
        this.tin = tin;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.sex = null;
    }

    /**
     * Get the name of the Client
     * @return the name of ClientDto
     */
    public String getName() {
        return name;
    }

    /**
     * Get the Citizen card number of the Client
     * @return the Citizen card number of ClientDto
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Get the National Healthcare Service number of the Client
     * @return the National Healthcare Service number of ClientDto
     */
    public String getNhs() {
        return nhs;
    }

    /**
     * Get the birth date of the Client
     * @return the birth date of ClientDto
     */
    public String getDate() {
        return date;
    }

    /**
     * Get the gender of the Client
     * @return the gender of ClientDto
     */
    public String getSex() {
        return sex;
    }

    /**
     * Get the Tax identification number of the Client
     * @return the Tax identification number of ClientDto
     */
    public String getTin() {
        return tin;
    }

    /**
     * Get the phone number of the Client
     * @return the phone number of ClientDto
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the e-mail of the Client
     * @return the e-mail of ClientDto
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the address of the client
     * @return the adress of ClientDto
     */
    public String getAddress() {
        return address;
    }

    /**
     * A string with the information of a client
     * @return A string with the information of a client
     */
    @Override
    public String toString() {
        return "Client Data \n" +
                "Name : " + name +
                "\nCitizen Card Number : " + citizenCardNumber +
                "\nNational Healthcare Service number : " + nhs +
                "\nBirth date : " + date +
                "\nGender : " + sex +
                "\nTax identification number : " + tin +
                "\nPhone number : " + phoneNumber +
                "\nEmail : " + email +
                "\nAddress : " + address;
    }
}
