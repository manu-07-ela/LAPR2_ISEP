package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Represents a SOC code of an employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class SocCode {
    /**
     * The SOC code of an employee
     */
    private String code;

    /**
     * Create a SOC code instance receiving a SOC code by parameter
     * @param code the SOC code of an employee
     */
    public SocCode(String code) {
        checkRulesForSocCode(code);
        this.code = code;
    }

    /**
     * Copy builder of SOC code
     * @param code the SOC code
     */
    public SocCode(SocCode code){
            this.code = code.getCode();
    }
    /**
     * Get the SOC code of an employee
     * @return the SOC code
     */
    public String getCode() {
        return code;
    }

    /**
     * Checks if the business rules applied to the SOC code are respected
     * @param socCode the SOC code
     */
    private void checkRulesForSocCode(String socCode){
        if (StringUtils.isBlank(socCode)) throw new NullPointerException("ERROR: SOC code can't be blank.");
        if (!StringUtils.isNumeric(socCode)) throw new IllegalArgumentException("ERROR: SCO code consists only of numbers");
        if (socCode.length() != 4) throw new IllegalArgumentException("ERROR: SOC code must have 4 digits.");
    }

    /**
     * Compare the SOC code with other object received
     * @param other Object we want to compare with the SOC code
     * @return true if the received object represents another SOC code equivalent to the SOC code. Otherwise, it returns false.
     */

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        SocCode socCode1 = (SocCode) other;
        return Objects.equals(code, socCode1.code);
    }

}
