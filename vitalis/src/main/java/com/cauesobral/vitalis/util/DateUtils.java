package com.cauesobral.vitalis.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

    private DateUtils() {
    }

    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static boolean isPastDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }
}
