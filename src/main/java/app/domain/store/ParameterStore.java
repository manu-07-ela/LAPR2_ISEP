package app.domain.store;

import app.domain.model.Parameter;

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
     * New Parameter.
     * @param code The Parameter code.
     * @param shortName The Parameter short name.
     * @param description The Parameter description.
     * @param selectedCategory The Parameter category.
     */
    public Parameter createParameter(String code, String shortName, String description, String selectedCategory){
        return new Parameter(code,shortName,description,selectedCategory);
    }


    /**
     * Global validation of a parameter.
     * @param parameter The parameter we intend to validate.
     * @return false if the parameter already exists or is null. Otherwise, it returns true.
     */
    public boolean validateParameter(Parameter parameter) {
        if (parameter == null)
            return false;
        return !this.listParameter.contains(parameter);
    }

    /**
     * Adds a new parameter to the List.
     * @param parameter The parameter we intend to add.
     * @return true if the parameter was added. Otherwise, false.
     */
    public boolean addParameter(Parameter parameter) {
        return listParameter.add(parameter);
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
     * Get the Parameter Category List
     * @return parameterCategoryList
     */
    public List<Parameter> getParameterList() {
        return listParameter;
    }





}
