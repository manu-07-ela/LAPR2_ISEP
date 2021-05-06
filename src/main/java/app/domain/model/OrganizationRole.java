package app.domain.model;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class OrganizationRole {
    String designation;

    public OrganizationRole(String designation){
        if (!isValidDesignation()) {
            throw new IllegalArgumentException("Designation must have at maximum 15 charcters");
        }
        this.designation = designation;

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "designation='" + designation + '\'' +
                '}';
    }

    public boolean isValidDesignation(){
        return  designation.length() <= 15 || !ObjectUtils.allNotNull(designation) || StringUtils.isBlank(designation);
    }
}
