package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

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
        emailValidation(email);
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

    /**
     *
     * @param name   Client's name
     */
    private void nameValidation(String name){
        if (StringUtils.isBlank(name)) throw new NullPointerException("Name can't be blank.");
        if (name.length()==0 || name.length()>35){
            throw  new IllegalArgumentException("The name mustn't have 0 or more then 35 characters");
        }
    }

    /**
     *
     * @param citizencardnumber
     */
    private void citizencardnumberValidation(String citizencardnumber){
        if (!StringUtils.isNumeric(citizencardnumber)) throw new IllegalArgumentException("Citizen card number is numeric only.");
        if (citizencardnumber.length()!=16){
            throw  new IllegalArgumentException("The citizen card number must have 16 digits");
        }
    }

    /**
     *
     * @param nhs
     */
    private void nhsValidation(String nhs){
        if (!StringUtils.isNumeric(nhs)) throw new IllegalArgumentException("National Healthcare Service number is numeric only.");
        if (nhs.length()!=10){
            throw  new IllegalArgumentException("The nhs must have 10 digits");
        }
    }

    /**
     *
     * @param date
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
     *
     * @param sex
     */
    private void sexValidation(String sex){
        sex=sex.toLowerCase();
        if (!sex.equals("male") && !sex.equals("female") && !sex.equals("")){
            throw  new IllegalArgumentException("The gender must be Male, Female or left blank");
        }
    }

    /**
     *
     * @param tin
     */
    private void tinValidation(String tin){
        if (!StringUtils.isNumeric(tin)){
            throw new IllegalArgumentException("Tax identification number is numeric only.");
        }
        if (tin.length()!=10){
            throw  new IllegalArgumentException("The tin must have 10 digits");
        }
    }

    /**
     *
     * @param phonenumber
     */
    private void phonenumberValidation(String phonenumber){
        if (!StringUtils.isNumeric(phonenumber)){
            throw new IllegalArgumentException("Phone number is numeric only.");
        }
        if (phonenumber.length()!=11){
            throw  new IllegalArgumentException("The phone number must have 11 digits");
        }
    }

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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Client client = (Client) other;
        return this.getName().equals((client).getName()) || this.getCitizencardnumber().equals((client).getCitizencardnumber()) || this.getNhs().equals((client).getNhs()) || this.getDate().equals((client).getDate()) || this.getSex().equals((client).getSex()) || this.getTin().equals((client).getTin()) || this.getPhonenumber().equals((client).getPhonenumber())|| this.getEmail().equals((client).getEmail());
    }

}