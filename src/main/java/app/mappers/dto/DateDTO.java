package app.mappers.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a data transfer object of Date
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */

public class DateDTO {
    /**
     * Represents the date
     */
    private Date date;

    /**
     * Represents the formatted date associated with a date
     */
    private String dateString;

    /**
     * Copy builder for a date
     * @param dateDto the date to be copied
     */
    public DateDTO(Date dateDto) {
        this.date = dateDto;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        this.dateString = sdf.format(date);
    }

    /**
     * Textual description of a date
     * @return Information that characterizes a date
     */
    @Override
    public String toString() {
        return String.format("Date %s",dateString);
    }
}
