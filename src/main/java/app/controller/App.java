package app.controller;

import app.domain.model.Company;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

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

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECP,Constants.ROLE_RECP);
        this.authFacade.addUserRole(Constants.ROLE_MED_LAB_TEC,Constants.ROLE_MED_LAB_TEC);
        this.authFacade.addUserRole(Constants.ROLE_CLI_CHE_TEC,Constants.ROLE_CLI_CHE_TEC);
        this.authFacade.addUserRole(Constants.ROLE_SPE_DOCTOR,Constants.ROLE_SPE_DOCTOR);
        this.authFacade.addUserRole(Constants.ROLE_LAB_COD, Constants.ROLE_LAB_COD);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Specialist Doctor","doctor@manylabs.pt","654321",Constants.ROLE_SPE_DOCTOR);
        this.authFacade.addUserWithRole("Receptionist", "rep@manylabs.pt", "abcdef", Constants.ROLE_RECP);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}
