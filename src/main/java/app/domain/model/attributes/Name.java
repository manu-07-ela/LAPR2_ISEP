package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Represents the name of an employee
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class Name {
    /**
     *The name of an employee
     */
    private String name;

    /**
     *Create a name instance receiving a name by parameter
     * @param name the name of an employee
     */
    public Name(String name){
        checkRulesForName(name);
        this.name = name.trim();
    }

    /**
     *Get the name of an employee
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *Checks if the business rules applied to the name are respected
     * @param name The name
     */
    private void checkRulesForName(String name){
        if (name.length()>35) throw new IllegalArgumentException("ERROR: Name need to have maximum 15 characters");
        if (StringUtils.isBlank(name)) throw new NullPointerException("ERROR: Name can't be blank.");
    }

    /**
     *Compare the doctor name with other object received
     * @param other Object we want to compare with the name
     * @return true if the received object represents another name equivalent to the name. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Name name1 = (Name) other;
        return Objects.equals(name, name1.name);
    }


}
