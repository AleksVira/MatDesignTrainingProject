package ru.virarnd.matdesigntrainingproject.model;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Spot {
    private String name;
    private Location location;
    private Date date;
    private String photoUri;

    public Spot(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }


    public String getStringDate() {
        String pattern = "dd.MM yyyy";
        return new SimpleDateFormat(pattern, Locale.US).format(date);
    }
}
