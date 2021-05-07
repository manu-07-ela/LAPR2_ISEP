package app.domain.model;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Client {
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

    public Client(String name, String citizencardnumber, String nhs, String date, String sex, String tin, String phonenumber, String email) {
        nameValidation(name);
        citizencardnumberValidation(citizencardnumber);
        nhsValidation(nhs);
        dateValidation(date);
        sexValidation(sex);
        tinValidation(tin);
        phonenumberValidation(phonenumber);
        this.name = name;
        this.citizencardnumber = citizencardnumber;
        this.nhs = nhs;
        this.date = date;
        this.sex = sex;
        this.tin = tin;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCitizencardnumber() {
        return citizencardnumber;
    }

    public String getNhs() {
        return nhs;
    }

    public String getDate() {
        return date;
    }

    public String getSex() {
        return sex;
    }

    public String getTin() {
        return tin;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCitizencardnumber(String citizencardnumber) {
        this.citizencardnumber = citizencardnumber;
    }

    public void setNhs(String nhs) {
        this.nhs = nhs;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param name   Client's name
     */
    private void nameValidation(String name){
        if (name.length()==0 || name.length()>35){
            throw  new IllegalArgumentException("The name mustn't have 0 or more then 35 characters");
        }
    }

    /**
     *
     * @param citizencardnumber
     */
    private void citizencardnumberValidation(String citizencardnumber){
        if (citizencardnumber.length()!=16){
            throw  new IllegalArgumentException("The citizen card number must have 16 digits");
        }
    }

    /**
     *
     * @param nhs
     */
    private void nhsValidation(String nhs){
        if (nhs.length()!=10){
            throw  new IllegalArgumentException("The nhs must have 10 digits");
        }
    }

    /**
     *
     * @param date
     */
    private void dateValidation(String date){
        if (date.trim().equals("")){
            throw  new IllegalArgumentException("The data mustn't be null");
        }
        else{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            try {
                format.parse(date);
            }
            catch (ParseException e) {
                throw  new IllegalArgumentException("The data must be valid and have this format DD/MM/YYYY");
            }
        }
    }

    /**
     *
     * @param sex
     */
    private void sexValidation(String sex){
        sex=sex.toLowerCase();
        if (!sex.equals("male") && !sex.equals("female")){
            throw  new IllegalArgumentException("The sex must be Male or Female");
        }
    }

    /**
     *
     * @param tin
     */
    private void tinValidation(String tin){
        if (tin.length()!=10){
            throw  new IllegalArgumentException("The tin must have 10 digits");
        }
    }

    /**
     *
     * @param phonenumber
     */
    private void phonenumberValidation(String phonenumber){
        if (phonenumber.length()!=11){
            throw  new IllegalArgumentException("The phone number must have 11 digits");
        }
    }
}
