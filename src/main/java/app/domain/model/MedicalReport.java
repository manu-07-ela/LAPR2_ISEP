package app.domain.model;

/**
 * Represents a medical report.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class MedicalReport {

    /**
     * The report of the test.
     */
    private String report;

    /**
     * Build an instance of {@code MedicalReport} by receiving the report.
     * @param report The report of the test.
     */
    public MedicalReport(String report){
        this.report=report;
    }

}
