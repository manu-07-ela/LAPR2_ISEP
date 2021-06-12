package app.domain.model.users;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * Represents the controller used to register a client
 * @author José Pessoa <1201007@isep.ipp.pt>
 */

public class Client implements Serializable {
    private static final long serialVersionUID = -4183378503982040686L;
    /**
     * Client's name
     */
    private String name;
    /**
     * Client's citizen card number
     */
    private String citizenCardNumber;

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
    private String phoneNumber;

    /**
     * Client's e-mail
     */
    private String email;

    /**
     * Constructs an instance of {@code Client} receiving the name, Citizen card number, National Healthcare Service number, birth date, gender, tax identification number, phone number and e-mail
     * @param name name of Client
     * @param citizenCardNumber Citizen card number of Client
     * @param nhs National HealthCare Service number of Client
     * @param date Birth-date of Client
     * @param sex Gender of Client
     * @param tin Tax identification number of Client
     * @param phoneNumber Phone number of Client
     * @param email E-mail of Client
     */
    public Client(String name, String citizenCardNumber, String nhs, String date, String sex, String tin, String phoneNumber, String email) {
        nameValidation(name);
        citizenCardNumberValidation(citizenCardNumber);
        nhsValidation(nhs);
        dateValidation(date);
        sexValidation(sex);
        tinValidation(tin);
        phoneNumberValidation(phoneNumber);
        emailValidation(email);
        this.name = name;
        this.citizenCardNumber = citizenCardNumber;
        this.nhs = nhs;
        this.date = date;
        this.sex = sex;
        this.tin = tin;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Constructs an instance of {@code Client} receiving the name, Citizen card number, National Healthcare Service number, birth date, gender, tax identification number, phone number and e-mail
     * @param name name of Client
     * @param citizenCardNumber Citizen card number of Client
     * @param nhs National HealthCare Service number of Client
     * @param date Birth-date of Client
     * @param tin Tax identification number of Client
     * @param phoneNumber Phone number of Client
     * @param email E-mail of Client
     */
    public Client(String name, String citizenCardNumber, String nhs, String date, String tin, String phoneNumber, String email) {
        nameValidation(name);
        citizenCardNumberValidation(citizenCardNumber);
        nhsValidation(nhs);
        dateValidation(date);
        tinValidation(tin);
        phoneNumberValidation(phoneNumber);
        emailValidation(email);
        this.name = name;
        this.citizenCardNumber = citizenCardNumber;
        this.nhs = nhs;
        this.date = date;
        this.tin = tin;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Get the name of a client
     * @return the name of client
     */
    public String getName() {
        return name;
    }

    /**
     * Get the Citizen card number of a client
     * @return the Citizen card number of client
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Get the National Healthcare Service number of a client
     * @return the National Healthcare Service number of client
     */
    public String getNhs() {
        return nhs;
    }

    /**
     * Get the birth date of a client
     * @return the birth date of client
     */
    public String getDate() {
        return date;
    }

    /**
     * Get the gender of a client
     * @return the gender of client
     */
    public String getSex() {
        return sex;
    }

    /**
     * Get the tax identification number of a client
     * @return the tax identification number of client
     */
    public String getTin() {
        return tin;
    }

    /**
     * Get the phone number of a client
     * @return the phone number of client
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the e-mail of a client
     * @return the e-mail of client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the name of a client
     * @param name the name of a client
     */
    public void setName(String name) {
        nameValidation(name);
        this.name = name;
    }
    /**
     * Sets the Citizen card number of a client
     * @param citizenCardNumber the Citizen card number of a client
     */
    public void setCitizenCardNumber(String citizenCardNumber) {
        citizenCardNumberValidation(citizenCardNumber);
        this.citizenCardNumber = citizenCardNumber;
    }
    /**
     * Sets the National Healthcare Service number of a client
     * @param nhs the National Healthcare Service number of a client
     */
    public void setNhs(String nhs) {
        nhsValidation(nhs);
        this.nhs = nhs;
    }
    /**
     * Sets the birth date of a client
     * @param date the birth date of a client
     */
    public void setDate(String date) {
        dateValidation(date);
        this.date = date;
    }
    /**
     * Sets the gender of a client
     * @param sex the gender of a client
     */
    public void setSex(String sex) {
        sexValidation(sex);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", citizenCardNumber='" + citizenCardNumber + '\'' +
                ", nhs='" + nhs + '\'' +
                ", date='" + date + '\'' +
                ", sex='" + sex + '\'' +
                ", tin='" + tin + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * Sets the tax identification number of a client
     * @param tin the tax identification number of a client
     */
    public void setTin(String tin) {
        tinValidation(tin);
        this.tin = tin;
    }
    /**
     * Sets the phone number of a client
     * @param phoneNumber the phone number of a client
     */
    public void setPhoneNumber(String phoneNumber) {
        phoneNumberValidation(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
    /**
     * Sets the e-mail of a client
     * @param email the e-mail of a client
     */
    public void setEmail(String email) {
        emailValidation(email);
        this.email = email;
    }

    /**
     * Checks whether the name associated with the client we intend to register complies with all business rules.
     * @param name The Client's name
     */
    private void nameValidation(String name){
        if (StringUtils.isEmpty(name)) throw new NullPointerException("Name can't be blank.");
        if (name.length()==0 || name.length()>35){
            throw  new IllegalArgumentException("The name mustn't have 0 or more then 35 characters");
        }
    }

    /**
     * Checks whether the citizen card number associated with the client we intend to register complies with all business rules.
     * @param citizenCardNumber The Client's citizen card number
     */
    private void citizenCardNumberValidation(String citizenCardNumber){
        if (StringUtils.isEmpty(citizenCardNumber)) throw new NullPointerException("Citizen card number can't be empty");
        if (!StringUtils.isNumeric(citizenCardNumber)) throw new IllegalArgumentException("Citizen card number is numeric only.");
        if (citizenCardNumber.length()!=16){
            throw  new IllegalArgumentException("The citizen card number must have 16 digits");
        }

    }

    /**
     * Checks whether the National Healthcare Service number associated with the client we intend to register complies with all business rules.
     * @param nhs The Client's National Healthcare Service number
     */
    private void nhsValidation(String nhs){
        if (StringUtils.isEmpty(nhs)) throw new NullPointerException("NHS code can't be empty");
        if (!StringUtils.isNumeric(nhs)) throw new IllegalArgumentException("National Healthcare Service number is numeric only.");
        if (nhs.length()!=10){
            throw  new IllegalArgumentException("The nhs must have 10 digits");
        }

    }

    /**
     * Checks whether the birth date associated with the client we intend to register complies with all business rules.
     * @param date The Client's birth date
     */
    private void dateValidation(String date) {
        if (!date.trim().equals("")) {
        if (parseInt(date.substring(6, 10)) < 1870) {
                throw new IllegalArgumentException("The Client cant be born before the year 1870");
            } else {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);
                try {
                    format.parse(date);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("The data must be valid and have this format DD/MM/YYYY");
                }
            }
        }else{
            throw new IllegalArgumentException("The data mustn't be null");
        }
    }

    /**
     * Checks whether the gender associated with the client we intend to register complies with all business rules.
     * @param sex The Client's gender
     */
    private void sexValidation(String sex){
        sex=sex.toLowerCase();
        if (!sex.equals("male") && !sex.equals("female") && !sex.equals("")){
            throw  new IllegalArgumentException("The gender must be Male, Female or left blank");
        }
    }

    /**
     * Checks whether the tax identification number associated with the client we intend to register complies with all business rules.
     * @param tin The Client's tax identification number
     */
    private void tinValidation(String tin){
        if (StringUtils.isEmpty(tin)) throw new NullPointerException("Tax Identification Number can't be empty");
        if (!StringUtils.isNumeric(tin)){
            throw new IllegalArgumentException("Tax identification number is numeric only.");
        }
        if (tin.length()!=10){
            throw  new IllegalArgumentException("The tin must have 10 digits");
        }

    }

    /**
     * Checks whether the phone number associated with the client we intend to register complies with all business rules.
     * @param phoneNumber The Client's phone number
     */
    private void phoneNumberValidation(String phoneNumber){
        if (StringUtils.isEmpty(phoneNumber)) throw new NullPointerException("Phone number can't be empty");
        if (!StringUtils.isNumeric(phoneNumber)){
            throw new IllegalArgumentException("Phone number is numeric only.");
        }
        if (phoneNumber.length()!=11){
            throw  new IllegalArgumentException("The phone number must have 11 digits");
        }

    }

    /**
     * Checks whether the e-mail associated with the client we intend to register complies with all business rules.
     * @param email The Client's e-mail
     */
    private void emailValidation(String email){
        if (StringUtils.isBlank(email)){
            throw new IllegalArgumentException("E-mail can't be blank");
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if(!pat.matcher(email).matches()){
            throw new IllegalArgumentException("Invalid E-mail Address");
        }
    }

    /**
     * Compare the client with the other object provided.
     * @param other Object we want to compare with the client.
     * @return true if the received object represents another client equivalent to the client. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Client client = (Client) other;
        return this.getCitizenCardNumber().equals((client).getCitizenCardNumber()) || this.getNhs().equals((client).getNhs()) || this.getTin().equals((client).getTin()) || this.getPhoneNumber().equals((client).getPhoneNumber())|| this.getEmail().equals((client).getEmail());
    }

}