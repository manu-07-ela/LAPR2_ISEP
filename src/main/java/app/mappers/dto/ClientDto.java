package app.mappers.dto;

/**
 * Represents a data transfer object of Client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class ClientDto {
    /**
     * Client's name
     */
    private final String name;
    /**
     * Client's citizen card number
     */
    private final String citizencardnumber;

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
    private final String phonenumber;

    /**
     * Client's e-mail
     */
    private final String email;

    /**
     * Creates a new instance of ClientDto with the following attributes: name, citizencardnumber, nhs, date, sex, tin, phonenumber, email
     * @param name name of Client
     * @param citizencardnumber Citizen card number of Client
     * @param nhs National HealthCare Service number of Client
     * @param date Birth-date of Client
     * @param sex Gender of Client
     * @param tin Tax identification number of Client
     * @param phonenumber Phone number of Client
     * @param email E-mail of Client
     */
    public ClientDto(String name, String citizencardnumber, String nhs, String date, String sex, String tin, String phonenumber, String email) {
        this.name = name;
        this.citizencardnumber = citizencardnumber;
        this.nhs = nhs;
        this.date = date;
        this.sex = sex;
        this.tin = tin;
        this.phonenumber = phonenumber;
        this.email = email;
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
    public String getCitizencardnumber() {
        return citizencardnumber;
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
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Get the e-mail of the Client
     * @return the e-mail of ClientDto
     */
    public String getEmail() {
        return email;
    }

}
