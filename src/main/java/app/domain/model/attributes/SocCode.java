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
    private int socCode;

    /**
     * Create a SOC code instance receiving a SOC code by parameter
     * @param socCode the SOC code of an employee
     */
    public SocCode(int socCode) {
        checkRulesForSocCode(socCode);
        this.socCode = socCode;
    }

    /**
     * Get the SOC code of an employee
     * @return the SOC code
     */
    public int getSocCode() {
        return socCode;
    }

    /**
     * Checks if the business rules applied to the SOC code are respected
     * @param socCode the SOC code
     */
    private void checkRulesForSocCode(int socCode){
        if (StringUtils.isBlank(Integer.toString(socCode))) throw new IllegalArgumentException("ERROR: SOC can't be blank.");
        if (Integer.toString(socCode).length() != 4) throw new IllegalArgumentException("ERROR: SOC code must have 4 digits.");
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocCode socCode1 = (SocCode) o;
        return socCode == socCode1.socCode;
    }

}
