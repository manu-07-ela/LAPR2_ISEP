package app.domain.store;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 * The parameters existing in the company.
 *
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ParameterStore {


    /**
     * List containing all categories of parameters existing in the Company.
     */
    private List<Parameter> listParameter;

    /**
     * Instantiates a new Parameter Store.
     */
    public ParameterStore(){
        listParameter = new ArrayList();
    }

    /**
     * Save the parameter case it is in a valid state.
     * @param parameter The type of test we intend to save.
     * @return true if the test type was saved. Otherwise, false.
     */
    public boolean saveParameter(Parameter parameter) {
        if (!validateParameter(parameter))
            return false;
        return this.addParameter(parameter);
    }

    /**
     * Global validation of a test type.
     * @param p Test Type that we intend to validate.
     * @return false if the test type already exists or is null. Otherwise, it returns true.
     */
    public boolean validateParameter(Parameter p) {
        if (p == null)
            return false;
        return !this.listParameter.contains(p);
    }

    /**
     * Adds a new test type to the List.
     * @param p The type of test we intend to add.
     * @return true if the test type was added. Otherwise, false.
     */
    public boolean addParameter(Parameter p) {
        return listParameter.add(p);
    }

    /**
     * New Parameter.
     * @param code The Parameter code.
     * @param shortName The Parameter short name.
     * @param description The Parameter description.
     * @param category The Parameter category.
     */
    /*
    public Parameter createParameter(String code, String shortName, String description, String selectedCategory){
        return new Parameter(code,shortName,description,selectedCategory);
    }*/
    public Parameter createParameter(String code, String shortName, String description,ParameterCategory category){
        return new Parameter(code,shortName,description,category);
    }





    /**
     * Get the Parameter Category List
     * @return parameterCategoryList
     */
    public List<Parameter> getParameterList() {
        return listParameter;
    }





}
