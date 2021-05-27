package app.mappers;

import app.mappers.dto.DateDTO;
import java.util.Date;

/**
 * Transform objects of type Date into objects of type DateDTO
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */


public class DateMapper {

    /**
     * Transforms an object of type Test into an object of type TestDTO
     * @param date a Test object
     * @return an instance of TestDTO
     */
    public DateDTO toDto(Date date){
        return new DateDTO(date);
    }


}
