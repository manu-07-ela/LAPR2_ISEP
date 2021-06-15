package app.controller;

import app.domain.model.Company;

import java.util.List;

public class SendCovid19ReportController {

    /**
     * Represents an instance of app.
     */
    private App app;

    /**
     * Represents a instance of company.
     */
    private Company company;

    /**
     * Constructs an instance of {@code SendCovid19ReportController}.
     */
    public SendCovid19ReportController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
    }

    /**
     * Constructs an instance of {@code SendCovid19ReportController} receiving a company.
     * @param company The company.
     */
    public SendCovid19ReportController(Company company) {
        this.app=App.getInstance();
        this.company =company;
    }

    public List<String> getAvailableTypesOfData(){
        return company.getAvailableTypesOfData();
    }


}
