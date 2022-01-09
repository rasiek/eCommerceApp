package fr.cristhiancasierra.prenApp.converters;


import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Converters {

    @TypeConverter
    public static Date fromString(String date) throws ParseException {
        return date == null ? null : new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }

    @TypeConverter
    public static String dateToString(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return date == null ? null : dateFormat.format(date);
    }
}
