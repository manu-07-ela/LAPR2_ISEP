package app.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * Transforms a list of objects of type Date into a list of objects of type DateDTO
     * @param dateList a list of Dates
     * @return a list of DateDTO
     */
    public List<DateDTO> toDto(List<Date> dateList) {
        List<DateDTO> dateListDto =new ArrayList();
        DateDTO objDTO;
        for (Date lista : dateList) {
            if (lista != null){
                objDTO = toDto(lista);
                dateListDto.add(objDTO);
            }
        }
        return dateListDto;
    }


}
