package com.test.instagramservices.mapper;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateMapper {

    private DateMapper() {
    }

    public static String getPublishedTime(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(date, now);
        return getStringDateFormat(diff);
    }

    private static String getStringDateFormat(Duration diff) {
        long days = diff.toDays();
        long hours = diff.toHours();
        long minutes = diff.toMinutes();
        long seconds = diff.toSeconds();

        if (days >= 1) {
            return days + "d";
        } else if (hours >= 1) {
            return hours + "h";
        } else if (minutes >= 1) {
            return minutes + "m";
        }
        return seconds + "s";
    }
}
