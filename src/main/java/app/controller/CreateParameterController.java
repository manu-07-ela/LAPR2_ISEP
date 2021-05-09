package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import app.mappers.ParameterCategoryMapper;
import app.mappers.dto.ParameterCategoryDto;
import java.util.List;

/**
 * The Create Parameter Controller.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */

public class CreateParameterController {

    /**
     *
     */
    private App app;

    /**
     *
     */
    private Company company;

    /**
     *
     */
    private Parameter p;

    /**
     *
     */
    private ParameterCategoryStore pcStore;

    /**
     *
     */
    private ParameterStore pStore;

    /**
     *
     */
    private ParameterCategoryMapper pcMapper;



    /**
     * Instantiates a new Create Parameter Controller.
     */
    public CreateParameterController() {
        this.app = app.getInstance();
        this.company = app.getCompany();
        this.pcStore = company.getParameterCategoryStore();
        this.pStore = company.getParameterStore();
        pcMapper = new ParameterCategoryMapper();
    }

    /**
     * Instantiates a new Create Parameter Controller.
     * @param company
     */
    public CreateParameterController(Company company) {
        this.company = company;
        this.pcStore = company.getParameterCategoryStore();
        this.pStore = company.getParameterStore();
        pcMapper = new ParameterCategoryMapper();
    }

    /**
     * Get a list of objects of type ParameterCategoryDTO
     * @return list with parameterCategoriesDto
     */
    public List<ParameterCategoryDto> getParameterCategories(){
        List<ParameterCategory> listParameterCategories = pcStore.getParameterCategoryList();
        return pcMapper.toDto(listParameterCategories);
    }

    /**
     * New parameter.
     * @param code The parameter code.
     * @param shortName the parameter code.
     * @param description The description of the parameter.
     * @param selectedCategoryDto The category of the parameter.
     * @return false if the parameter already exists or is null. Otherwise, it returns true.
     */

    public Parameter createParameter(String code, String shortName, String description, ParameterCategoryDto selectedCategoryDto){
        ParameterCategory selected = pcStore.getParameterCategoryByCode(selectedCategoryDto.getCode());
        p = pStore.createParameter(code,shortName,description,selected);
        pStore.validateParameter(p);
        return p;
    }

    /**
     * Save the parameter if it is in a valid state.
     * @return true if the parameter was saved. Otherwise, false.
     */
    public boolean saveParameter(Parameter par) {
        return pStore.saveParameter(par);
    }

    /**
     * Textual description of the parameter.
     * @return Information about the characteristics of the parameter.
     */
    public String toString(){
        return p.toString();
    }






}
