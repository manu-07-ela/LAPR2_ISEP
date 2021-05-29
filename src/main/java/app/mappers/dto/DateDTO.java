package app.mappers.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a data transfer object of Date
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */

public class DateDTO {
    /**
     * Date Dto
     */
    private Date date;

    /**
     *
     */
    private String dateString;


    public DateDTO(Date dateDto) {
        this.date = dateDto;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        this.dateString = sdf.format(date);
    }

    @Override
    public String toString() {
        return String.format("Date %s",dateString);
    }
}
