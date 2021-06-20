package app.domain.model;

import app.domain.model.laboratories.ClinicalAnalysisLaboratory;
import app.domain.model.users.Client;
import org.junit.Assert;
import org.junit.Test;


public class CSVFileReaderTest {

    @Test(expected = IllegalArgumentException.class)
    public void clientValidation(){
        Client cl= new Client("José David Teixeira Pessoa Pessoa Pessoa","1234567891234567","1234567891","12/12/1995","1231231231","12345678900","pessoa@gmail.com","Avenida da República");
    }

    @Test
    public void laboratoryValidation(){
        Company company = new Company("Many Labs");
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Clinical laboratory", "Rua 20", "12312312312", "1234567890", "1234s",company.getTestTypeStore().getTestTypeList());
        String s1 ="working";
        String s2 ="Not working";
        if(lab!=null){
            s2="working";
        }
        Assert.assertEquals(s1,s2);
    }

    @Test
    public void clientnullValidation() {
        Client cl = new Client("José David Teixeira Pessoa", "1234567891234567", "1234567891", "12/12/1995", "1231231231", "12345678900", "pessoa@gmail.com", "Avenida da República");
        String s1 = "working";
        String s2 = "Not working";
        if (cl != null) {
            s2 = "working";
        }
        Assert.assertEquals(s1, s2);
    }
}