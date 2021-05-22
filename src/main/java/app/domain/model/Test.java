package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Test {

    /**
     * Client's citizen card number
     */
    private String citizencardnumber;

    /**
     * Client's National Healthcare Service code
     */
    private String nhscode;

    /**
     * Constructs an instance of {@code Test} receiving the Client's citizen card number and National Healthcare Service code
     * @param citizencardnumber
     * @param nhscode
     */
    public Test(String citizencardnumber, String nhscode) {
        citizencardnumberValidation(citizencardnumber);
        nhscodeValidation(nhscode);
        this.citizencardnumber = citizencardnumber;
        this.nhscode = nhscode;
    }

    public String getCitizencardnumber() {
        return citizencardnumber;
    }

    public String getNhscode() {
        return nhscode;
    }

    private void citizencardnumberValidation(String citizencardnumber){
        if (!StringUtils.isNumeric(citizencardnumber)) throw new IllegalArgumentException("Citizen card number is numeric only.");
        if (citizencardnumber.length()!=16){
            throw  new IllegalArgumentException("The citizen card number must have 16 digits");
        }
    }

    private void nhscodeValidation(String nhscode){
        if (!StringUtils.isNumeric(nhscode)) throw new IllegalArgumentException("National Healthcare Service code is numeric only.");
        if (nhscode.length()!=12){
            throw  new IllegalArgumentException("The National Healthcare Service code must have 12 digits");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Test test = (Test) other;
        return this.getCitizencardnumber().equals((test).getCitizencardnumber()) || this.getNhscode().equals((test).getNhscode());
    }
}
