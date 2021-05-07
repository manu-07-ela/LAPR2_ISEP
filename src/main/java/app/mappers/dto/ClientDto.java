package app.mappers.dto;

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
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the Citizen card number of the Client
     * @return
     */
    public String getCitizencardnumber() {
        return citizencardnumber;
    }

    /**
     * Get the National Healthcare Service number of the Client
     * @return
     */
    public String getNhs() {
        return nhs;
    }

    /**
     * Get the birth date of the Client
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Get the gender of the Client
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     * Get the Tax identification number of the Client
     * @return
     */
    public String getTin() {
        return tin;
    }

    /**
     * Get the phone number of the Client
     * @return
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Get the e-mail of the Client
     * @return
     */
    public String getEmail() {
        return email;
    }
}
