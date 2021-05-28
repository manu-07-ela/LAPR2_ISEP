package app.controller;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.testRelated.Parameter;
import app.domain.model.testRelated.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import app.mappers.ParameterCategoryMapper;
import app.mappers.dto.ParameterCategoryDTO;
import java.util.List;

/**
 * The Create Parameter Controller.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */

public class CreateParameterController {

    /**
     * Represents an instance of app.
     */
    private App app;

    /**
     * Represents a instance of company.
     */
    private final Company company;

    /**
     * Represents an instance of parameter.
     */
    private Parameter p;

    /**
     * Represents an instance of the parameter category store.
     */
    private final ParameterCategoryStore pcStore;

    /**
     * Represents an instance of the parameter store.
     */
    private final ParameterStore pStore;

    /**
     * Represents an instance of the parameter category mapper.
     */
    private final ParameterCategoryMapper pcMapper;



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
    public List<ParameterCategoryDTO> getParameterCategories(){
        List<ParameterCategory> listParameterCategories = pcStore.getParameterCategoryList();
        return pcMapper.toDto(listParameterCategories);
    }

    /**
     * New parameter.
     * @param code The parameter code.
     * @param shortName the parameter code.
     * @param description The description of the parameter.
     * @param selectedCategoryDto The category of the parameter.
     * @return Parameter created.
     */
    public boolean createParameter(String code, String shortName, String description, ParameterCategoryDTO selectedCategoryDto){
        ParameterCategory selected = pcStore.getParameterCategoryByCode(selectedCategoryDto.getCode());
        p = pStore.createParameter(code,shortName,description,selected);
        return pStore.validateParameter(p);
    }

    /**
     * Save the parameter if it is in a valid state.
     * @return true if the parameter was saved. Otherwise, false.
     */
    public boolean saveParameter() {
        return pStore.saveParameter(p);
    }

    /**
     * Textual description of the parameter.
     * @return Information about the characteristics of the parameter.
     */
    public String toString(){
        return p.toString();
    }

}
