package app.mappers.dto;

import app.domain.model.testrelated.ParameterCategory;

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
     * Compare the date dto with the other object provided.
     * @param o Object we want to compare with the date dto.
     * @return true if the received object represents another date dto equivalent to the date dto. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        DateDTO otherDate = (DateDTO) o;

        return this.getDateString().equals(otherDate.getDateString());
    }

    /**
     * Get the Date formatted.
     * @return dateString
     */
    public String getDateString() {
        return dateString;
    }


    /**
     * Textual description of a date
     * @return Information that characterizes a date
     */
    @Override
    public String toString() {
        return String.format("%s",dateString);
    }
}
