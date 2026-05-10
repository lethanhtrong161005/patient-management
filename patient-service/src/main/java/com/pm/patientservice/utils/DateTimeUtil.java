package com.pm.patientservice.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateTimeUtil {
    public static LocalDate convertInstantToLocalDate(Instant instant) {
        if (instant == null) {
            return null;
        }
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
