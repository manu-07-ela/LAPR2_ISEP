package app.domain.model;

public class EmployeeRole {
    String designation;

    public EmployeeRole(String designation){
        if (!isValidDesignation()) {
            throw new IllegalArgumentException("Designation must have at maximum 15 charcters");
        }
        this.designation = designation;

    }

    public boolean isValidDesignation(){
        return  designation.length()<=15;
    }
}
