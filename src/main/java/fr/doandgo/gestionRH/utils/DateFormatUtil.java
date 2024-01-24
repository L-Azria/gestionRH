package fr.doandgo.gestionRH.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    private static final String DATE_FORMAT_PATTERN = "dd/MM/yyyy";
    private static final SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    public static Date convertUserInputToDate(String userInput) throws ParseException {
        return INPUT_DATE_FORMAT.parse(userInput);
    }
}
