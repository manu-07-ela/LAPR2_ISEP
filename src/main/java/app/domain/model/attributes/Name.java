package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

public class Name {
    private String name;

    public Name(String name){
        if(!isValidName(name)) {
            throw new IllegalArgumentException("Name need to have maximum 15 characters");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    /**
     * Checks whether the name associated with the employee we intend to create complies with all business rules.
     * @return true if the name obeys the rules imposed by the business, false otherwise.
     */
    private boolean isValidName(String name){
        return name.length()<=15 || StringUtils.isBlank(name);
    }
}
