package app.domain.model;

import app.domain.model.attributes.Address;
import app.domain.model.attributes.Name;
import app.domain.model.attributes.PhoneNumber;
import app.domain.model.attributes.SocCode;
import auth.domain.model.Email;
import org.junit.Test;


public class EmployeeTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullIsNotAllowed(){new Employee(new Name(null), new Email(null), new Address(null), new PhoneNumber(null), new SocCode(null), new OrganizationRole(null));}




}