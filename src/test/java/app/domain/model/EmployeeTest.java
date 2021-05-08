package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){Employee emp = new Employee(null, null, null, null, null, null);}

}