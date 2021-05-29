
package app;

import app.domain.model.attributes.*;
import app.domain.model.users.SpecialistDoctor;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpecialistDoctorTest {

    SpecialistDoctor spDoc;

    @Before
    public void setup(){
        spDoc = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123456"));
    }

    @Test(expected = NullPointerException.class)
    public void ensureSpecialistDoctorNullIsNotAllow(){
        new SpecialistDoctor(null, null, null, null, null, null, null);
    }

    @Test
    public void getDoctorIndexNumber() {
        DoctorIndexNumber expectedResult = new DoctorIndexNumber("123456");
        DoctorIndexNumber result = spDoc.getDoctorIndexNumber();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testEquals() {
        SpecialistDoctor spDoc1 = new SpecialistDoctor(new Name("Manuela de Araujo Leite"), new Email("1200720@isep.ipp.pt"), new Address("Rua 15"),new PhoneNumber("12338725367"),new SocCode("1234"), new OrganizationRole("Specialist Doctor"), new DoctorIndexNumber("123126"));
        SpecialistDoctor spDoc2 = spDoc1;

        Assert.assertEquals(spDoc1, spDoc2);
        Assert.assertNotEquals(spDoc1, spDoc);


    }
}
