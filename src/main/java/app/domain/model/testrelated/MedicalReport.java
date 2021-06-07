package app.domain.model.testrelated;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents a medical report.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class MedicalReport implements Serializable {

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
        checkReportRules(diagnosis);
        this.diagnosis=diagnosis;
        this.createdAt=Calendar.getInstance().getTime();
    }

    /**
     * Checks whether the diagnosis contains all business rules.
     * @param diagnosis diagnosis made by specialist doctor.
     */
    private void checkReportRules (String diagnosis) {
        if (StringUtils.isBlank(diagnosis))
            throw new IllegalArgumentException("Report cannot be blank.");
        String[] aux = diagnosis.split(" ");
        if ( aux.length > 400 )
            throw new IllegalArgumentException("The report should have no more than 400 words.");
    }

    /**
     * Get the medical report creation date.
     */
    public Date getCreatedAt() { return this.createdAt;}

}
