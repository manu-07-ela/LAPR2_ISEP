package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Test {

    /**
     * Client's National Healthcare Service code
     */
    private String nhscode;

    private String description;

    private String internalcode;

    private Client cl;

    /**
     * Constructs an instance of {@code Test} receiving the Client's citizen card number and National Healthcare Service code
     * @param cl
     * @param nhscode
     */
    public Test(Client cl, String nhscode,String description,String internalcode) {
        nhscodeValidation(nhscode);
        this.cl = cl;
        this.nhscode = nhscode;
        this.description = description;
        this. internalcode = internalcode;
    }

    public Client getCl() {
        return cl;
    }

    public String getNhscode() {
        return nhscode;
    }

    public String getDescription() {
        return description;
    }

    public String getInternalcode() {
        return internalcode;
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
        return this.getCl().equals((test).getCl()) || this.getNhscode().equals((test).getNhscode());
    }
}
