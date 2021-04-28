package io.beatcorp.cp.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtil {

    public static String getToday(String formatter) {
        // formatter = "yyyy-MM-dd"
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatter));
    }

    public static String getYesterday(String formatter) {
        // formatter = "yyyy-MM-dd"
        return LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern(formatter));
    }
}
