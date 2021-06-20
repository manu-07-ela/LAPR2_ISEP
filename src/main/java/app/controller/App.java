package app.controller;

import app.Serialization;
import app.domain.model.Company;
import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.testrelated.Parameter;
import app.domain.model.testrelated.ParameterCategory;
import app.domain.model.testrelated.TestType;
import app.domain.model.users.Client;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App implements Serializable {
    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return props;
    }
    public Properties getProps(){
        return getProperties();
    }

    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECP,Constants.ROLE_RECP);
        this.authFacade.addUserRole(Constants.ROLE_MED_LAB_TEC,Constants.ROLE_MED_LAB_TEC);
        this.authFacade.addUserRole(Constants.ROLE_CLI_CHE_TEC,Constants.ROLE_CLI_CHE_TEC);
        this.authFacade.addUserRole(Constants.ROLE_SPE_DOCTOR,Constants.ROLE_SPE_DOCTOR);
        this.authFacade.addUserRole(Constants.ROLE_LAB_COD, Constants.ROLE_LAB_COD);
        this.authFacade.addUserRole(Constants.ROLE_CLIENT, Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("Clinical Chemistry Technologist", "cheTec@manylabs.pt", "carlos", Constants.ROLE_CLI_CHE_TEC);
        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Specialist Doctor","doctor@manylabs.pt","654321",Constants.ROLE_SPE_DOCTOR);
        this.authFacade.addUserWithRole("Receptionist", "rep@manylabs.pt", "abcdef", Constants.ROLE_RECP);
        this.authFacade.addUserWithRole("Medical lab Technician", "medLabtec@manylabs.pt", "01928", Constants.ROLE_MED_LAB_TEC);
        this.authFacade.addUserWithRole("Lab Coordinator","labCod@manylabs.pt","000000",Constants.ROLE_LAB_COD);
        this.authFacade.addUserWithRole("Client", "client@manylabs.pt", "pedro", Constants.ROLE_CLIENT);

        this.company = getCompany();
        ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
        company.getParameterCategoryStore().addParameterCategory(pc1);
        ParameterCategory pc2 = new ParameterCategory("KW000","Covid");
        company.getParameterCategoryStore().addParameterCategory(pc2);

        Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
        company.getParameterStore().addParameter(p1);

        Parameter p2 = new Parameter("WBC00","WBC","White Cell Count ",pc1);
        company.getParameterStore().addParameter(p2);

        Parameter p4 = new Parameter("PLT00","PLT","PLTT ",pc1);
        company.getParameterStore().addParameter(p4);

        Parameter p3 = new Parameter("IgGAN","KW","Covid count",pc2);
        company.getParameterStore().addParameter(p3);

        List<ParameterCategory> list1=new ArrayList();
        list1.add(pc1);
        List<ParameterCategory> list2=new ArrayList();
        list2.add(pc2);

        TestType tt = new TestType("BL000","blood","syringe",list1,"ExternalModule2API");
        TestType tt2 = new TestType("CV000","covid","swab",list2,"CovidReferenceValues1API");
        company.getTestTypeStore().addTestType(tt);
        company.getTestTypeStore().addTestType(tt2);
        company.getClientStore().addClient(new Client("Rita","1111111111111111","1231231231","26/11/2002","Female","1231231231","11111111111","rita@gmail.com","Rua das gaitas"));
        company.getClientStore().addClient(new Client("Manuela", "1234567890123456", "1234567890", "07/09/2002", "Female", "1234567890","12345678901", "manu@gmail.com", "Rua 10 do Cerrado"));
        authFacade.addUserWithRole("Rita","rita@gmail.com","111111","CLIENT");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Clinical laboratory", "Rua 20", "12312312312", "1234567890", "1234s",company.getTestTypeStore().getTestTypeList());
        ClinicalAnalysisLaboratory lab2 = new ClinicalAnalysisLaboratory("Clinical laboratoryy", "Rua 203", "12312312313", "1234567891", "001WA",company.getTestTypeStore().getTestTypeList());
        this.company.getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(lab);
        this.company.getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(lab2);



    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance() {
        if(singleton == null) {
            singleton = Serialization.loadApp("SavedData.data");
            if (singleton == null) {
                synchronized (App.class) {
                    singleton = new App();
                }
            } else {

            }
        }
        return singleton;
    }
}
