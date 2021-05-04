package app.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 * The different categories of parameters existing in a company.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ParameterCategoryStore {

    /**
     * List containing all categories of parameters existing in the Company.
     */
    List<ParameterCategory> parameterCategoryList;

    /**
     * Instantiates a new ParameterCategoryStore.
     */
    public ParameterCategoryStore(){
        parameterCategoryList=new ArrayList();
    }

    /**
     * New parameter category.
     * @param code The parameter category code.
     * @param name The parameter category name.
     * @return The parameter category.
     */
    public ParameterCategory createParameterCategory(String code, String name) {
        return new ParameterCategory(code,name);
    }

    /**
     * Global validation of a Parameter Category.
     * @param pc Parameter category that we intend to validate.
     * @return false if the parameter category already exists or is null. Otherwise, it returns true.
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null)
            return false;
        return !this.parameterCategoryList.contains(pc);
    }

    /**
     * Adds a new parameter category to the List.
     * @param pc Parameter Category we want to add to the list.
     */
    public void addParameterCategory(ParameterCategory pc) {
        parameterCategoryList.add(pc);
    }

    /**
     * Save the parameter category case it is in a valid state.
     * @param pc The parameter category we intend to save.
     * @return true if the parameter category was saved. Otherwise, false.
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if (!validateParameterCategory(pc))
            return false;
        return this.parameterCategoryList.add(pc);
    }

    /**
     *
     * @return The list of existing parameter categories.
     */
    public List<ParameterCategory> getParameterCategoryList(){
        return parameterCategoryList;
    }

    /**
     *
     * @param code
     * @return
     */
    public ParameterCategory getParameterCategoryByCode(String code){
        for (ParameterCategory pc : parameterCategoryList) {
            if (pc.getCode().equals(code)) {
                return pc;
            }
        }
        return null;
    }

}
