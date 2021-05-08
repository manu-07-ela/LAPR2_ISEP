package app.domain.model;

import app.domain.model.attributes.*;
import auth.domain.model.Email;
import org.junit.Test;


public class EmployeeTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullIsNotAllowed(){new Employee(null, null, null, null, null, null);}




}