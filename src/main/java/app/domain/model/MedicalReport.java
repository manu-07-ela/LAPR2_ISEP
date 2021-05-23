package app.domain.model;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents a medical report.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class MedicalReport {

    /**
     * The diagnosis of the test.
     */
    private String diagnosis;

    /**
     * The date and time the medical report was created.
     */
    private Date createdAt;

    /**
     * Build an instance of {@code MedicalReport} by receiving the diagnosis.
     * @param diagnosis The report of the test.
     */
    public MedicalReport(String diagnosis){
        this.diagnosis=diagnosis;
        this.createdAt=Calendar.getInstance().getTime();
    }

}
