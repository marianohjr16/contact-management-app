package com.ms3.codeexer.contactmgmtapp.converter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateStringConverter {
    private static final String DATE_FORMAT = "MM/dd/yyyy";

    public static String convertToDateString(Date dateToConvert) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(dateToConvert);
    }

    public static Date convertToSqlDate(final String dateStr){
        try
        {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            java.util.Date parsed = dateFormat.parse(DATE_FORMAT);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            return sqlDate;
        }
        catch(ParseException pe)
        {
            return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        }
    }
}
