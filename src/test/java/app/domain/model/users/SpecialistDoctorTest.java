
package app.domain.model.users;

import app.domain.model.attributes.*;
import app.domain.model.users.SpecialistDoctor;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpecialistDoctorTest {

    @Test(expected = NullPointerException.class)
    public void ensureSpecialistDoctorNullIsNotAllow(){
        new SpecialistDoctor(null, null, null, null, null, null, null);
    }

    @Test
    public void getDoctorIndexNumber() {
        SpecialistDoctor spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        DoctorIndexNumber expectedResult = new DoctorIndexNumber("123456");
        DoctorIndexNumber result = spDoc.getDoctorIndexNumber();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testEquals() {
        SpecialistDoctor spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        SpecialistDoctor spDoc1 = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));


        Assert.assertTrue(spDoc.equals(spDoc1));
    }

    @Test
    public void testEqualsReference() {
        SpecialistDoctor spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        SpecialistDoctor spDoc1 = spDoc;


        Assert.assertTrue(spDoc.equals(spDoc1));
    }

    @Test
    public void testEqualsNull() {
        SpecialistDoctor spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        SpecialistDoctor spDoc1 = null;


        Assert.assertFalse(spDoc.equals(spDoc1));
    }

    @Test
    public void testEqualsOtherClass() {
        SpecialistDoctor spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        Address name2 = new Address("Rua das cavalas");


        Assert.assertFalse(spDoc.equals(name2));
    }

    @Test
    public void testEquals2() {
        SpecialistDoctor spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
        SpecialistDoctor spDoc1 = new SpecialistDoctor(new Name("Manuela de Ara"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123126"));


        Assert.assertFalse(spDoc.equals(spDoc1));
    }

}
