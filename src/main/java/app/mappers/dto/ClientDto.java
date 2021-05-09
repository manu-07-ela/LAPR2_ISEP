package app.mappers.dto;

import app.domain.model.Client;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class ClientDto {
    /**
     * Client's name
     */
    private String name;
    /**
     * Client's citizen card number
     */
    private String citizencardnumber;

    /**
     * Client's National Healthcare Service number
     */
    private String nhs;

    /**
     * Client's birth date
     */
    private String date;

    /**
     * Client's gender
     */
    private String sex;

    /**
     * Client's tax identification number
     */
    private String tin;

    /**
     * Client's phone number
     */
    private String phonenumber;

    /**
     * Client's e-mail
     */
    private String email;

    /**
     * Creates a new instance of ClientDto with the following attributes: name, citizencardnumber, nhs, date, sex, tin, phonenumber, email
     * @param name
     * @param citizencardnumber
     * @param nhs
     * @param date
     * @param sex
     * @param tin
     * @param phonenumber
     * @param email
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

    /**
     * Compare the client dto with the other object provided.
     * @param other Object we want to compare with the client.
     * @return true if the received object represents another client dto equivalent to the client dto. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ClientDto clientdto = (ClientDto) other;
        return this.getName().equals((clientdto).getName()) || this.getCitizencardnumber().equals((clientdto).getCitizencardnumber()) || this.getNhs().equals((clientdto).getNhs()) || this.getDate().equals((clientdto).getDate()) || this.getSex().equals((clientdto).getSex()) || this.getTin().equals((clientdto).getTin()) || this.getPhonenumber().equals((clientdto).getPhonenumber())|| this.getEmail().equals((clientdto).getEmail());
    }
}
