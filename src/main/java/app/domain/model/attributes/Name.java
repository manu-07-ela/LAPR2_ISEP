package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

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
        this.name = name;
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
        if (name.length()>15) throw  new IllegalArgumentException("ERROR: Name need to have maximum 15 characters");
        if (StringUtils.isBlank(name)) throw new IllegalArgumentException("ERROR: Name can't be blank.");
    }
}
